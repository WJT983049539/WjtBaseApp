package com.privatee.wjtbaseapp.A_V.activity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.os.BuildCompat;
import androidx.core.os.EnvironmentCompat;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.FileTools;
import com.privatee.mylibrary.utils.ImageUtils;
import com.privatee.wjtbaseapp.A_V.customview.ListDialog;
import com.privatee.wjtbaseapp.R;

import org.apache.tools.ant.util.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * @author:create by
 * 邮箱 983049539@qq.com
 */

public class PhotoActivity extends BaseActivity {

    private ImageView ivCamera;
    private ImageView ivPhoto;
    private final String TAG="photo";
    // 拍照的requestCode
    private static final int CAMERA_REQUEST_CODE = 0x00000010;
    //相册
    private static final int PICTURE = 0x00000020;
    // 申请相机权限的requestCode
    private static final int PERMISSION_CAMERA_REQUEST_CODE = 0x00000012;
    /**
     * 用于保存拍照图片的uri
     */
    private Uri mCameraUri;

    /**
     * 用于保存图片的文件路径，Android 10以下使用图片路径访问图片
     */
    private String mCameraImagePath;

    /**
     *  是否是Android 10以上手机
     */
    private boolean isAndroidQ = BuildCompat.isAtLeastQ();
    private int CAMERA_WITH_DATA=0;

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.photo;
    }

    @Override
    public void inintView() {
        ivCamera = findViewById(R.id.ivCamera);
        ivPhoto = findViewById(R.id.ivPhoto);

        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermissionAndCamera();
            }
        });
    }
    /**
     * 检查权限并拍照。
     * 调用相机前先检查权限。
     */
    private void checkPermissionAndCamera() {
        int hasCameraPermission = ContextCompat.checkSelfPermission(getApplication(),
                Manifest.permission.CAMERA);
        if (hasCameraPermission == PackageManager.PERMISSION_GRANTED) {
            //有权限，调起相机拍照。

              ArrayList<String> photoData = new ArrayList<String>(){{add("1@拍照");add("2@从相册中选择");}};
            ListDialog listDialog=new ListDialog(PhotoActivity.this, new ListDialog.DialogItemClickListener() {
                @Override
                public void onItemClik(int position, String id, String text, int chooseIndex) {
                    if(id.equals("1")){
                        openCamera();
                    }else if(id.equals("2")){
                        //打开图库
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_PICK);
                        PhotoActivity.this.startActivityForResult(intent, PICTURE);
                    }
                }
            },photoData,0);
            listDialog.show();
        } else {
            //没有权限，申请权限。需要加上请求码
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},
                    PERMISSION_CAMERA_REQUEST_CODE);
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_CAMERA_REQUEST_CODE);
        }
    }
    private void openCamera() {

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.d(TAG,"openCamera 1");
            File outputImage = new File(getExternalCacheDir(),"output_image.jpg");	//内部存储设备/Android/data/com.example.choosepictest/cache/output_image.jpg
            try {
                if(outputImage.exists()) {
                    outputImage.delete();
                }
                outputImage.createNewFile();
                Log.d(TAG,"openCamera createNewFile");
            } catch(IOException e) {
                Log.d(TAG,"openCamera e1");
                e.printStackTrace();
            }
            //Android 7.0  FileProvider传入Uri对象
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                mCameraUri = FileProvider.getUriForFile(PhotoActivity.this,
                        "com.privatee.wjtbaseapp.fileprovider",outputImage);
            }else{
                mCameraUri = Uri.fromFile(outputImage);
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mCameraUri);
            startActivityForResult(intent,CAMERA_REQUEST_CODE);	//TAKE_PHOTO 拍摄好之后直接保存， TAKE_PHOTO2 拍摄并裁剪后保存
        }else {
            Log.d(TAG,"openCamera cannot access Storage ");
        }

    }
    /**
     * 创建保存图片的文件
     */
    private File createImageFile() throws IOException {
        String imageName = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date())+".jpg";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!storageDir.exists()) {
            storageDir.mkdir();
        }
        File tempFile = new File(storageDir, imageName);
        if (!Environment.MEDIA_MOUNTED.equals(EnvironmentCompat.getStorageState(tempFile))) {
            return null;
        }
        return tempFile;
    }
    /**
     * 创建图片地址uri,用于保存拍照后的照片 Android 10以后使用这种方法
     * @return 图片的uri
     */
    private Uri createImageUri() {
        String status = Environment.getExternalStorageState();
        // 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        } else {
            return getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new ContentValues());
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String prent=Environment.getExternalStorageDirectory()+"/temp";
        if(!new File(prent).exists()){
            new File(prent).mkdirs();
        }
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                File outputImage = new File(getExternalCacheDir(),"output_image.jpg");
                String path=Environment.getExternalStorageDirectory()+"/temp/"+Math.abs(Math.random())+".jpg";
                try {
                    copyFile(outputImage.getAbsolutePath(),path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Bitmap bb=BitmapFactory.decodeFile(outputImage.getAbsolutePath());
                ivPhoto.setImageBitmap(bb);
            } else {
                Toast.makeText(this,"取消",Toast.LENGTH_LONG).show();
            }
        }else if(requestCode == PICTURE){ //相册
            if (resultCode == RESULT_OK){
            try {
                Uri uri = data.getData();
               Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(PhotoActivity.this.getContentResolver(), uri);
               String path= ImageUtils.saveFile(bitmap2);
                Bitmap bb=BitmapFactory.decodeFile(path);
                ivPhoto.setImageBitmap(bb);
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }
    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 复制文件到另一个路径下
     * @param readfile
     * @param writefile
     * @return
     * @throws Exception
     */
    public  boolean copyFile(String readfile, String writefile) throws Exception
    {
        if(!new File(writefile).exists()){
            new File(writefile).createNewFile();
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 定义两个直连的文件管道
        FileChannel in = null, out = null;
        fis = new FileInputStream(readfile);
        fos = new FileOutputStream(writefile);
        in = fis.getChannel();
        out = fos.getChannel();
        // 直接让流流向要拷贝的文件
        out.transferFrom(in, 0, in.size());
        in.close();
        out.close();
        fis.close();
        fos.close();
        return true;
    }

}
