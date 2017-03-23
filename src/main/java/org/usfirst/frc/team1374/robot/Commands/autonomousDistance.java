package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Gabriel on 2017-02-28.
 */
public class autonomousDistance extends CommandGroup {

    public autonomousDistance()
    {
        addSequential(new autonomousDistanceDriveCommand(1,0,5));
        addSequential(new autonomousDistanceDriveCommand(0,0,1));
    }
}
