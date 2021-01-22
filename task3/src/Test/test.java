package Test;

import WebDao.CityWebDao;
import WebDao.CountryWebDao;
import WebDao.lmpl.CityWeblmpl;
import WebDao.lmpl.CountryWeblmpl;
import entity.Country;

public class test {
    public static void main(String[] args) {
        CountryWebDao countryWebDao=new CountryWeblmpl();
        CityWebDao cityWebDao=new CityWeblmpl();
        countryWebDao.insertAllCountry();
        for (Country country : countryWebDao.getAllCountry()) {
            cityWebDao.insertAll(cityWebDao.getAllCityByWeb(country));
        }
    }

}
