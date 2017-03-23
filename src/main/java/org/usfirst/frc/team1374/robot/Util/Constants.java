package org.usfirst.frc.team1374.robot.Util;

public class Constants {

    public final static double GEAR_RATIO                             = 3; //FINAL VALUE AS OF 2017-02-27
    public final static double ENCODER_TICKS_PER_REVOLUTION           = 256; //FINAL VALUE AS OF 2017-02-27
    public final static double DRIVE_WHEEL_DIAMETER                   = 6; //BEST GUESS SINCE NOBODY BOTHERED TO MEASURE, RUBBER DUCKY GODS WERE UPSET ON 2017-02-27
    public final static int    YELLOW_TAPE_PER_REVOLUTION             = 8; //I DID IT MYSELF
    public final static double METRIC_INCHES_METRES                   = 1/0.0254; // 1 Inch is equal to 0.0254 metres so it stands to reason that a number in inches divided by 0.0254 will spit out a constant.
    public final static double SHOOTER_RPM                            = 4500;

    public final static double ANALOG_VOLTAGE_PER_INCH                =(double)5000/512;
    public final static double HORIZONTAL_OFF_SET_INCHES              = 2.041666666666667;


    public final static double EXIT_ANGLE                             = Math.toRadians(72.3); //Measured 2017-03-23

    public final static double HEIGHT_BIN_INCHS                        = 8.083333333333332; //Game Manual Constant
    public final static double HEIGHT_ROBOT_METRES                     = 1; //Unknown

    public final static double DELTA_HEIGHT_METRES                    = metricify(HEIGHT_BIN_INCHS)-HEIGHT_ROBOT_METRES;

    /*
    Imperial units hurt [Canadian] programmers

    Hundreds of programmer tears have been saved since implementing this method
 */
    public static double metricify(double in)
    {
        return in/Constants.METRIC_INCHES_METRES; //read constants
    }
}
