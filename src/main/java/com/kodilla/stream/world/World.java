package com.kodilla.stream.world;

import com.kodilla.stream.forum.ForumUser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class World {
    List<Continent> continentList = new ArrayList<>();

    public List<Continent> addContinent(Continent continent) {
        continentList.add(continent);
        return continentList;
    }

    public List<Continent> getContinentList() {
        return continentList;
    }

    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                //Dla każdego kontynentu pobieranm jego listę krajów i przekazuję do dalszego przetwarzania, aby pracować na krajach a nie kontynentach
                .flatMap(Continent -> Continent.getCountryList().stream())
                //dla każdego obiektu Cuntry zmieniam go na BigDecimal
                .map(Country::getPeopleQuantity)
                //dodaję do siebie obiekty
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
