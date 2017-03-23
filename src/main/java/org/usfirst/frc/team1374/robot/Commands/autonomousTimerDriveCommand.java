package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.Robot;

/**
 * Created by Gabriel on 2017-02-28.
 */
public class autonomousTimerDriveCommand extends Command {

    private double speed,turn;
    private int timer;
    private static Timer time = new Timer();

    public autonomousTimerDriveCommand(double speed,double turn,int time)
    {
        requires(Robot.driveSubsystem);
        this.turn = turn;
        this.speed = speed;
        timer = time;
    }

    @Override
    protected void initialize() {
        time.reset();
        time.start();
    }

    @Override
    protected void execute() {
       Robot.driveSubsystem.arcadeDrive(speed,turn);
    }

    @Override
    protected boolean isFinished() {
        if(time.hasPeriodPassed(timer))
            return true;
        else
            return false;

    }

    @Override
    protected void end() {
        Robot.driveSubsystem.arcadeDrive(0,0);
    }

    @Override
    protected void interrupted() {
        Robot.driveSubsystem.arcadeDrive(0,0);
    }
}
