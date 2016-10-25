package com.neural.network.core.input;

import com.neural.network.core.Connection;
import java.util.List;

@FunctionalInterface
public interface InputFunction {
    
    double getOutput(List<Connection> connections);
}
