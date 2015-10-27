package com.ufu.disease.to;

public enum Operator {

    IGUAL("="), DIFERENTE("!="), MAIOR(">=") , MENOR("<");

    private String op;

    Operator(String op) {
        this.op = op;
    }

    public String getNumVal() {
        return op;
    }
    
    public static Operator getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}

