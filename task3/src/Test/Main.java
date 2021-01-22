package Test;

import WebDao.CityWebDao;
import WebDao.CountryWebDao;
import WebDao.lmpl.CityWeblmpl;
import WebDao.lmpl.CountryWeblmpl;
import entity.City;
import entity.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CountryWebDao countryWebDao=new CountryWeblmpl();
        CityWebDao cityWebDao=new CityWeblmpl();
        countryWebDao.insertAllCountry();
        for (Country country : countryWebDao.getAllCountry()) {
            cityWebDao.insertAll(cityWebDao.getAllCityByWeb(country));
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择(请输入功能编号): 1.查询 2.更新 3.退出" );
        while(sc.hasNext()) {
            int num = sc.nextInt();
            if(num==3){
                System.out.println("退出成功");
                break;
            }
            switch (num) {
                case 1:
                    System.out.println("请选择(请输入功能编号): 1.查询所有国家 2.查询单一国家 3.查询单个国家的所有城市 4.查询单个城市 5.退出查询");
                    int num1 = sc.nextInt();
                    if(num1==5){
                        System.out.println("退出成功");
                        break;
                    }
                    switch (num1) {
                        case 1:
                            for (Country country : countryWebDao.getAllCountry()) {
                                System.out.println(country.toString().replace("entity.Country",""));
                            }
                        break;
                        case 2:
                            System.out.println("请输入国家名称(英文):");
                            String name = sc.next();
                            try {
                                String s_name= (String) countryWebDao.getCountry(name)[1];
                                if(name.equals(s_name)) {
                                    System.out.println(countryWebDao.getCountryByWeb(s_name).toString());
                                }
                            } catch (Exception e) {
                                System.out.println("请输入正确的国家名称");
                            }
                            break;
                        case 3:
                            System.out.println("请输入国家名称(英文):");
                            String name1 = sc.next();
                                for (int i=0;i<countryWebDao.getAllCountry().size();i++) {
                                    if(countryWebDao.getAllCountry().get(i).getName().equals(name1)) {
                                        for (City city : cityWebDao.getAllCity(countryWebDao.getAllCountry().get(i))) {
                                            System.out.println(city.toString());
                                        }
                                        break;
                                    }
                                    //System.out.println(i);
                                    if(i==countryWebDao.getAllCountry().size()-1){
                                        System.out.println("请输入正确国家名称");
                                        break;
                                    }
                            }
                            break;
                        case  4:
                            System.out.println("请输入国家名称(英文):");
                            String name2 = sc.next();
                            System.out.println("请输入城市名称(英文):");
                            String name3=sc.next();
                            try {
                                String s_name= (String) cityWebDao.getCity(name3)[1];
                                if(name3.equals(s_name)) {
                                    System.out.println(cityWebDao.getCityByWeb(countryWebDao.getCountryByWeb(name2),name3 ));
                                }
                            } catch (Exception e) {
                                System.out.println("请输入正确的城市名称");
                            }
                            break;
                    }
                    //System.out.println("请选择(请输入功能编号): 1.查询所有国家 2.查询单一国家 3.查询单个国家的所有城市 4.查询单个城市 5.退出查询");
                    break;
                case 2:
                    List<Country> list=new ArrayList<>();
                    for (Country country : countryWebDao.getAllCountry()) {
                        list.add(country);
                    }
                    for(int i=0;i< list.size();i++){
                        for (Country country : list) {
                            countryWebDao.updateCountry(country);
                            cityWebDao.updateAllCityByWeb(country);
                        }
                    }
                    System.out.println("更新成功");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");

            }
            System.out.println("请选择(请输入功能编号): 1.查询 2.更新 3.退出" );
        }
    }
}
