package com.neural.network.core.transfer;

@FunctionalInterface
public interface TransferFunction {
    
    double getOutput(double input);
    
}
