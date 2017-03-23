package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.Robot;

/**
 * Created by Gabriel on 2017-02-28.
 */
public class ShooterCommand extends Command {
    public ShooterCommand() {
        requires(Robot.driveSubsystem);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute(){

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
