/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neural.network.support.neuron;

import com.neural.network.core.Neuron;
import com.neural.network.core.input.WeightedSum;
import com.neural.network.core.transfer.Linear;

/**
 *
 * @author caill
 */
public class InputNeuron extends Neuron {
    
    public InputNeuron() {
        super(new WeightedSum(), new Linear());
    }

    /**
     * Calculate method of this type of neuron just transfers its externaly set 
     * input (with setNetInput) to its output
     */
    @Override
    public void calculate() {
        setOutput(this.getInput());
    }
}
