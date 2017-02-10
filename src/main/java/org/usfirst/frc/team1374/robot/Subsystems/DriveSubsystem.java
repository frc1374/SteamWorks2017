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


    static CANTalon left1 = new CANTalon(RobotMap.left1);
    static CANTalon left2 = new CANTalon(RobotMap.left2);
    static CANTalon right1 = new CANTalon(RobotMap.right1);
    static CANTalon right2 = new CANTalon(RobotMap.right2);
    static Encoder left = new Encoder(RobotMap.leftEncoderA,RobotMap.leftEncoderB,false);
    static Encoder right = new Encoder(RobotMap.rightEncoderA,RobotMap.rightEncoderB,true);

    private static double getLeftDistance() {return (left.get()/(Constants.ENCODER_TICKS_PER_REVOLUTION/Constants.LOW_GEAR_RATIO))*(Math.PI*Constants.DRIVE_WHEEL_DIAMETER);}
    private static double getRightDistance() {return (right.get()/(Constants.ENCODER_TICKS_PER_REVOLUTION/Constants.LOW_GEAR_RATIO))*(Math.PI*Constants.DRIVE_WHEEL_DIAMETER);}

    public DriveSubsystem()
    {
        left.reset();
        right.reset();
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
