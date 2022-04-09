package pl.zsl.androidapp.calculator;

public class Acumulator {
    private double value;
    private boolean empty = true;
    public boolean isEmpty(){
        return empty;
    }

    public void setValue(double val){
        value = val;
        empty = false;
    }

    public double getValue(){
        return value;
    }

    public void clear(){
        empty = true;
    }
}
