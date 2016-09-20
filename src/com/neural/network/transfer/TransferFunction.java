package com.neural.network.transfer;

@FunctionalInterface
public interface TransferFunction {
    
    double getOutput(double input);
    
}
