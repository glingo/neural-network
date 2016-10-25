package com.neural.network.support.neuron;

import com.neural.network.core.Neuron;
import com.neural.network.core.input.InputFunction;
import com.neural.network.core.input.WeightedSum;
import com.neural.network.core.transfer.Linear;
import com.neural.network.core.transfer.TransferFunction;

public class InputOutputNeuron extends Neuron {

    private boolean externalInputSet;

    private double bias = 0;

    public InputOutputNeuron() {
        super(new WeightedSum(), new Linear());
    }

    /**
     * Creates an instance of neuron for Hopfield network with specified input
     * and transfer functions
     *
     * @param inFunc neuron input function
     * @param transFunc neuron transfer function
     */
    public InputOutputNeuron(InputFunction inFunc, TransferFunction transFunc) {
        super(inFunc, transFunc);
    }

    /**
     * Sets total net input for this cell
     *
     * @param input input value
     */
    @Override
    public void setInput(double input) {
        super.setInput(input);
        this.externalInputSet = true;
    }

    /**
     * Returns bias value for this neuron
     *
     * @return bias value for this neuron
     */
    public double getBias() {
        return bias;
    }

    /**
     * Sets bias value for this neuron
     *
     * @param bias bias value for this neuron
     */
    public void setBias(double bias) {
        this.bias = bias;
    }

    /**
     * Calculates neuron output
     */
    @Override
    public void calculate() {

        if (!externalInputSet) { // ako ulaz nije setovan spolja
            setInput(getInputConnectionOutput());
        }

        // calculate cell output
        setOutput(getTransferFunction().getOutput(getInput() + bias));

        if (externalInputSet) {
            externalInputSet = false;
            setInput(0);
        }
    }
}
