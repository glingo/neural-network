package com.neural.network.transfer;

public abstract class AbstractTransferFunction implements TransferFunction {
    
    private double output;

    @Override
    public abstract double getOutput(double input);
    
    public double getDerivate(double input){
        return 1D;
    }
    
}
