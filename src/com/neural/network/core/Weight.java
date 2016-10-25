package com.neural.network.core;

import java.util.Random;

public class Weight {
    
    private double value;

    public Weight() {
        this.value = Math.random() - 0.5D;
    }

    public Weight(double value) {
        this.value = value;
    }
    
    public void increase(double value){
        this.value += value;
    }
    
    public void decrease(double value){
        this.value -= value;
    }
    
    public void randomize(double min, double max) {
        this.value = min + Math.random() * (max - min);
    }
    
    public void randomize(Random generator) {
        this.value = generator.nextDouble();
    }
    
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
