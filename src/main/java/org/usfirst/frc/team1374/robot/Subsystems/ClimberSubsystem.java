package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1374.robot.RobotMap;

/**
 * Created by Gabriel on 2017-01-08.
 */
public class ClimberSubsystem extends Subsystem{

    static CANTalon climber = new CANTalon(RobotMap.climber);

    public static void climb(boolean in){
        if(in){
            climber.set(-1);
        } else {
            climber.set(0);
        }
    }
    @Override
    protected void initDefaultCommand() {

    }
}
