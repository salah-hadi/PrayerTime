package com.calculating.prayer.Algorithms;


import com.calculating.prayer.Util.Formats;
import com.calculating.prayer.Util.OnPrayerTime;
import com.calculating.prayer.Util.SuperData;

public class Methods extends Agorithms {





    /**
    * Current year to be calculator
     * @param Year
    */
    private int Year;


    /**
     * Current Month to be calculator
     * @param Month
     */
    private int Month;


    /**
     * Current Day to be calculator
     * @param Day
     */
    private int Day;


    /**
     * The geographical  latitude of the location of the country
     * or region to be calculated
     * @param latitude
     */
    private double  latitude;


    /**
     * The geographical longitude of the location of the country
     * or region to be calculated
     * @param longitude
     */
    private double longitude;


    /**
     * Julian day account
     * symbolizes him
     * @param D
     */
    private double D;


    /**
     * Calculating the length of the middle sun
     * symbolizes him
     * @param L
     */
    private double L;


    /**
     * Calculate the middle sun share
     * symbolizes him
     * @param M
     */
    private double M;


    /**
     * Calculating the length of the sun's zodiac
     * symbolizes him
     * @param lambda
     */
    private double lambda;

    private double DMS;


    /**
     * inclination of the zodiac
     * symbolizes him
     * @param Obliquity
     */
    private double Obliquity;


    /*
     * straight seer
     * symbolizes him
     * @param Alpha
     */
    private double Alpha;


    /**
     * astral time
     * symbolizes him
     * @param ST
     */
    private double ST;

    /**
     * The sun's angular inclination
     * symbolizes him
     * @param Des
     */
    private double Des;


    /**
     * middle sun
     * symbolizes him
     * @param Noon
     */
    private double Noon;


    /**
     * global sunset
     * symbolizes him
     * @param UTNoon
     */
    private double UTNoon;




    /**
     * local sunset
     * symbolizes him
     * @param LocalNoon
     */
    private double LocalNoon;

    private int Timedifference;

    private DMS dms;

    //tawqit alzuhr
    private double P;
    private double Q;
    private double R;

    //tawqit Asr
    private double T;
    private double U;
    private double V;
    private double W;
    private double X;
    private double Z;

    //Sunrise and Sunset
    private double AB;
    private double AC;
    private double AE;
    //ISHA
    private double AG;
    private double AH;

    //Fajr
    private double AJ;
    private double AK;

    private OnPrayerTime onPrayerTime;
    private Formats formats;
    private final SuperData data=new SuperData();



    public Methods(int year, int month, int day,int timedifference, double latitude, double longitude) {
        this.Year = year;
        this.Month = month;
        this.Day = day;
        this.Timedifference=timedifference;
        this.latitude = latitude;
        this.longitude = longitude;



        this.D=367 * this.Year - Math.floor(7 * (this.Year +Math.floor( (this.Month + 9)/12))/ 4) + Math.floor(275 * this.Month / 9) +this.Day - 730531.5 +(7+23/60)  / 24;



        this.L = super.floatMod(280.461 + 0.9856474 * D, 360.0);

        while (this.L<0){
            this.L=this.L+360;
        }

        this.M = super.floatMod(357.528 + 0.9856003 *D,360.0);


        this.lambda =L+1.915*Math.sin(M*Math.PI/180)+0.02*Math.sin(2*this.M*Math.PI/180);

        this.Obliquity =23.439 - 0.0000004 * this.D;

        double Y = Math.cos(this.Obliquity*Math.PI/180.0) * Math.sin(this.lambda*Math.PI/180.0);
        double X = Math.cos(this.lambda*Math.PI/180.0);

        double a = (180.0/Math.PI)*Math.atan(Y/X);


        if (X < 0)
            this.Alpha = a + 180;
        else {
            if (Y < 0 && X > 0)
                this.Alpha = a + 360;
           else
                this.Alpha = a;
        }
        this.Des = (180.0/Math.PI) * Math.asin(Math.sin(Obliquity*Math.PI/180.0) * Math.sin( lambda*Math.PI /180.0 ));

        double TT = this.D/ 36525.0;

        this.ST = super.floatMod( 280.46061837 + 360.98564736629*D + 0.000387933*TT*TT - TT*TT*TT/38710000.0,360.0);
        while (this.ST<0){
            this.ST = this.ST+360.0;
        }

        AngleaAdnTimings();


    }
    private void AngleaAdnTimings(){


        ///duher
        this.P = super.floatMod(this.Alpha - this.ST ,360);
        this.Q = this.P -  this.longitude;
        this.R = (this.Q / 15) + this.Timedifference;

        //Asr

        //Shafih
        this.T = ShafiAndHanfi(1,this.Des,this.latitude);

        this.V = Math.acos(

                FirstShafiAndHanfiCal(T,this.Des,this.latitude) /
                        SecondShafiAndHanfiCal(this.Des,this.latitude)

        )*super.PI180/15;


        this.X = this.R + this.V;

        //Hanafi
        this.U = ShafiAndHanfi(2,this.Des,this.latitude);

        this.W =  Math.acos(

                FirstShafiAndHanfiCal(T,this.Des,this.latitude) /
                        SecondShafiAndHanfiCal(this.Des,this.latitude)

        ) * super.PI180/15;

        this.Z = this.R + this.W;

        /**
         *
         * */
        //Sunrise and sunsetangle
        this.AB = Math.acos(

                FirstCalMin(this.Sunriseandsunsetangle,this.Des,this.latitude)/
                        SecondCalDivi(this.Des,this.latitude)

        ) * super.PI180;

        ///Sunrise
        this.AC = this.R - this.AB /15;
        //sunset Maghrib
        this.AE = this.R + this.AB /15;


        /**
         *
         */
        this.AG = Math.acos(

                FirstCalMin(this.IshaandFajrangle,this.Des,this.latitude)/
                        SecondCalDivi(this.Des,this.latitude)

        ) * super.PI180;

        //ISHA
        this.AH = this.R + (this.AG/15);

        //Fajr
        this.AK = R - AG/15;



    }

