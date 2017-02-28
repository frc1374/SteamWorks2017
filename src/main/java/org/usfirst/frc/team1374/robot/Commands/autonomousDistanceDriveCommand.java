package org.usfirst.frc.team1374.robot.Commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.Subsystems.DriveSubsystem;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

import static org.usfirst.frc.team1374.robot.Util.Subsystems.DRIVE_SUBSYSTEM;
import static org.usfirst.frc.team1374.robot.Util.Subsystems.GYRO_SUBSYSTEM;

/**
 * Created by Gabriel on 2017-02-28.
 */
public class autonomousDistanceDriveCommand extends Command {

    private static double power,steering,distanceStorage;

    public autonomousDistanceDriveCommand(double speed,double angle,double distance)
    {
        requires(DRIVE_SUBSYSTEM);
        power = speed;
        steering = angle;
        distanceStorage = distance;

    }

    protected void initialize() {
        DRIVE_SUBSYSTEM.resetEncoder();
    }

    @Override
    protected void execute() {
        GYRO_SUBSYSTEM.setSetpoint(steering);
        GYRO_SUBSYSTEM.enable();
        DRIVE_SUBSYSTEM.arcadeDrive(power *0.9, GYRO_SUBSYSTEM.getPIDOutput());
    }

    @Override
    protected boolean isFinished() {
        if(DRIVE_SUBSYSTEM.onTarget(DRIVE_SUBSYSTEM.metricify(DRIVE_SUBSYSTEM.GET_DISTANCE_IN_INCHS(DRIVE_SUBSYSTEM.getAverageEncoder())),distanceStorage))
            return true;
        else
            return false;
    }

    @Override
    protected void end() {
        DRIVE_SUBSYSTEM.arcadeDrive(0,0);
        GYRO_SUBSYSTEM.disable();
        DRIVE_SUBSYSTEM.resetEncoder();
    }

    @Override
    protected void interrupted() {
        DRIVE_SUBSYSTEM.arcadeDrive(0,0);
        GYRO_SUBSYSTEM.disable();
        DRIVE_SUBSYSTEM.resetEncoder();
    }
}
