/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neural.network.core.transfer;

/**
 * Step neuron transfer function.
 * y = yHigh, x > 0
 * y = yLow, x <= 0
 * 
 */
public class Step extends AbstractTransferFunction {
    
    private final double min;
    private final double high;
    private final double low;

    public Step() {
        this(0D, 1D, 0D);
    }

    public Step(double min, double high, double low) {
        this.min = min;
        this.high = high;
        this.low = low;
    }
    
    @Override
    public double getOutput(double input) {
        if (input > this.min) {
            return this.high;
        }
        
        return this.low;
    }
    
}
