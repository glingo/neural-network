package com.neural.network.core.transfer;

public abstract class AbstractTransferFunction implements TransferFunction {
    
    protected double output;

    @Override
    public abstract double getOutput(double input);
    
    public double getDerivative(double input){
        return 1D;
    }
    
}
