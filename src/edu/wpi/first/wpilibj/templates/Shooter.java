
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import Test.Wiring;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;

public class Shooter {

    Counter upCounter;
    Counter downCounter;
    Counter tensionedCounter;
    Counter deTensionedCounter;
    DigitalInput up;
    DigitalInput down;
    DigitalInput tensioned;
    DigitalInput deTensioned;
    int state = 0;
    Piston middlePiston;
    Piston shoot;
    Piston outerPistons;
    AnalogChannel ball;
    DigitalInput shooterPistonLimit;
    double distance;
    int counter = 0;
    boolean readyToShoot = false;
    boolean hasShot = false;
    boolean isDown = false;
    boolean shooting = false;
    boolean popTrig = false;

    public Shooter() {
        shoot = new Piston(Wiring.SOLENOID_SHOOTER_SHOOT_OUT, Wiring.SOLENOID_SHOOTER_SHOOT_IN);
        outerPistons = new Piston(Wiring.SOLENOID_SHOOTER_TENSION_OUT, Wiring.SOLENOID_SHOOTER_TENSION_IN);
        if(Wiring.isTest)
            middlePiston = new Piston(Wiring.RELAY_MIDDLE_PISTON, false);
        else
        middlePiston = new Piston(Wiring.SOLENOID_SHOOTER_PRETENSION_OUT, Wiring.SOLENOID_SHOOTER_PRETENSION_IN);
        
        //tensioned = new DigitalInput(Wiring.LIMIT_SHOOTER_TENSIONED);
        // up = new DigitalInput(Wiring.LIMIT_SHOOTER_UP);
        //down = new DigitalInput(Wiring.LIMIT_SHOOTER_DOWN);
        deTensioned = new DigitalInput(Wiring.LIMIT_SHOOTER_DETENSIONED);
        ball = new AnalogChannel(Wiring.OPTICAL_SHOOTER_BALL_SENSOR);
        shooterPistonLimit = new DigitalInput(Wiring.LIMIT_SHOOTER_MIDDLE_PISTON);
        tensionedCounter = new Counter(Wiring.LIMIT_SHOOTER_TENSIONED);
        tensionedCounter.start();
        tensionedCounter.reset();
        
    }

    public void initalize() {
        readyToShoot = false;
        isDown = false;
        tensionedCounter.reset();
        System.out.println("init");

    }

    public void cock() {
        if (!readyToShoot) {
            if (!isDown) {
                middlePiston.extend();
                outerPistons.retract();
                shoot.retract();
                tensionedCounter.reset();
                if (!shooterPistonLimit.get()) { // CHANGE IN FINAL CODE - REVERSE THE "NOT"
                    isDown = true;
                    System.out.println(shooterPistonLimit.get());
                }
                System.out.println("readying " + shooterPistonLimit.get());
            } else {
                if (tensionedCounter.get() == 0) {
                    outerPistons.extend();
                    System.out.println("tensionin");
                } else {
                    readyToShoot = true;
                    System.out.println("ready");
                }
            }
        }
    }

    public void shoot() {
        // add ball sensor

        if (readyToShoot ){//&& (ball.getVoltage() > Wiring.C_HAS_BALL)) {  ----PUT THIS BACK IN
            shoot.extend();
            middlePiston.retract();
            System.out.println("shoot");
            isDown = false;
            readyToShoot = false;
        }
    }

    

    public void makesafe() {
        outerPistons.retract();
        middlePiston.retract();
        shoot.retract();
        System.out.println("Making Shooter Safe");
    }

    public void popShot() {
        if (popTrig) {
            isDown = false;
            readyToShoot = false;
            popTrig = false;
        }else{
            if (!deTensioned.get() ){//&& RobotTemplate.gathererReversed) {
                shoot.extend();
                readyToShoot = false;
                popTrig = true;
            } else if (deTensioned.get()) {
                outerPistons.retract();
                System.out.println("pop");
                readyToShoot = false;
            }
        
        }
    }
}
