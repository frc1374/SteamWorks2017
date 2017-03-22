package org.usfirst.frc.team1374.robot.Subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team1374.robot.RobotMap;

/**
 * Created by Gabriel on 2017-01-12.
 */
public class GearDellisioSubsystem {

    Solenoid one = new Solenoid(RobotMap.solenoidOne);
    Solenoid two = new Solenoid(RobotMap.solenoidTwo);
    Solenoid three = new Solenoid(RobotMap.solenoidThree);

    public void une(boolean uno){
        one.set(true);
    }

    public void deux(boolean dos){
        two.set(true);
    }

    public void trois(boolean tres){
        three.set(true);
    }
}
