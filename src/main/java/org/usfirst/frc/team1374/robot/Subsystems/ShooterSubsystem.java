package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team1374.robot.RobotMap;
import org.usfirst.frc.team1374.robot.Util.Constants;

/**
 * Created by Gabriel on 2017-01-11.
 */
public class ShooterSubsystem extends PIDSubsystem {


    private static CANTalon shooter   = new CANTalon(RobotMap.shooter);
    private static CANTalon shooterIntake = new CANTalon(RobotMap.shooterActuator);
    private static Counter shooterEncoder = new Counter(RobotMap.shooterEncoder);
    private static AnalogInput ultrasonic = new AnalogInput(0);
    private static int tolerance = 200;

    public ShooterSubsystem()
    {
        super("ShooterPID",0,0,0);
        setAbsoluteTolerance(100);
        getPIDController().setContinuous(false);
        shooterEncoder.setDistancePerPulse(1/ Constants.YELLOW_TAPE_PER_REVOLUTION);
        enable();
    }
    /*
        Returns the distance in meters for the ultrasonic sensor

        formula is as follows d(inchs) = voltageReported / voltagePerInch
     */
    public double returnUltrasonicDistance()
    {
        return Constants.metricify((ultrasonic.getAverageVoltage()*1000)/Constants.ANALOG_VOLTAGE_PER_INCH);
    }
    /*
        Calculates exit velocity using the following formula
        velocity squared(m/s) = (4.9*horizontalDistanceSquared)/(tan(exitAngle)*(horizontalDistance - delta height)*(cosSquared(exitAngle)))
     */
    public double returnExitVelocity()
    {

        double distanceHorizontal = Constants.metricify(Constants.HORIZONTAL_OFF_SET_INCHES)+returnUltrasonicDistance();

        return (4.9*Math.pow(distanceHorizontal,2))/(Math.tan(Constants.EXIT_ANGLE)*(distanceHorizontal-Constants.DELTA_HEIGHT_METRES)*Math.pow(Math.cos(Constants.EXIT_ANGLE),2));
    }
    /*
        Prints the PID OUTPUT in Robot.java
     */
    public double printPIDOutput()
    {
        return this.getPIDController().get();
    }

    public static void setShooter(double in)
    {
        shooter.set(in);
        System.out.println("Shooter Speed RPM: "+shooterSpeed());
    }
    /*
        Sets the shooter RPM to the constant found in the constants class, if the boolean inputted is true
     */
     public static double setShooterSetpoint(boolean a)
     {
         if(a){

             return Constants.SHOOTER_RPM;
         }
         else
             return 0;
     }
     public static double shooterSpeed()
     {
         return shooterEncoder.getRate();
     }
    public static boolean onTarget(double RPM, double setpoint)
    {
        if(Math.abs(RPM-setpoint) > tolerance) //If the absolute value of distance - the setpoint is less than the tolerance than you're on target.
            return true;

        else
            return false;
    }

    public static void shootAtSpeed(boolean a)
    {
        setShooterSetpoint(a);
        if(onTarget(shooterEncoder.getRate(),Constants.SHOOTER_RPM) && a)
            shooterIntake.set(1);

        else
            shooterIntake.set(0);

    }

    @Override
    protected void initDefaultCommand() {

    }

    @Override
    protected double returnPIDInput() {
        return shooterSpeed();
    }

    @Override
    protected void usePIDOutput(double output) {
        setShooter(output);
    }
}
