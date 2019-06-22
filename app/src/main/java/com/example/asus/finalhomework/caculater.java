package com.example.asus.finalhomework;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class caculater{
    public String Date="2010-10-10";
    public String res;
    public String standardDate;
    public caculater(String Date) throws ParseException {
        super();
        this.Date=Date;
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
       // SimpleDateFormat s1 = new SimpleDateFormat("yyyy年MM月dd日");

        Date nowDate = new Date();

       // Date targetDate1 = s1.parse(Date);
        Date targetDate = s.parse(Date);
         long month=targetDate.getMonth()+1;
        standardDate=targetDate.getYear()+1900+"年"+month+"月"+targetDate.getDate()+"日";
      //  standardDate =s.format(targetDate1);
        Log.i("bitch","test"+standardDate);
        long num=targetDate.getTime();
        long nowdate = nowDate.getTime();
        long time = nowdate - num;
        long result=time / 1000 / 60 / 60 / 24 ;

        if (result>0){
            String Date1=String.valueOf(result);
            res="已经过去"+Date1+"天了";
            Log.i("bitch",">0"+result);
        }else if (result==0){
            res="就是今天！";
            Log.i("bitch","=0"+result);
        }else if (result<0){
            String Date1=String.valueOf(result*(-1));
            Log.i("bitch","<0"+result);
            res="还有"+Date1+"天";
        }
    }
    public String getResultDate(){
        return res;
    }
    public String getStandardDate(){
        return standardDate;
    }


}
