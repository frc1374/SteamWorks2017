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
       // Robot.driveSubsystem.setSetpoint( Robot.driveSubsystem.pidWriter(OI.getDriverTurn(),OI.getPIDToggle()));
        //Robot.driveSubsystem.pidRun(OI.getDriverSpeed());
        Robot.driveSubsystem.arcadeDrive(OI.getDriverSpeed(),OI.getDriverTurn());
        Robot.driveSubsystem.shiftGear(OI.getDriverShift());

        if(OI.getDriveLeft() || OI.getDriveRight())
        {
            if(OI.getDriveLeft())
            {
                Robot.driveSubsystem.setSetpoint( Robot.driveSubsystem.pidWriter(-1,OI.getPIDToggle()));
            }
            else
                Robot.driveSubsystem.setSetpoint( Robot.driveSubsystem.pidWriter(1,OI.getPIDToggle()));
        }

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
