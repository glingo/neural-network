package com.neural.network.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeuralNetwork {
    
    private String label;
    
    private Layer input;
    
    private List<Layer> layers;
    
    private Layer output;
    
    public NeuralNetwork() {
        this.label = super.toString();
        this.layers = new ArrayList<>();
        this.input = new Layer();
        this.output = new Layer();
    }

    public NeuralNetwork(String label, Layer input, List<Layer> layers, Layer output) {
        this.label = label;
        this.input = input;
        this.layers = layers;
        this.output = output;
    }
    
    public void input(double... inputs){
        input.input(inputs);
    }
    
    public double[] output() {
        return this.output.output();
    }
    
    public void calculate() {
        input.calculate();
//        layers.parallelStream().forEach(Layer::calculate);
        layers.stream().forEach(Layer::calculate);
        output.calculate();
    }
    
}
