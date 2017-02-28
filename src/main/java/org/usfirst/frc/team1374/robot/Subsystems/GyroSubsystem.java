package org.usfirst.frc.team1374.robot.Subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 * Created by gabri on 2017-02-27.
 */
public class GyroSubsystem extends PIDSubsystem {
    AHRS gyro = new AHRS(SPI.Port.kMXP);
    static double swapSetpoint;
    static double temp;

    public GyroSubsystem()
    {
        super("GYRO PID: ",0.3,0.001,0);
        getPIDController().setContinuous(true);
        getPIDController().setInputRange(-180,180);
        getPIDController().setOutputRange(-1,1);
        getPIDController().setAbsoluteTolerance(2);
        gyro.reset();
        getPIDController().enable();
        swapSetpoint = getPIDController().getSetpoint();
    }

    public void zeroYaw()
    {
        gyro.reset();
        getPIDController().setSetpoint(0);
    }
    public double adder(double in,boolean reset)
    {
        if(reset)
        {
            swapSetpoint = 0;
            zeroYaw();

        }
        swapSetpoint += 3*Math.pow(in,3);
        temp = (int)swapSetpoint/180;
        swapSetpoint = swapSetpoint*Math.pow(-1,temp)-temp;

        return swapSetpoint;
    }
    public double returnSetpoint()
    {
        return getPIDController().getSetpoint();
    }
    public double getPIDOutput()
    {
        return getPIDController().get();
    }
    @Override
    protected void initDefaultCommand() {

    }

    @Override
    protected double returnPIDInput() {
        return gyro.pidGet();
    }

    @Override
    protected void usePIDOutput(double output) {

    }
}
