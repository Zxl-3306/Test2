package dao;

import entity.Country;

import java.util.List;

public interface CountryDao {
    public void insertCountry(Country country);

    public void updateCountry(Country country);

    public List<Country> getAllCountry();

    public Object[] getCountry(String name);
}
