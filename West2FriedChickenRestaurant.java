package com.company;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant{
    private double balance=10000;//餐厅账目余额
    private static ArrayList<Beer> list1;//啤酒列表
    private static ArrayList<Juice> list2;//果汁列表
    private static ArrayList<SetMeal> list3;//套餐列表
    private static ArrayList<Beer> store1;//啤酒仓库
    private static ArrayList<Juice> store2;//果汁仓库
    private static ArrayList<SetMeal> store3;//套餐仓库

    public static ArrayList<SetMeal> getList3() {
        return list3;
    }
    public static ArrayList<Beer> getStore1() {
        return store1;
    }
    public static ArrayList<Juice> getStore2() {
        return store2;
    }
    public static ArrayList<SetMeal> getStore3() {
        return store3;
    }

    public double getBalance() {
        return balance;
    }

    static {
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        list1.add(new Beer(10.0,"雪津",LocalDateTime.now().toLocalDate(),0.03f));
        list1.add(new Beer(15.0,"百威",LocalDateTime.now().toLocalDate(),0.05f));
        list1.add(new Beer(100.0,"二锅头",LocalDateTime.now().toLocalDate(),0.3f));
        list2.add(new Juice(20.0,"橙汁",LocalDateTime.now().toLocalDate()));
        list2.add(new Juice(5.0,"椰汁",LocalDateTime.now().toLocalDate()));
        list3.add(new SetMeal("套餐1",30,"炸鸡1",new Beer(10.0,"雪津",LocalDateTime.now().toLocalDate(),0.03f)));
        list3.add(new SetMeal("套餐2",35,"炸鸡2",new Juice(20.0,"橙汁",LocalDateTime.now().toLocalDate())));

        store1=new ArrayList<>();
        store2=new ArrayList<>();
        store3=new ArrayList<>();
    }

    private void use(Beer beer){
        //System.out.println(store1);
        int time=0;
        if(time<store1.size()){
        for(Beer beer1:store1){
           if(beer1.getName().equals(beer.getName())) {
               store1.remove(beer1);
               System.out.println("购买成功!");
               break;
           }
           time++;
        }}else{
            throw new IngredientSortOutException("该啤酒已经售完了哦");
        }
        //System.out.println(store1);
    }
    private void use(Juice juice){
        //System.out.println(store2);
        int time=0;
        if(time<store2.size()){
        for(Juice juice1:store2){
            if(juice1.getName().equals(juice.getName())) {
                store2.remove(juice1);
                System.out.println("购买成功!");
                break;
            }
            time++;
        }}else{
                throw new IngredientSortOutException("该果汁已经售完了哦");
            }
        //System.out.println(store2);
        }

    @Override
    public void sellMeal(SetMeal setMeal) {
        this.balance=balance+ setMeal.price;
        //System.out.println(store3);
        for(int i=0;i<store3.size();i++){
            if(store3.get(i).getT_name().equals(setMeal.t_name)){
                store3.remove(i);
                break;
            }
        }
        if(setMeal.getDrinks() instanceof Beer){
            use((Beer)setMeal.getDrinks());
        }else if(setMeal.getDrinks() instanceof Juice){
            use((Juice)setMeal.getDrinks());
        }
        //System.out.println(store3);
    }

    @Override
    public void bulk_purchase1(SetMeal setMeal,int count) {
        if(balance>setMeal.price*count){
            for(int i=0;i<count;i++){
                Drinks drink= setMeal.getDrinks();
                store3.add(setMeal);
                bulk_purchase2(drink);
                //list1.add((Beer)drink);
            }
            this.balance=balance- setMeal.price*count;
            System.out.println("进货成功!");
        }else{
            double difference=setMeal.price*count-balance;
            throw new OverdraftBalanceException("进货费超出余额,还差"+difference+"元");
        }
        //System.out.println(store3+"999999");
    }

    @Override
    public void bulk_purchase2(Drinks drinks) {
        if(balance>drinks.cost){
            if(drinks instanceof Beer){
                store1.add((Beer)drinks);
            }else if(drinks instanceof Juice){
                store2.add((Juice)drinks);
            }
        }else{
            double difference=drinks.cost-balance;
            throw new OverdraftBalanceException("进货费超出余额,还差"+difference+"元");        }
    }
}
