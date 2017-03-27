package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1374.robot.RobotMap;
import org.usfirst.frc.team1374.robot.Util.Constants;

/**
 *Created by Gabriel on 2017-02-10.
 */
public class DriveSubsystem extends PIDSubsystem {

    AHRS ahrs = new AHRS(SPI.Port.kMXP);
    static private CANTalon left1 = new CANTalon(RobotMap.left1);
    static private CANTalon left2 = new CANTalon(RobotMap.left2);
    static private CANTalon right1 = new CANTalon(RobotMap.right1);
    static private CANTalon right2 = new CANTalon(RobotMap.right2);

    static private Encoder left = new Encoder(RobotMap.leftEncoderA,RobotMap.leftEncoderB,false);
    static private Encoder right = new Encoder(RobotMap.rightEncoderA,RobotMap.rightEncoderB, true);
    static private DoubleSolenoid shifter  = new DoubleSolenoid(RobotMap.shifterA,RobotMap.shifterB);


    static private double pidGet; //PID NUMBERS ARE STORED HERE
    static private double hold;
    private int temp;
    private static double tolerance = 0.1;
    private boolean highGear = true;
    private boolean reset = false;

    public DriveSubsystem()
    {
        super("Drive PID: ",0.03,0,0);
        getPIDController().setContinuous(true);
        getPIDController().setInputRange(-180,180);
        getPIDController().setOutputRange(-1,1);
        getPIDController().setAbsoluteTolerance(1);
        ahrs.reset();
        getPIDController().enable();
        hold = getPIDController().getSetpoint();
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


    public  boolean onTarget(double distance, double setpoint)
    {
        if(Math.abs(distance-setpoint) > tolerance) //If the absolute value of distance - the setpoint is less than the tolerance than you're on target.
            return true;

        else
            return false;
    }
    /*
        Returns the average of the encoders on the drivetrain
        The encoders will only be used to drive specific distances in a straight line so we can assume the average will improve accuracy
        ==============================
        PLEASE TEST PERCENT ERROR!!!!!
        ==============================
     */
    public  double getAverageEncoder()
    {
        return (left.get() + right.get())/2;
    }
    /*
        Used to reset both encoders
     */
    public static void resetEncoder()
    {
        left.reset();
        right.reset();
    }
    /*
        Used to set the setpoint
     */

    public double pidWriter(double in,boolean reset)
    {
        if (reset || this.getSetpoint() == 180 || this.getSetpoint() == -180) {
            hold = 0;
            zeroYaw();
        }
        hold += (3*Math.pow(in,3));
        temp = (int)hold/180;
        hold = hold*Math.pow(-1,temp) -temp;
        return hold;
    }
    /*
    Zeros the PID + yaw to current position
     */
    public void zeroYaw()
    {
        ahrs.zeroYaw();
        getPIDController().setSetpoint(0);
    }
    public void toggleGyro(boolean run)
    {
        if(run)
        {
            this.enable();
        }

        else
            this.disable();

    }
    public void keepYaw()
    {
        getPIDController().setSetpoint(ahrs.getYaw());
        pidRun(0.9);
    }
    public double returnSetpoint()
    {
        return getPIDController().getSetpoint();
    }
    public double getPIDOutput()
    {
        return getPIDController().get();
    }
    public void tankDrive(double left,double right)
    {
        left1.set(left);
        left2.set(left);
        right1.set(-right);
        right2.set(-right);
        System.out.println("Gryo Values: "+ahrs.pidGet());
    }

    public void pidRun(double in)
    {
        arcadeDrive(in,pidGet);
    }
    public void shiftGear(boolean in)
    {
        if(in)
            shifter.set(DoubleSolenoid.Value.kForward);
        else
            shifter.set(DoubleSolenoid.Value.kOff);
    }
    public void arcadeDrive(double speed,double turn)
    {

        tankDrive((-speed)+turn,(-speed)-turn);
    }


    @Override
    protected void initDefaultCommand() {

    }

    @Override
    protected double returnPIDInput() {
        return ahrs.pidGet();
    }

    @Override
    protected void usePIDOutput(double output) {
        pidGet = output;
    }
}