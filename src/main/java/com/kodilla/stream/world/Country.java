package com.kodilla.stream.world;

import com.kodilla.stream.invoice.simple.SimpleItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Country {

    BigDecimal peopleQuantity;

    public Country(BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(getPeopleQuantity(), country.getPeopleQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPeopleQuantity());
    }
/*BigDecimal value;

    public Country(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getPeopleQuantity(BigDecimal value) {
        BigDecimal peopleQuantity = value;
        return peopleQuantity;
    }*/

}
