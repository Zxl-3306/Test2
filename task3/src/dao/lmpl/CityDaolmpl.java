package dao.lmpl;

import dao.CityDao;
import dao.CountryDao;
import entity.City;
import entity.Country;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tool.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CityDaolmpl extends DB implements CityDao {
    @Override
    public void insertCity(City city){
        getConn();
        String sql="insert into city(Name,cid,confirmed,recovered,deaths) values(?,?,?,?,?)";
        QueryRunner q=new QueryRunner();
        try {
            q.update(conn,sql,city.getName(),city.getCid(),city.getConfirmed(),city.getRecovered(),city.getDeaths());
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
    public void updateCity(City city) {
        getConn();
        String sql="update city set confirmed = ?,recovered=?,deaths=? where id=? and cid=?";
        QueryRunner q=new QueryRunner();
        try {
            q.update(conn,sql,city.getConfirmed(),city.getRecovered(),city.getRecovered(),city.getId(),city.getCid());
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
    public List<City> getAllCity(Country country){
        List<City> list=null;
        //String sql="select*from city,country where city.CID=country.ID and city.CID=?";
        String sql="select*from city where CID=?";
        QueryRunner q=new QueryRunner();
        getConn();
        try {
            list=q.query(conn,sql,new BeanListHandler<City>(City.class),country.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
    public Object[] getCity(String name) {
        Object[] arr=null;
        String sql="select*from city where name=?";
        QueryRunner q=new QueryRunner();
        getConn();
        try {
            arr=q.query(conn,sql,new ArrayHandler(),name);
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
}
