package org.usfirst.frc.team1374.robot.Subsystems;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * Created by Gabriel on 2017-01-12.
 */
public class GearDellisioSubsystem {

    Solenoid one = new Solenoid(0);
    Solenoid two = new Solenoid(1);
    Solenoid three = new Solenoid(2);

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
