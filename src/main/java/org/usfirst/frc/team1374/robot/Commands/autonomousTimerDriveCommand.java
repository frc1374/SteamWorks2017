package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.Subsystems.DriveSubsystem;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

/**
 * Created by Gabriel on 2017-02-28.
 */
public class autonomousTimerDriveCommand extends Command {

    private static double power,steering;
    private static int holdTimer;
    private static Timer time = new Timer();

    public autonomousTimerDriveCommand(double speed,double turn,int time)
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
        steering = turn;
        power = speed;
        holdTimer = time;
    }

    @Override
    protected void initialize() {
        time.reset();
        time.start();
    }

    @Override
    protected void execute() {
       Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(steering,power);
    }

    @Override
    protected boolean isFinished() {
        if(time.hasPeriodPassed(holdTimer))
            return true;
        else
            return false;

    }

    @Override
    protected void end() {
        Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0,0);
    }

    @Override
    protected void interrupted() {
        Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0,0);
    }
}
