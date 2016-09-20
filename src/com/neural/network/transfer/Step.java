/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neural.network.transfer;

/**
 * Step neuron transfer function.
 * y = yHigh, x > 0
 * y = yLow, x <= 0
 * 
 */
public class Step extends AbstractTransferFunction {
    
    private final double yHigh;
    private final double yLow;

    public Step() {
        this(1D, 0D);
    }

    public Step(double yHigh, double yLow) {
        this.yHigh = yHigh;
        this.yLow = yLow;
    }
    
    @Override
    public double getOutput(double input) {
        
        if (input > 0d) {
            return yHigh;
        }
        
        return yLow;
    }
    
}
