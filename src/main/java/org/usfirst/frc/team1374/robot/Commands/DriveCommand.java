package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Robot;

/**
 * Created by Gabriel on 2017-01-08.
 */
public class DriveCommand extends Command {
    public DriveCommand() {
        requires(Robot.driveSubsystem);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.driveSubsystem.setSetpoint( Robot.driveSubsystem.pidWriter(OI.getDriverTurn(),OI.getPIDToggle()));
        Robot.driveSubsystem.pidRun(OI.getDriverSpeed());
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
