package dao;

import entity.City;
import entity.Country;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {
     public void insertCity(City city);
     public void updateCity(City city);
     public List<City> getAllCity(Country country);
     public Object[] getCity(String name);
}
