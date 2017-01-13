package org.usfirst.frc.team1374.robot.Subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Gabriel on 2017-01-11.
 */
public class ShooterSubsystem extends Subsystem {
    DigitalInput proxy = new DigitalInput(0);

    public ShooterSubsystem()
    {

    }

    @Override
    protected void initDefaultCommand() {

    }
}
