package com;

import com.neural.network.Layer;
import com.neural.network.NeuralNetwork;
import com.neural.network.Neuron;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Neuron n1 = new Neuron();
        Neuron n2 = new Neuron();
        Neuron n3 = new Neuron();
        Neuron n4 = new Neuron();
        
        Layer l1 = new Layer();
        l1.addNeuron(n1);
        l1.addNeuron(n2);
        
        Layer l2 = new Layer();
        l2.addNeuron(n3);
        l2.addNeuron(n4);
        
        n4.addInputConnection(n1, 0.5);
        n1.addOutputConnection(n4.getConnectionFrom(n1));
        n4.addInputConnection(n2, 0.5);
        n2.addOutputConnection(n4.getConnectionFrom(n2));
        
        l1.calculate();
        
        Layer input = createLayer(4);
        Layer output = createLayer(2);
        
//        List
        
        
//        NeuralNetwork nn = new NeuralNetwork("nn-test", l1, );
//        
//        
//        nn.input(1.0d, 1.0d, 1.0d, 1.0d);
//        nn.output();
//        System.out.println(nn.output());
        
    }
    
    private static List<Neuron> createNeuronList(int count){
        List<Neuron> list = new ArrayList<>(count);
        
        for (; count < 0; count--) {
            list.set(count, new Neuron());
        }
        
        return list;
    }
    
    private static Layer createLayer(int neuronCount){
        return new Layer("auto-created-layer-" + 
                new Date().getTime() * (Math.random() + 1), 
                createNeuronList(neuronCount));
    }
    
    private static Layer createFullyConnectedLayer(int neuronCount, double weight){
        Layer fc = createLayer(neuronCount);
        
        for (int i = 1; i < neuronCount; i++) {
            fc.connect(i, i-1, weight);
        }
        
        return fc;
    }
}
