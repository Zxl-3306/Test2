package com.company;

import java.time.LocalDate;
import java.time.Period;

public abstract class Drinks {
  protected double cost;//成本
  protected String name;//饮料名称
  protected LocalDate date;//生产日期
  protected int qg_period;//保质期

    public Drinks() {
    }

    public Drinks(double cost, String name, LocalDate date, int qg_period) {
        this.cost = cost;
        this.name = name;
        this.date = date;
        this.qg_period=qg_period;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQg_period() {
        return qg_period;
    }

    public void setQg_period(int qg_period) {
        this.qg_period = qg_period;
    }

    public void overdue(LocalDate date, int qg_period){
        LocalDate today=LocalDate.now();
        //Period next=Period.between(date,today);
        //System.out.println(today);
        if(today.toEpochDay()-date.toEpochDay()>qg_period){
            System.out.println("饮料已过期");
        }else{
            System.out.println("饮料未过期");
        }
    }
    @Override
    public abstract String toString() ;
}
