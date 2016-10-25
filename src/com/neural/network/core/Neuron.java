package com.neural.network.core;

import com.neural.network.core.input.InputFunction;
import com.neural.network.core.input.WeightedSum;
import com.neural.network.core.transfer.Step;
import com.neural.network.core.transfer.TransferFunction;
import java.util.ArrayList;
import java.util.List;

public class Neuron {
    
    private InputFunction inputFunction;
    private TransferFunction transferFunction;
    
    private List<Connection> inConnections;
    private List<Connection> outConnections;
    
    private double output;
    private double input;
    
    private Layer parent;

    public Neuron() {
        this(new WeightedSum(), new Step());
    }
    
    public Neuron(InputFunction inputFunction, TransferFunction transferFunction) {
        
        if(inputFunction == null) {
            throw new IllegalArgumentException("Input function cannot be null!");
        }
        
        if(transferFunction == null) {
            throw new IllegalArgumentException("Transfer function cannot be null!");
        }
        
        this.inputFunction    = inputFunction;
        this.transferFunction = transferFunction;
    }
    
    public void calculate(){
        this.input  = getInputConnectionOutput();
        this.output = transferFunction.getOutput(input);
    }
    
    protected double getInputConnectionOutput() {
        
        if(!this.hasInputConnections()) {
            // throw an error ? 
            return 0d;
        }
        
        return getInputFunction().getOutput(getInConnections());
    }
    
    public void reset(){
        setInput(0D);
        setOutput(0D);
    }
    
    public Weight[] getWeights() {
        return getInConnections().stream().map((Connection connection) -> {
            return connection.getWeight();
        }).toArray(Weight[]::new);
    }
    
    public Connection getConnectionFrom(Neuron fromNeuron) {
        return getInConnections().stream().filter((Connection connection) -> {
            return connection.getFrom().equals(fromNeuron);
        }).findFirst().orElse(null);
    }
    
    public boolean hasInputConnections(){
        return (getInConnections().size() > 0);
    }
    
    public boolean hasOutputConnectionTo(Neuron neuron){
        return getOutConnections().stream().anyMatch((connection) -> {
            return connection.getTo().equals(neuron);
        });
    }
    
    public boolean hasInputConnectionFrom(Neuron neuron){
        return getInConnections().stream().anyMatch((connection) -> {
            return connection.getFrom().equals(neuron);
        });
    }
    
    public void addInputConnection(Neuron from) {
        Connection connection = new Connection(from, this);
        addInputConnection(connection);
    }
    
    public void addInputConnection(Neuron from, double weight) {
        Connection connection = new Connection(from, this, weight);
        this.addInputConnection(connection);
    }
    
    public void addInputConnection(Connection connection){
        if(connection == null) {
            throw new IllegalArgumentException("You can not add a null connection !");
        }
        
        if(!connection.getTo().equals(this)) {
            throw new IllegalArgumentException("Can not add this connection, bad 'to neuron' !");
        }
        
        // do nothing if there is a connection.
        if(hasInputConnectionFrom(this)) {
            return;
        }
        
        getInConnections().add(connection);
        
        // add outputconnection
        connection.getFrom().addOutputConnection(connection);
        
    }
    
    public void addOutputConnection(Connection connection){
        
        if(connection == null) {
            throw new IllegalArgumentException("You can not add a null connection !");
        }
        
        if(!connection.getFrom().equals(this)) {
            throw new IllegalArgumentException("Can not add this connection, bad 'from neuron' !");
        }
        
        if(hasOutputConnectionTo(this)) {
            return;
        }
        
        getOutConnections().add(connection);
    }
    
    public final List<Connection> getInConnections() {
        
        if(inConnections == null) {
            inConnections = new ArrayList<>();
        }
        return inConnections;
    }
    
    public final List<Connection> getOutConnections() {
        if(outConnections == null) {
            outConnections = new ArrayList<>();
        }
        return outConnections;
    }

    protected void removeInputConnection(Connection conn) {
        getInConnections().remove(conn);
    }

    protected void removeOutputConnection(Connection conn) {
        getOutConnections().remove(conn);
    }

    public void setInputFunction(InputFunction inputFunction) {
        this.inputFunction = inputFunction;
    }

    public InputFunction getInputFunction() {
        return inputFunction;
    }
    
    public void setTransferFunction(TransferFunction transferFunction) {
        this.transferFunction = transferFunction;
    }

    public TransferFunction getTransferFunction() {
        return transferFunction;
    }
    
    public void setInput(double input) {
        this.input = input;
    }

    public double getInput() {
        return input;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getOutput() {
        return output;
    }

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }
}
