package com.neural.network.input;

import com.neural.network.Connection;
import java.util.List;

@FunctionalInterface
public interface InputFunction {
    
    double getOutput(List<Connection> connections);
}
