package org.usfirst.frc.team1374.robot;


import org.usfirst.frc.team1374.robot.Util.Xbox360Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private static Xbox360Controller JS_DRIVER = new Xbox360Controller(0,0.15);
    private static Xbox360Controller JS_OPERATOR = new Xbox360Controller(1,0.15);
}

