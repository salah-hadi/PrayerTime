package com.calculating.prayer.Util;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Locale;
import java.util.Date;


public final class SuperData {


    private static SuperData _instance;

    public static SuperData getInstance(){
        if (null == _instance){
            _instance =new SuperData();
        }
        return _instance;
    }


    public SuperData() {
    }

    public String getDate(){

        //Calendar get Date ( years - Month - day )
        Calendar date=Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd", Locale.forLanguageTag("EN"));

        return dateFormat.format(date.getTime());

    }


    public String getHour(String Time){
        /*
         * like
         * Time = 11:15mp
         * print :  11Hour
         *
         */

        Time =Time.substring(0,2);
        if (Time.charAt(0) == '0'){

            Time =Time.substring(1,2);
        }

        return Time;
    }
    public String getMinute(String Time){
        /*
         * like
         * Time = 11:15mp
         * print :  15Minute
         */
        Time =Time.substring(3,5);
        if (Time.charAt(0) =='0'){

            Time =Time.substring(1,2);
        }
        return Time;
    }
    public String getFormat(String Time){
        /*
         * like
         * Time = 11:15mp
         * print :  mp Format
         */
        Time =Time.substring(5,7);

        return Time;
    }

    public  String FormatTime(String Timie){
        if (Timie==null)return "00:00";


        // Convert time 24h to 12h and Select time are Am or Pm
        SimpleDateFormat format=new SimpleDateFormat("hh:mm aa", Locale.forLanguageTag("EN"));
        Date date = new Date();

        try {


            date= new SimpleDateFormat("K:mm").parse(Timie);



        } catch (ParseException e) {
            e.printStackTrace();

        }


        return format.format(date);
    }


}
