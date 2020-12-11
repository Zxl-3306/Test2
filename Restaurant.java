package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
      West2FriedChickenRestaurant restaurant=new West2FriedChickenRestaurant();
      ArrayList<SetMeal> list=restaurant.getList3();
      ArrayList<Beer> store1=restaurant.getStore1();
      ArrayList<Juice> store2=restaurant.getStore2();
      ArrayList<SetMeal> store3=restaurant.getStore3();
      Scanner sc=new Scanner(System.in);
      System.out.println("请选择所需要的服务：(请输入对应数字)");
      System.out.println("1.进货 2.销售 3.查询余额 4.结束查询");
      while (sc.hasNext()){
          String model=sc.next();
          if(model.equals("4")){
              System.out.println("查询结束");
              break;
          }
          switch (model){
              case "1":
                  System.out.println("进货界面：");
                  System.out.println("请输入进货所需套餐：(请输入对应数字)");
                  System.out.println("1.套餐1   2.套餐2");
                  try{
                      int num=sc.nextInt();
                      System.out.println("请输入购买数量：");
                      int count=sc.nextInt();
                      SetMeal setMeal;
                      if(num==1){
                          for (SetMeal setMeal1 : list) {
                              if(setMeal1.getT_name().equals("套餐1")) {
                                  setMeal=setMeal1;
                                  restaurant.bulk_purchase1(setMeal,count);
                                  break;}
                          }
                      }else if(num==2){
                          for (SetMeal setMeal1 : list) {
                              if(setMeal1.getT_name().equals("套餐2")) {
                                  setMeal=setMeal1;
                                  restaurant.bulk_purchase1(setMeal,count);
                                  break;}
                          }
                      }
                  }catch (Exception e){
                      System.out.println("输入有误，请重新输入：");
                  }
                  break;
              case "2":
                  System.out.println("销售界面：");
                  System.out.println("1.套餐1   2.套餐2");
                  System.out.println("请输入购买所需套餐：(请输入对应数字)");
                  try{
                      int num1=sc.nextInt();
                      SetMeal setMeal ;
                      if(num1==1){
                          for (SetMeal setMeal1 : store3) {
                              if(store1.isEmpty()){
                                  System.out.println("套餐1已经售完了哦");
                                  break;
                              }
                              if(setMeal1.getT_name().equals("套餐1")) {
                                  setMeal=setMeal1;
                                  restaurant.sellMeal(setMeal);
                                  break;
                              }
                          }
                      }
                      else if(num1==2){
                          for (SetMeal setMeal1 : store3) {
                              if(store2.isEmpty()){
                                  System.out.println("套餐2已经售完了哦");
                                  break;
                              }
                              if(setMeal1.getT_name().equals("套餐2")) {
                                  setMeal=setMeal1;
                                  restaurant.sellMeal(setMeal);
                                  break;}
                          }
                      }
                  }
                  catch (Exception e){
                      //e.printStackTrace();
                      System.out.println("输入有误，请重新输入：");
                  }
                  break;
              case "3":
                  System.out.println("查询余额界面：");
                  System.out.println("当前的余额为"+restaurant.getBalance()+"元");
                  break;
              default:
                  System.out.println("非法输入");
          }
          System.out.println("请选择所需要的服务：(请输入对应数字)");
          System.out.println("1.进货 2.销售 3.查询余额 4.结束查询");
      }
    }
}
