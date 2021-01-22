package WebDao;

import entity.Country;

import java.util.List;

public interface CountryWebDao {
    public String getCountryJson(String countryName);

    public Country getCountryByWeb(String countryName);

    public List<Country> getAllCountry();

    public void updateCountry(Country country);

    public void insertAllCountry();

    public void insertCountry(Country country);

    public Object[] getCountry(String countryName);
}
