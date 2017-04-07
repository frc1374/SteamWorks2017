package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Robot;

/**
 * Created by Matt on 2017-04-07.
 */
public class GearCommand extends Command {
    public GearCommand()
    {
        requires(Robot.gearSubsystem);
    }
    protected void execute()
    {
        Robot.gearSubsystem.shift(OI.getOperatorShift());

    }
    @Override
    protected boolean isFinished() {
        return false;
    }
}
