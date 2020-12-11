package com.company;

import java.time.LocalDate;

public class Juice extends Drinks{
    static final int qg_period=2;
    public Juice() {
    }

    public Juice(double cost, String name, LocalDate date) {
        super(cost, name, date, qg_period);
    }

    @Override
    public String toString() {
        return name;
    }
}
