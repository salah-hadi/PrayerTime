package com.calculating.prayer.Algorithms;

public abstract class Agorithms {

    /**
     *  Constants in Algorithms
     * @param PI180,and,PI180R
     **/
    protected final double PI180= 180/Math.PI;
    protected final double PI180R = Math.PI/180;
    /**
     *  These angles are constants in algorithms
     * @param Sunriseandsunsetangle,IshaandFajrangle
     **/
    protected final double Sunriseandsunsetangle = -0.833333333;
    protected final double IshaandFajrangle = -18;




    protected double SecondCalDivi(double Des,double latitude){

        return (
                Math.cos( Des * this.PI180R ) * Math.cos( latitude * this.PI180R )
        );
    }

    protected double FirstCalMin(double angle,double Des,double latitude) {

        return (
                Math.sin( angle * this.PI180R ) - Math.sin( Des * this.PI180R ) * Math.sin( latitude * this.PI180R)
        );
    }


    protected double ShafiAndHanfi(int Emam,double Des,double latitude){
        return (
                Math.atan( Emam + Math.tan((latitude-Des) * this.PI180R )) * this.PI180
        );
    }

    protected double FirstShafiAndHanfiCal(double TU ,double Des,double latitude){

        return (
                Math.sin( (90-TU) * this.PI180R )-Math.sin( Des * this.PI180R) * Math.sin( latitude * this.PI180R)
        );
    }
    protected double SecondShafiAndHanfiCal(double Des,double latitude){

        return (
                Math.cos( Des * this.PI180R)*Math.cos( latitude * this.PI180R)
        );
    }
    protected double floatMod(double x, double y){
        // x mod y behaving the same way as Math.floorMod but with doubles
        return (x - Math.floor(x/y) * y);
    }
}
