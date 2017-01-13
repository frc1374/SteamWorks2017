package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1374.robot.RobotMap;

/**
 * Created by Gabriel on 2017-01-08.
 */
public class DriveSubsystem extends Subsystem {

    static CANTalon left1 = new CANTalon(RobotMap.left1);
    static CANTalon left2 = new CANTalon(RobotMap.left2);
    static CANTalon right1 = new CANTalon(RobotMap.right1);
    static CANTalon right2 = new CANTalon(RobotMap.right2);

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
}
