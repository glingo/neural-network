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
public class Log extends AbstractTransferFunction {
    
    @Override
    public double getOutput(double net) {
        return Math.log(net);
    }
    
    @Override
    public double getDerivative(double net) {
	return (1/net);
    }
}
