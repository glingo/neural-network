package com.neural.network;

public class Connection {
    
    private Neuron from;
    private Neuron to;
    private Weight weight;

    public Connection(Neuron from, Neuron to) {
        if(from == null) {
            throw new IllegalArgumentException("From neuron in connection cant be null !");
        }
        
        if(to == null) {
            throw new IllegalArgumentException("To neuron in connection cant be null !");
        }
        
        this.from = from;
        this.to = to;
        this.weight = new Weight();
    }

    public Connection(Neuron from, Neuron to, Weight weight) {
        this(from, to);
        
        if(weight == null) {
            throw new IllegalArgumentException("Connection Weight cant be null !");
        }
        
        this.weight = weight;
    }
    
    public Connection(Neuron from, Neuron to, double weight) {
        this(from, to, new Weight(weight));
    }
    
    public double getWeightedInput() {
        return getFrom().getOutput() * getWeight().getValue();
    }
    
    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
    
    public Neuron getFrom() {
        return from;
    }

    public void setFrom(Neuron from) {
        this.from = from;
    }
    
    public Neuron getTo() {
        return to;
    }

    public void setTo(Neuron to) {
        this.to = to;
    }
    
}
