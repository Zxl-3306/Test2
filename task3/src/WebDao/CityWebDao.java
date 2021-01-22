package WebDao;

import entity.City;
import entity.Country;

import java.util.List;

public interface CityWebDao {
    public List<City> getAllCity(Country country);

    public Object[] getCity(String name);

    public City getCityByWeb(Country country,String name);

    public List<City> getAllCityByWeb(Country country);

    public void insertAll(List<City> cities);

    public void insertCity(City city);

    public void updateCity(City city);

    public void updateAllCityByWeb(Country country);
}
