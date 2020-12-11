package com.company;

public class SetMeal {
    public String t_name;//套餐名
    public double price;//套餐价格
    public String z_name;//炸鸡名
    public Drinks drinks;//饮料

    public SetMeal(String t_name, double price, String z_name, Drinks drinks) {
        this.t_name = t_name;
        this.price = price;
        this.z_name = z_name;
        this.drinks = drinks;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getZ_name() {
        return z_name;
    }

    public void setZ_name(String z_name) {
        this.z_name = z_name;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    public String toString(){
        return t_name;
    }
}
