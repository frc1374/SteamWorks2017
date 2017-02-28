package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1374.robot.RobotMap;
import org.usfirst.frc.team1374.robot.Util.Constants;

/**
 * Created by Gabriel on 2017-01-08.
 */
public class DriveSubsystem extends Subsystem {

    static AHRS test;


    private static CANTalon left1 = new CANTalon(RobotMap.left1);
    private static CANTalon left2 = new CANTalon(RobotMap.left2);
    private static CANTalon right1 = new CANTalon(RobotMap.right1);
    private static CANTalon right2 = new CANTalon(RobotMap.right2);

    private static Encoder left = new Encoder(RobotMap.leftEncoderA,RobotMap.leftEncoderB,false);
    private static Encoder right = new Encoder(RobotMap.rightEncoderA,RobotMap.rightEncoderB,true);

    private static double tolerance = 0.1;


    public DriveSubsystem()
    {
        left.reset();
        right.reset();
    }
    /*
        This method is used to find the inches traveled by the wheel given the pulses from a given encoder.
        The information we know about each of the elements of the formula we will derive bellow as is follows:
        -Wheel diameter maximum is 6"
        -The encoders have 256 pulses per revolution of the shifter gear
        -The shifter gear is at a 12:36 ratio with the output shaft or 3 revolutions of the shifter for ever one revolution of the output

        d(pulse) = (6pi)*(pulse/(3*256))
     */
    public double GET_DISTANCE_IN_INCHS(double in)
    {
        return (Constants.DRIVE_WHEEL_DIAMETER*Math.PI)*(in/(Constants.GEAR_RATIO*Constants.ENCODER_TICKS_PER_REVOLUTION)); //we're using constants for when build team breaks our hearts
    }
    /*
        Imperial units hurt [Canadian] programmers

        Hundreds of programmer tears have been saved since implementing this method
     */
    public double metricify(double in)
    {
        return in/Constants.METRIC_INCHES_METRES; //read constants
    }

    public static boolean onTarget(double distance, double setpoint)
    {
        if(Math.abs(distance-setpoint) > tolerance) //If the absolute value of distance - the setpoint is less than the tolerance than you're on target.
            return true;

        else
            return false;
    }
    @Override
    protected void initDefaultCommand() {

    }

    public static void tankDrive(double powerLeft, double powerRight)
    {
        left1.set(powerLeft);
        left2.set(powerLeft);
        right1.set(-powerRight);
        right2.set(-powerRight);
    }

    public static void arcadeDrive(double turn,double speed)
    {
        tankDrive((-speed)-turn,(-speed)+turn);
    }

    public static void zeroDrift(double setDistance) {
    }
}