    public void setOnPrayerTime(Formats format,OnPrayerTime onPrayerTime) {

        this.formats = format;
        this.onPrayerTime =onPrayerTime;





    }
    public void Start(){
        getTawqitFajr();
        getTawqitSunrise();
        getTawqitAlzuhr();
        getTawqitAlAsr();
        getTawqitSunset();
        getTawqitIsha();
    }
    public String getTawqitIsha() {

        dms=new DMS(this.AH);

        if (Formats.valueOf("H_M_24")==formats){

            String s1 = dms.getDM();
            onPrayerTime.prayer6(s1);

            return s1;
        } else if (Formats.valueOf("H_M_S_24")==formats) {

            String s1 = dms.getDMS();
            onPrayerTime.prayer6(s1);
            return s1;

        } else if(Formats.valueOf("HH_MM_AA_12")==formats){

            String s1 = data.FormatTime(dms.getDM());
            onPrayerTime.prayer6(s1);

            return s1;

        } else

            return null;
    }
    public String getTawqitAlzuhr() {

        dms=new DMS(this.R);
        if (Formats.valueOf("H_M_24")==formats){

            String s1 = dms.getDM();
            onPrayerTime.prayer3(s1);

            return s1;
        } else if (Formats.valueOf("H_M_S_24")==formats) {

            String s1 = dms.getDMS();
            onPrayerTime.prayer3(s1);
            return s1;

        } else if(Formats.valueOf("HH_MM_AA_12")==formats){

            String s1 = data.FormatTime(dms.getDM());
            onPrayerTime.prayer3(s1);

            return s1;

        } else

            return null;
    }
    public String getTawqitAlAsr() {

        dms=new DMS(this.X);

        if (Formats.valueOf("H_M_24")==formats){

            String s1 = dms.getDM();
            onPrayerTime.prayer4(s1);

            return s1;
        } else if (Formats.valueOf("H_M_S_24")==formats) {

            String s1 = dms.getDMS();
            onPrayerTime.prayer4(s1);
            return s1;

        } else if(Formats.valueOf("HH_MM_AA_12")==formats){

            String s1 = data.FormatTime(dms.getDM());
            onPrayerTime.prayer4(s1);

            return s1;

        } else

            return null;
    }


    public String getTawqitSunrise() {

        dms=new DMS(this.AC);

        if (Formats.valueOf("H_M_24")==formats){

            String s1 = dms.getDM();
            onPrayerTime.prayer2(s1);

            return s1;
        } else if (Formats.valueOf("H_M_S_24")==formats) {

            String s1 = dms.getDMS();
            onPrayerTime.prayer2(s1);
            return s1;

        } else if(Formats.valueOf("HH_MM_AA_12")==formats){

            String s1 = data.FormatTime(dms.getDM());
            onPrayerTime.prayer2(s1);

            return s1;

        } else

            return null;
    }


    public String getTawqitSunset() {

        dms=new DMS(this.AE);

        if (Formats.valueOf("H_M_24")==formats){

            String s1 = dms.getDM();
            onPrayerTime.prayer5(s1);

            return s1;
        } else if (Formats.valueOf("H_M_S_24")==formats) {

            String s1 = dms.getDMS();
            onPrayerTime.prayer5(s1);
            return s1;

        } else if(Formats.valueOf("HH_MM_AA_12")==formats){

            String s1 = data.FormatTime(dms.getDM());
            onPrayerTime.prayer5(s1);

            return s1;

        } else

            return null;
    }
    public String getTawqitFajr() {

        dms=new DMS(this.AK);

        if (Formats.valueOf("H_M_24")==formats){

            String s1 = dms.getDM();
            onPrayerTime.prayer1(s1);

            return s1;
        } else if (Formats.valueOf("H_M_S_24")==formats) {

            String s1 = dms.getDMS();
            onPrayerTime.prayer1(s1);
            return s1;

        } else if(Formats.valueOf("HH_MM_AA_12")==formats){

            String s1 = data.FormatTime(dms.getDM());
            onPrayerTime.prayer1(s1);

            return s1;

        } else

            return null;
    }



    public int getYear() {
        return Year;
    }

    public int getMonth() {
        return Month;
    }

    public int getDay() {
        return Day;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getD() {
        return D;
    }

    public double getL() {
        return L;
    }

    public double getM() {
        return M;
    }

    public double getLambda() {
        return lambda;
    }

    public double getDMS() {
        return DMS;
    }

    public double getObliquity() {
        return Obliquity;
    }

    public double getAlpha() {
        return Alpha;
    }

    public double getST() {
        return ST;
    }

    public double getDes() {
        return Des;
    }

    public double getNoon() {
        return Noon;
    }

    public double getUTNoon() {
        return UTNoon;
    }

    public double getLocalNoon() {
        return LocalNoon;
    }

    public int getTimedifference() {
        return Timedifference;
    }

    public double getP() {
        return P;
    }

    public double getQ() {
        return Q;
    }

    public double getR() {
        return R;
    }



}
