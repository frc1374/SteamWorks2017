package org.usfirst.frc.team1374.robot.Util;

/**
 * Created by gabri on 2017-03-27.
 */
public class Toggle {
    private boolean reset = false;
    private boolean value = false;

    public Toggle() {

    }

    public boolean returnState(boolean buttonPressed) {
        if (buttonPressed && !reset) {
            value = !value;
            reset = true;
        } else {
            reset = false;
        }

        return value;
    }


}