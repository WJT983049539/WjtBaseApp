package com.privatee.wjtbaseapp.Factory_design;

public class FactoryB extends Factory{
    @Override
    public product create() {

        return new productB();
    }
}
