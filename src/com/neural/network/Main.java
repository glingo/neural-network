package com.neural.network;

import com.neural.network.core.Layer;
import com.neural.network.core.NeuralNetwork;
import com.neural.network.core.Neuron;
import com.neural.network.support.neuron.InputNeuron;
import com.neural.network.support.neuron.InputOutputNeuron;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    
    
    /*
     *              O
     *      O               O
     *              O
     *      O
     *              O
     *      O               O
     *              O
     */
    
    
    public static void main(String[] args) {
//        Neuron n1 = new Neuron();
//        Neuron n2 = new Neuron();
//        Neuron n3 = new Neuron();
//        Neuron n4 = new Neuron();
//        
//        Layer l1 = new Layer();
//        l1.addNeuron(n1);
//        l1.addNeuron(n2);
//        
//        Layer l2 = new Layer();
//        l2.addNeuron(n3);
//        l2.addNeuron(n4);
//        
//        n4.addInputConnection(n1, 0.5);
//        n1.addOutputConnection(n4.getConnectionFrom(n1));
//        n4.addInputConnection(n2, 0.5);
//        n2.addOutputConnection(n4.getConnectionFrom(n2));
//        
//        l1.calculate();
        
        Layer input = createInputLayer(3);
        Layer hidden = createLayer("hidden", 4);
        Layer output = createLayer("output", 2);
        
        System.out.println("input layer : " + input.getNeurons());
        System.out.println("hidden layer : " + hidden.getNeurons());
        System.out.println("output layer : " + output.getNeurons());
        
        for (int i = 0; i < hidden.getNeurons().size(); i++) {
            Neuron h = hidden.get(i);
            
            // connect input with hidden
            for (int j = 0; j < input.getNeurons().size(); j++) {
                h.addInputConnection(input.get(j));
            }
            
            // connect hidden with output
            for (int j = 0; j < output.getNeurons().size(); j++) {
                output.get(j).addInputConnection(h);
            }
            
        }
        
        List<Layer> hiddens = new ArrayList<>();
        
        hiddens.add(hidden);
        
        NeuralNetwork nn = new NeuralNetwork("nn-test", input, hiddens, output);
        
        nn.input(1.0d, 1.0d, 1.0d);
        nn.calculate();
        
//        nn.output();
        System.out.println("output :");
        System.out.println(Arrays.toString(nn.output()));
        
    }
    
    private static List<Neuron> createNeuronList(int count){
        List<Neuron> list = new ArrayList<>(count);
        
        System.out.println("creating " + count + " neuron !");
        
        for (int i = 0; i < count; i++) {
            list.add(i, new InputOutputNeuron());
        }
        
        return list;
    }
    
    private static Layer createLayer(String name, int neuronCount){
        return new Layer(name, createNeuronList(neuronCount));
    }
    
    private static Layer createInputLayer(int neuronCount){
        return new Layer("auto-generated-layer-input", createInputNeuronList(neuronCount));
    }
    
    private static List<Neuron> createInputNeuronList(int count){
        List<Neuron> list = new ArrayList<>(count);
        
        for (int i = 0; i < count; i++) {
            list.add(i, new InputNeuron());
        }
        
        return list;
    }
    
    private static Layer createFullyConnectedLayer(String name, int neuronCount, double weight){
        Layer fc = createLayer(name, neuronCount);
        
        for (int i = 1; i < neuronCount; i++) {
            fc.connect(i, i-1, weight);
        }
        
        return fc;
    }
}
