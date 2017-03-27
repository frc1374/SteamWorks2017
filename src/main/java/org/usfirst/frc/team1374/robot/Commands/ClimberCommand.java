package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Robot;

/**
 * Created by gabri on 2017-03-24.
 */
public class ClimberCommand extends Command {

    public ClimberCommand(){
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
Robot.climberSubsystem.climb(OI.getOperatorClimb());
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