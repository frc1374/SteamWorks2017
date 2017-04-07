package org.usfirst.frc.team1374.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Matt on 2017-04-07.
 */
public class GearSubsystem extends Subsystem {
    DoubleSolenoid gear = new DoubleSolenoid(2,3);
    @Override
    protected void initDefaultCommand() {

    }

    void shift(boolean in)
    {
        if(in)
            gear.set(DoubleSolenoid.Value.kForward);
        else
            gear.set(DoubleSolenoid.Value.kReverse);
    }
}
