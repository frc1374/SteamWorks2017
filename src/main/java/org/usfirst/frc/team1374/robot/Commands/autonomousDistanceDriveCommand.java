package org.usfirst.frc.team1374.robot.Commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.Robot;
import org.usfirst.frc.team1374.robot.Util.Constants;


/**
 * Created by Gabriel on 2017-02-28.
 */
public class autonomousDistanceDriveCommand extends Command {

    private double angle,speed,distance;

    public autonomousDistanceDriveCommand(double speed,double angle,double distance)
    {
        requires(Robot.driveSubsystem);
        this.angle = angle;
        this.speed = speed;
        this.distance = distance;

    }

    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.driveSubsystem.pidWriter(this.angle,false);
        Robot.driveSubsystem.pidRun(speed);
    }

    @Override
    protected boolean isFinished() {
        if(Robot.driveSubsystem.onTarget(Constants.metricify(Robot.driveSubsystem.GET_DISTANCE_IN_INCHS(Robot.driveSubsystem.getAverageEncoder())),distance))
        {
            return true;
        }
        else
            return false;
    }

    @Override
    protected void end() {
        Robot.driveSubsystem.pidRun(0);
    }

    @Override
    protected void interrupted() {
        Robot.driveSubsystem.pidRun(0);
    }
}
