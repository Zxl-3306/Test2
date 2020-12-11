package com.company;

import java.time.LocalDate;

public class Beer extends Drinks{
    private float al_degree;//酒精度数
    static final int qg_period=30;
    public Beer() {

    }

    public Beer(double cost, String name, LocalDate date, float al_degree) {
        super(cost, name, date, qg_period);
        this.al_degree=al_degree;
    }

    @Override
    public String toString() {
        return name;
    }
}
