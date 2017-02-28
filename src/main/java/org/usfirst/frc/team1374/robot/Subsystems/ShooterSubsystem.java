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

    public double printPIDOutput()
    {
        return this.getPIDController().get();
    }
    public void setShooter(double in)
    {
        shooter.set(in);
        Util.println("Shooter Speed RPM: "+shooterSpeed());
    }

     public double setShooterSetpoint(boolean a)
     {
         if(a){
             return 4500;
         }
         else
             return 0;
     }
     public double shooterSpeed()
     {
         return shooterEncoder.getRate();
     }
    public static boolean onTarget(double distance, double setpoint)
    {
        if(Math.abs(distance-setpoint) > tolerance) //If the absolute value of distance - the setpoint is less than the tolerance than you're on target.
            return true;

        else
            return false;
    }

    public static void shootAtSpeed(boolean a)
    {

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
