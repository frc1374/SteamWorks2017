package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team1374.robot.RobotMap;

/**
 * Created by Gabriel on 2017-01-11.
 */
public class ShooterSubsystem extends PIDSubsystem {

    Counter proxy = new Counter(0);
    CANTalon shooter   = new CANTalon(RobotMap.shooter);

    public ShooterSubsystem()
    {
        super("ShooterPID",0,0,0);
        setAbsoluteTolerance(100);
        getPIDController().setContinuous(false);
        proxy.setDistancePerPulse(1);
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
         switch (""+a)
         {
             case "True" : return 4500;
             default: return 0;
         }
     }
     public double shooterSpeed()
     {
         return proxy.getRate()/(proxy.getPeriod()*60);
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
