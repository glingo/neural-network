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
public class Linear extends AbstractTransferFunction {

    private double slope;

    public Linear() {
        this(1D);
    }
    
    public Linear(double slope) {
        this.slope = slope;
    }

    @Override
    public double getOutput(double input) {
        return slope * input;
    }

    @Override
    public double getDerivative(double net) {
        return this.slope;
    }

}
