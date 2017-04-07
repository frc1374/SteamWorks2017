package org.usfirst.frc.team1374.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1374.robot.Commands.*;
import org.usfirst.frc.team1374.robot.Subsystems.ClimberSubsystem;
import org.usfirst.frc.team1374.robot.Subsystems.DriveSubsystem;
import org.usfirst.frc.team1374.robot.Subsystems.GearSubsystem;
import org.usfirst.frc.team1374.robot.Subsystems.ShooterSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static OI oi;
    public static DriveSubsystem driveSubsystem;
    public static ClimberSubsystem climberSubsystem;
    //public static GearDellisioSubsystem gearSubsystem;
    public static ShooterSubsystem shooterSubsystem;
    public static GearSubsystem gearSubsystem;

    Command autonomousCommand;
    Command driveCommand;
    Command climberDriver;
    Command gearCommand;
    SendableChooser chooser;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        oi = new OI();
        chooser = new SendableChooser();
        driveSubsystem = new DriveSubsystem();
        climberSubsystem = new ClimberSubsystem();
        //gearSubsystem = new GearDellisioSubsystem();
        shooterSubsystem = new ShooterSubsystem();
        gearCommand = new GearCommand();
        driveCommand = new DriveCommand();
        climberDriver = new ClimberCommand();
        gearSubsystem = new GearSubsystem();
        chooser.addDefault("Time Based Auto", new autonomousMystery());
        chooser.addObject("Distance Based Auto", new autonomousDistance());
        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit(){
        driveSubsystem.zeroYaw();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // autonomousCommand = (Command) chooser.getSelected();


        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        driveCommand.start();
        climberDriver.start();
        gearCommand.start();
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //SmartDashboard.putNumber("GYRO PID OUTPUT:",Subsystems.GYRO_SUBSYSTEM.getPIDOutput());
       // SmartDashboard.putData("GYRO CHECK N'PRAY STATION: ", .getPIDController());
        SmartDashboard.putData("Gyro PID: ", driveSubsystem.getPIDController());
        //SmartDashboard.putNumber("Ultrasonic",driveSubsystem.ultra());
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
