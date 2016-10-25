package com.neural.network.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer {
    
    private String label;
    private List<Neuron> neurons;

    public Layer() {
        this.neurons =  new ArrayList<>();
    }
    
    public Layer(int neuronsCount) {
        this.neurons = new ArrayList<>(neuronsCount);
    }
    
    public Layer(String label, List<Neuron> neurons) {
        this.label = label;
        this.neurons = neurons;
    }
    
    public void calculate() {
//        getNeurons().parallelStream().forEach(Neuron::calculate);
        getNeurons().stream().forEach(Neuron::calculate);
    }
    
    public void addNeuron(Neuron neuron) {
        
        if(neuron == null) {
            throw new IllegalArgumentException("Neuron can not be null !");
        }
        
        neuron.setParent(this);
        
        getNeurons().add(neuron);
        
        // fire an event ?
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }
    
    public Neuron get(int index) {
        if(this.neurons.size() < index || index < 0) {
            String msg = String.format("You can not get this neuron,"
                    + " the requested index is out of bound !", index);
            throw new IndexOutOfBoundsException(msg);
        }
        return this.neurons.get(index);
    }
    
    private void input(int index, double value){
        
        if(this.neurons.size() < index || index < 0) {
            String msg = String.format("You cannot set the value of this neuron,"
                    + " the requested index is out of bound !", index);
            throw new IndexOutOfBoundsException(msg);
        }
        
        this.neurons.get(index).setInput(value);
    }
    
    public void input(double... inputs){
        
        if (null == inputs || inputs.length != this.neurons.size()) {
            throw new IllegalArgumentException("Inputs does not match network input dimension!"
                    + " Wanted " + this.neurons.size() + " get " + inputs.length);
        }
        
        int size = this.neurons.size();
        
        for (int i = 0; i < size; i++) {
            input(i, inputs[i]);
        }
    }

    private double output(int index){
        
        if(this.neurons.size() < index || index <0) {
            String msg = String.format("You can not set input value of this neuron,"
                    + " the requested index is out of bound !", index);
            throw new IndexOutOfBoundsException(msg);
        }
        
        return this.neurons.get(index).getOutput();
    }
    
    public double[] output() {
        int size = this.neurons.size();
        double[] outputs = new double[size];
        
        for (int i = 0; i < size; i++) {
            outputs[i] = output(i);
        }
        
        return outputs;
    }
    
    
    public void connect(int first, int second, double weight){
        Neuron n1 = get(first);
        Neuron n2 = get(second);
        
        n2.addInputConnection(n1, weight);
        n1.addOutputConnection(n2.getConnectionFrom(n1));
    }
    
}
