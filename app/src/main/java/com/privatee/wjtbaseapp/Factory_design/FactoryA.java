package com.privatee.wjtbaseapp.Factory_design;

public class FactoryA extends Factory{
    @Override
    public product create() {
        return new productA();
    }
}
