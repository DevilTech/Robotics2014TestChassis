/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author jeremy
 */
public class Piston {
    
    DoubleSolenoid sol;
    Relay r;
    boolean isExtend;
    boolean isSol;
    boolean outFor;
    
    public Piston(int extendValve, int retractValve){
        sol = new DoubleSolenoid(extendValve, retractValve);
        isSol = true;
    }
    public Piston(int relay, boolean forwardOut){
        r = new Relay(relay, Relay.Direction.kForward);
        isSol = false;
        outFor = forwardOut;
    }
    
    public void extend(){
        if(isSol){
            sol.set(true);
        }
        else{
            if(outFor) r.set(Relay.Value.kOff);
            else r.set(Relay.Value.kOn);
        }
        isExtend = true;
    }
    
    public void retract(){
         if(isSol){
            sol.set(false);
         }
         else{
            if(outFor) r.set(Relay.Value.kOn);
            else r.set(Relay.Value.kOff);
         }
        isExtend = false;
    }
    
}
