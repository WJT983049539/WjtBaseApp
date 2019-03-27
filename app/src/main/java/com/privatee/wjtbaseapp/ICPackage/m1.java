package com.privatee.wjtbaseapp.ICPackage;

import com.privatee.wjtbaseapp.ICPackage.Declare;
import com.sun.jna.Native;


public class m1
{
    /**
     * @param args
     */
    short st=1;
    int icdev ;
    byte Snr[]=new byte[5];

    public void DevConnect(Declare.mwrf epen)
    {
        byte[] ver=new byte[20];
        icdev =epen.rf_init((short)0, 9600);
        st=epen.rf_get_status(icdev, ver);
        if(st==0)
        {
            String str=new String(ver,0,18);
            System.out.println("设备初始化成功！" + str);
        }
        else
        {
            System.out.println("设备连接失败!");
        }
        for(short i=0;i<16;i++)
        {
            byte[] key=new byte[]{(byte)0xff,(byte)0xff,(byte)0xff,(byte)0xff,(byte)0xff,(byte)0xff};
            st=epen.rf_load_key(icdev, (short)0, i, key);
            if(st!=0)
            {
                System.out.println("加载 "+i+" 扇区密码失败!");
            }
        }
        epen.rf_beep(icdev, (short)30);
    }
    public void mifareOne(Declare.mwrf epen)
    {
        short sector=1;
        st=epen.rf_card(icdev,(short)1,Snr);
        if(st==0)
        {
            byte[] Snrhex=new byte[9];
            epen.hex_a(Snr,Snrhex,(short)4);
            String str=new String(Snrhex,0,8);
            System.out.println(str);
        }
        else
        {
            System.out.println("寻卡失败！");
        }
        st=epen.rf_authentication(icdev, (short)0, sector);
        if(st!=0)
        {
            System.out.println(sector+"扇区密码验证 错误!");
        }
//		String str="深圳明华澳汉科技";
//		byte[] wdata=str.getBytes();
//		st=epen.rf_write(icdev, (short)(sector*4), wdata);
//		if(st!=0)
//		{
//			System.out.println(sector+"扇区写数据失败");
//		}
        byte[] rdata=new byte[17];
        st=epen.rf_read(icdev, (short)(sector*4), rdata);
        if(st==0)
        {
            String stri=new String(rdata);
            System.out.println("读数据成功，数据： "+stri);
        }
        else
        {
            System.out.println("读数据失败！");
        }
//		String key="ffffffffffff";
//		byte[] wkey=key.getBytes();
//		byte[] wkeyhex=new byte[7];
//		epen.a_hex(wkey, wkeyhex, (short)wkey.length);
//		st=epen.rf_changeb3(icdev, (short)sector, wkeyhex, (short)0, (short)0, (short)0, (short)1, (short)0, wkeyhex);
//		if(st!=0)
//		{
//			System.out.println("改密码失败！");
//		}
//		else
//		{
//			System.out.println("改密码成功！");
//		}
    }
    public void disconnectDev(Declare.mwrf epen)
    {
        epen.rf_exit(icdev);
        //System.out.println("断开设备");
    }
    public void MifarePROCpu(Declare.mwrf epen)
    {
        byte[] resetData=new byte[50];
        st=epen.rf_card(icdev,(short)1,Snr);
        if(st==0)
        {
            byte[] Snrhex=new byte[9];
            epen.hex_a(Snr,Snrhex,(short)4);
            String str=new String(Snrhex,0,8);
            System.out.println(str);
        }
        else
        {
            System.out.println("寻卡失败！");
        }
        st=epen.rf_pro_rst(icdev, resetData);
        if(st!=0)
        {
            System.out.println("复位失败！"+st);
        }
        else
        {
            byte[] resetDataHex=new byte[100];
            epen.hex_a(resetData, resetDataHex, (short)resetData.length);
            String str=new String(resetDataHex,0,resetData[0]*2);
            System.out.println("复位成功！"+str);
        }
        byte[] cmd=new byte[]{0x00,0x00,0x00,0x05,0x00,(byte)0x84,0x00,0x00,0x08};
        byte[] returnData=new byte[50];
        byte[] returnDataHex=new byte[100];
        st=epen.rf_pro_trn(icdev, cmd, returnData);
        if(st!=0)
        {
            System.out.println("发送命令失败！");
        }
        else
        {
            epen.hex_a(returnData, returnDataHex, (short)(returnData[3]+4));
            String strData=new String(returnDataHex,0,(short)(returnData[3]+4)*2);
            System.out.println(strData);
        }
    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Declare.mwrf epen = (Declare.mwrf) Native.loadLibrary("mwrf32", Declare.mwrf.class);
        if (epen != null)
            System.out.println("DLL加载成功！");
        else
            System.out.println("DLL加载失败！");
        m1 con=new m1();
        con.DevConnect(epen);
        con.mifareOne(epen);
        con.MifarePROCpu(epen);
        con.disconnectDev(epen);
    }
}
