/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.neural.network.Layer;
import com.neural.network.Neuron;

/**
 *
 * @author cdi305
 */
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
    }
}
