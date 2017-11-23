package com.privatee.mylibrary.utils;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * 类的作用：压缩包的一些工具类
 * Created by WJT on  2017/11/9 11:17.
 */

public class ZipTools {


    /**使用GBK编码可以避免压缩中文文件名乱码*/
    private static final String CHINESE_CHARSET = "GBK";
    /**文件读取缓冲区大小*/
    private static final int CACHE_SIZE = 1024;

    private static String PREFIX = "\\u";
    /**
     * 解压压缩包
     * @param zipFilePath 压缩文件路径
     * @param destDir 解压到哪里的目录
     */
    public static ArrayList<File> unZip(String zipFilePath, String destDir) {
        ArrayList<File> fileList = new ArrayList<File>();
        ZipFile zipFile = null;
        try {
            BufferedInputStream bis = null;
            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            zipFile = new ZipFile(zipFilePath, CHINESE_CHARSET);
            Enumeration<ZipEntry> zipEntries = zipFile.getEntries();
            File file, parentFile;
            ZipEntry entry;
            byte[] cache = new byte[CACHE_SIZE];
            while (zipEntries.hasMoreElements()) {
                entry = (ZipEntry) zipEntries.nextElement();
                if (entry.isDirectory()) {
                    new File(destDir+ entry.getName()).mkdirs();
                    continue;
                }
                bis = new BufferedInputStream(zipFile.getInputStream(entry));
                file = new File(destDir+"/"+ entry.getName());
                parentFile = file.getParentFile();
                if (parentFile != null && (!parentFile.exists())) {
                    parentFile.mkdirs();
                }
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos, CACHE_SIZE);
                int readIndex = 0;
                while ((readIndex = bis.read(cache, 0, CACHE_SIZE)) != -1) {
                    fos.write(cache, 0, readIndex);
                }
                bos.flush();
                bos.close();
                fos.close();
                bis.close();
                fileList.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileList;
    }
}
