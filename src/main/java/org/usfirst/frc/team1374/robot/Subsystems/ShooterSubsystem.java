package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team1374.robot.RobotMap;
import org.usfirst.frc.team1374.robot.Util.Constants;

/**
 * Created by Gabriel on 2017-01-11.
 */
public class ShooterSubsystem extends PIDSubsystem {


    private static CANTalon shooter   = new CANTalon(RobotMap.shooter);
    private static CANTalon shooterIntake = new CANTalon(RobotMap.shooterActuator);
    private static Encoder shooterEncoder = new Encoder(RobotMap.shooterEncoderA,RobotMap.shooterEncoderB,false);
    private static int tolerance = 200;

    public ShooterSubsystem()
    {
        super("ShooterPID",0,0,0);
        setAbsoluteTolerance(100);
        getPIDController().setContinuous(false);
        shooterEncoder.setDistancePerPulse(1/ Constants.ENCODER_TICKS_PER_REVOLUTION);
        enable();
    }
    /*
        Prints the PID OUTPUT in Robot.java
     */
    public double printPIDOutput()
    {
        return this.getPIDController().get();
    }

    public static void setShooter(double in)
    {
        shooter.set(in);
        System.out.println("Shooter Speed RPM: "+shooterSpeed());
    }
    /*
        Sets the shooter RPM to the constant found in the constants class, if the boolean inputted is true
     */
     public static double setShooterSetpoint(boolean a)
     {
         if(a){

             return Constants.SHOOTER_RPM;
         }
         else
             return 0;
     }
     public static double shooterSpeed()
     {
         return shooterEncoder.getRate();
     }
    public static boolean onTarget(double RPM, double setpoint)
    {
        if(Math.abs(RPM-setpoint) > tolerance) //If the absolute value of distance - the setpoint is less than the tolerance than you're on target.
            return true;

        else
            return false;
    }

    public static void shootAtSpeed(boolean a)
    {
        setShooterSetpoint(a);
        if(onTarget(shooterEncoder.getRate(),Constants.SHOOTER_RPM) && a)
            shooterIntake.set(1);

        else
            shooterIntake.set(0);

    }

    @Override
    protected void initDefaultCommand() {

    }

    @Override
    protected double returnPIDInput() {
        return shooterSpeed();
    }

    @Override
    protected void usePIDOutput(double output) {
        setShooter(output);
    }
}
