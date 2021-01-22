package dao.lmpl;

import dao.CountryDao;
import entity.City;
import entity.Country;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import tool.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryDaolmpl extends DB implements CountryDao {
    static Map<String,Integer> countryID=new HashMap<>();
    static {
        countryID.put("France",1);
        countryID.put("China",2);
        countryID.put("Japan",3);
        countryID.put("US",4);
        countryID.put("United Kingdom",5);
    }
    @Override
    public void insertCountry(Country country) {
        getConn();
        String sql="insert into country values(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner q=new QueryRunner();
        try {
            q.update(conn,sql,country.getId(),country.getName(),country.getSq_km_area(),country.getCapital_city()
                    ,country.getContinent(),country.getLocation(),country.getAbbreviation(),country.getConfirmed()
                    ,country.getRecovered(),country.getDeaths());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void updateCountry(Country country) {
        getConn();
        String sql="update country set sq_km_area = ? , capital_city = ? ,continent = ? ," +
                "location = ? , abbreviation = ? , confirmed = ? , " +
                "recovered = ? , deaths = ? " +
                "where ID=?";
        QueryRunner q=new QueryRunner();
        try {
            q.update(conn,sql,country.getSq_km_area(),country.getCapital_city(),
                    country.getContinent(),country.getLocation(),country.getAbbreviation(),
                    country.getConfirmed(),country.getRecovered(),country.getDeaths(),
                    country.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Country> getAllCountry() {
        String sql="select * from country";
        getConn();
        List<Country> list=null;
        QueryRunner q=new QueryRunner();
        try{
            list=q.query(conn,sql,new BeanListHandler< Country >(Country.class));
        }catch (Exception e){
            //e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Object[] getCountry(String name) {
        String sql="select*from country where ID=?";
        QueryRunner q=new QueryRunner();
        Object[] arr=null;
        getConn();
        try {
            arr=q.query(conn,sql,new ArrayHandler(),countryID.get(name));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return arr;
    }
    /*public Country getCountry1(String name) {
        String sql="select * from country where name = ?";
        QueryRunner q=new QueryRunner();
        Country country=null;
        getConn();
        try{
            country=q.query(conn,sql,new BeanPropertyRowMapper<>(Country.class),name);
        }catch (Exception e){
            //e.printStackTrace();
        }
        return country;
    }*/
}
