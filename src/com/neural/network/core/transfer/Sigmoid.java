/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neural.network.core.transfer;

/**
 *
 * @author caill
 */
public class Sigmoid extends AbstractTransferFunction {
    
    private double limit;
    private double slope;

    public Sigmoid() {
        this(1D, 100D);
    }
    
    public Sigmoid(double slope) {
        this();
        this.slope = slope;
    }

    public Sigmoid(double slope, double limit) {
        this.slope = slope;
        this.limit = limit;
    }

    @Override
    public double getOutput(double input) {
        
        if (input > this.limit) {
            return 1.0;
        }else if (input < -this.limit) {
            return 0.0;
        }

        double den = 1d + Math.exp(-this.slope * input);
        this.output = (1d / den);
                
        return this.output;
    }
    
    @Override
    public double getDerivative(double net) { 
            // remove net parameter? maybe we dont need it since we use cached output value
            // +0.1 is fix for flat spot see http://www.heatonresearch.com/wiki/Flat_Spot
            double derivative = this.slope * this.output * (1d - this.output) + 0.1;
            return derivative;
    }
    
}
