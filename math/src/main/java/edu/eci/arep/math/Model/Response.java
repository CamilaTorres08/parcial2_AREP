package edu.eci.arep.math.Model;

public class Response {
    String operation;
    String inputlist;

    int value;
    int output;

    public Response(String op, String list, int val, int out){
        this.operation = op;
        this.inputlist = list;
        this.value = val;
        this.output = out;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getInputlist() {
        return inputlist;
    }

    public void setInputlist(String inputlist) {
        this.inputlist = inputlist;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}
