package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Gabriel on 2017-02-28.
 */
public class autonomousMystery extends CommandGroup {

    public autonomousMystery()
    {
        addSequential(new autonomousTimerDriveCommand(0.5,0,2000));
        addSequential(new autonomousTimerDriveCommand(0,0,2000));
    }
}
