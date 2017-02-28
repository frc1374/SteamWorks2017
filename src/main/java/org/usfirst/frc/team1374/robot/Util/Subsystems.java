package org.usfirst.frc.team1374.robot.Util;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1374.robot.Subsystems.*;

/**
 * Created by gabri on 2016-05-09.
 */
public class Subsystems {

    public static DriveSubsystem DRIVE_SUBSYSTEM;
    public static ShooterSubsystem SHOOTER_SUBSYSTEM;
    public static GearDellisioSubsystem GEAR_SUBSYSTEM;
    public static ClimberSubsystem CLIMBER_SUBSYSTEM;
    public static GyroSubsystem GYRO_SUBSYSTEM;
    /**
     * Usage:
     *
     * public static ExampleSubsystem EXAMPLE_SUBSYSTEM;
     */
    public Subsystems()
    {
        DRIVE_SUBSYSTEM = new DriveSubsystem();
        SHOOTER_SUBSYSTEM = new ShooterSubsystem();
        GEAR_SUBSYSTEM = new GearDellisioSubsystem();
        CLIMBER_SUBSYSTEM = new ClimberSubsystem();
        GYRO_SUBSYSTEM = new GyroSubsystem();

        /**
         * Usage:
         *
         * EXAMPLE_SUBSYSTEM = new ExampleSubsystem();
         */
    }


    public static void print(Object o)
    {
        System.out.println(o);
    }
}
