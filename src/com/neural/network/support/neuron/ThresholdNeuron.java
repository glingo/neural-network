package com.neural.network.support.neuron;

import com.neural.network.core.Neuron;
import com.neural.network.core.input.InputFunction;
import com.neural.network.core.transfer.TransferFunction;

public class ThresholdNeuron extends Neuron {
    
    protected double thresh;

    public ThresholdNeuron(double thresh, InputFunction inputFunction, TransferFunction transferFunction) {
        super(inputFunction, transferFunction);
        this.thresh = thresh;
    }

    public ThresholdNeuron(InputFunction inputFunction, TransferFunction transferFunction) {
        this(Math.random(), inputFunction, transferFunction);
    }
    
    @Override
    public void calculate() {
        setInput(getInputConnectionOutput());
        setOutput(getTransferFunction().getOutput(getInput()-this.thresh));
    }
    
}
