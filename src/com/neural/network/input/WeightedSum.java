package com.neural.network.input;

import com.neural.network.Connection;
import java.util.List;

public class WeightedSum implements InputFunction {
    
    @Override
    public double getOutput(List<Connection> inConnections) {
        return inConnections.stream().mapToDouble((connection) -> {
            return connection.getWeightedInput();
        }).sum();
    }

//    public static double[] getOutput(double[] inputs, double[] weights) {
//        double[] output = new double[inputs.length];
//
//        for (int i = 0; i < inputs.length; i++) {
//            output[i] += inputs[i] * weights[i];
//        }
//
//        return output;
//    }
}
