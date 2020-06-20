package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Continent {
    final List<Country> countryList = new ArrayList<>();

    public List<Country> addCuntry(Country country) {
        countryList.add(country);
        return countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
