package com.calculating.prayer;


import com.calculating.prayer.Algorithms.Methods;
import com.calculating.prayer.Util.Formats;
import com.calculating.prayer.Util.OnPrayerTime;

public class Main {

    public static void main(String[] args) {
      	// write your code here26.157062009617036, 32.715735063540045

        Methods methods = new Methods(
                2021,
                9,
                11,
                2,
                26.157062009617036,
                32.715735063540045

        );

        methods.setOnPrayerTime(Formats.HH_MM_AA_12, null);
       // methods.Start();


//        SuperData data = SuperData.getInstance();
//        System.out.println(" المغرب"+data.FormatTime(methods.getTawqitSunset()));
//        System.out.println(" شروق"+data.FormatTime(methods.getTawqitSunrise()));
//        System.out.println(" العصر"+data.FormatTime(methods.getTawqitAlAsr()));
//        System.out.println(" الضهر "+data.FormatTime(methods.getTawqitAlzuhr()));
//        System.out.println(" العشاء"+data.FormatTime(methods.getTawqitIsha()));
//        System.out.println(" الفجر"+data.FormatTime(methods.getTawqitFajr()));
//        System.out.println("ــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ");
        System.out.println(" المغرب"+methods.getTawqitSunset());
        System.out.println(" شروق"+methods.getTawqitSunrise());
        System.out.println(" العصر"+methods.getTawqitAlAsr());
        System.out.println(" الضهر "+methods.getTawqitAlzuhr());
        System.out.println(" العشاء"+methods.getTawqitIsha());
        System.out.println(" الفجر"+methods.getTawqitFajr());
    }
//   new OnPrayerTime() {
//        @Override
//        public void prayer1(String Fajr) {
//            System.out.println(Fajr);
//        }
//
//        @Override
//        public void prayer2(String Sunrise) {
//            System.out.println(Sunrise);
//        }
//
//        @Override
//        public void prayer3(String Alzuhr) {
//            System.out.println(Alzuhr);
//        }
//
//        @Override
//        public void prayer4(String AlAsr) {
//            System.out.println(AlAsr);
//        }
//
//        @Override
//        public void prayer5(String Sunset) {
//            System.out.println(Sunset);
//        }
//
//        @Override
//        public void prayer6(String Isha) {
//
//            System.out.println(Isha);
//        }
//    }
}
