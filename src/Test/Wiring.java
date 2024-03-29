package Test;

import WiringMain.WiringParent;

/**
 *
 * @author jeremy
 */
public class Wiring extends WiringParent {

    public static final boolean isTest = true;
    public static final double MAX_XY = 132;
    
    public static final int CAMERA_SERVO = 1;

    public static final int MOTOR_GATHERER_LEFT = 5;
    public static final int MOTOR_GATHERER_RIGHT = 6;
    public static final double GATHERER_SPEED_FORWARD = 1;
    public static final double GATHERER_SPEED_REVERSE = -1;
    
    public static final int RELAY_GATHERER = 6;
    
    public static final int COMPRESSOR_RELAY = 7;
    public static final int COMPRESSOR_PRESSURE_SWITCH = 14;
    //K is for PID control
    //P is proportion, D is derivative
    public static double KpR = 14.39 * dt / (2 * Math.PI);
    public static double KiR = 38.68 * dt / (2 * Math.PI);
    public static double KfR = MAX_R / 10.71;
    public static double KpY = 5 / MAX_XY * dt;
    public static double KdY = 0.31 / MAX_XY;
    public static double KfY = MAX_XY / 182;
    public static double KpX = 1.6 / MAX_XY * dt;
    public static double KdX = .44 / MAX_XY; //0.01 * dt * dt
    public static double KfX = MAX_XY / 308;
    
    public static final int MOTOR_LF = 1;
    public static final int MOTOR_RF = 2;
    public static final int MOTOR_LB = 3;
    public static final int MOTOR_RB = 4;
    
    public static final double CENTER_OF_ROTATION = .36;
    
    public static final double CF_HOOK = -.236;
    public static final double FF_HOOK = -.495;
    public static final double CB_HOOK = .268;
    public static final double FB_HOOK = -1;
    
    public static final int RELAY_MIDDLE_PISTON = 1;
    public static final int SOLENOID_SHOOTER_PRETENSION_IN = 7; // the middle cylinder
    public static final int SOLENOID_SHOOTER_PRETENSION_OUT = 8;
    public static final int SOLENOID_SHOOTER_SHOOT_IN = 5;  // the little one
    public static final int SOLENOID_SHOOTER_SHOOT_OUT = 6;
    public static final int SOLENOID_SHOOTER_TENSION_IN = 3; // the two cylinders on the side
    public static final int SOLENOID_SHOOTER_TENSION_OUT = 4;
    
    public static final int LIMIT_SHOOTER_DETENSIONED = 5;
    public static final int LIMIT_SHOOTER_TENSIONED = 6;
    public static final int LIMIT_SHOOTER_UP = 7;
    //public static final int LIMIT_SHOOTER_DOWN = 8;
    public static final int LIMIT_SHOOTER_MIDDLE_PISTON = 8;
    public static final int OPTICAL_SHOOTER_BALL_SENSOR = 5;
    public static final double C_HAS_BALL = 2;
    
    public static final int SONAR_CHANNEL = 3; //This will probably have to change...
    public static final double MAX_DIST_R1 = 4;
    public static final double MIN_DIST_R1 = 0;
    public static final double MAX_DIST_R2 = 15;
    public static final double MIN_DIST_R2 = 8;

        public static final int DEFENSIVE_ARM = 8;

}
