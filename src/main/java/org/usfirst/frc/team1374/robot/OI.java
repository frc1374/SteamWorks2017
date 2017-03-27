package org.usfirst.frc.team1374.robot;


import org.usfirst.frc.team1374.robot.Util.Toggle;
import org.usfirst.frc.team1374.robot.Util.Xbox360Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private static Xbox360Controller JS_DRIVER = new Xbox360Controller(0,0.15);
    private static Xbox360Controller JS_OPERATOR = new Xbox360Controller(1,0.15);

    private static Toggle T_DRIVER_SHIFT = new Toggle();
    public static double getDriverSpeed(){return JS_DRIVER.getRightTrigger() - JS_DRIVER.getLeftTrigger();}
    public static boolean getDriveLeft(){return JS_DRIVER.getButtonLB();}
    public static boolean getDriveRight(){return JS_DRIVER.getButtonRB();}
    public static boolean getPIDToggle(){ return JS_DRIVER.getButtonY();}
    public static double getDriverTurn(){return JS_DRIVER.getLeftXAxis();}
    public static boolean getOperatorClimb(){return JS_OPERATOR.getButtonX();}
    public static boolean getDriverShift(){return T_DRIVER_SHIFT.returnState(JS_DRIVER.getButtonA());}



    //Climber - Driver
        //Actuator - operator
        //gear hold -driver
        //gear delivery - operator
        //Corrector - operator
    //Shooter - Operator
        //intake -operator
    }

