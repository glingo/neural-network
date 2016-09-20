package com.neural.network;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    
    private String label;
    private List<Neuron> neurons;

    public Layer() {
        this.neurons =  new ArrayList<>();
    }
    
    public Layer(int neuronsCount) {
        this.neurons =  new ArrayList<>(neuronsCount);
    }
    
    public Layer(String label, List<Neuron> neurons) {
        this.label = label;
        this.neurons = neurons;
    }
    
    public void calculate() {
        getNeurons().parallelStream().forEach(Neuron::calculate);
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
    
}
