package com.privatee.wjtbaseapp.A_M.A_interface;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author wjt
 * @date 2019/8/26 15:54
 * @contact 983049539@qq.com
 */
public class uodatetime {
    public static uodatetime uodatetime1;
    public Timer timer;
    private static IshowTime ishowTime;
    private uodatetime(){}
    public static uodatetime getInstance(IshowTime ishowTime2){
        ishowTime=ishowTime2;
        if(uodatetime1==null){
            uodatetime1=new uodatetime();
        }
        return uodatetime1;
    }
    public void start(){
      if(timer==null){
          timer=new Timer();
          timer.schedule(new TimerTask() {
              @Override
              public void run() {
                  ishowTime.show();
              }
          },0,1000);
      }else{
          timer.cancel();
          timer=new Timer();
          timer.schedule(new TimerTask() {
              @Override
              public void run() {
                  ishowTime.show();
              }
          },0,1000);
      }
    }

    public void stop(){
        if(timer!=null){
            timer.cancel();
        }
    }
}
