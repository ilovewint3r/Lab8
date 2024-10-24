package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City addedCity = new City("Estevan", "SK");
        City dummyCity = new City("Weyburn","SK");
        list.addCity(addedCity);
        Assertions.assertTrue(list.hasCity(addedCity));
        Assertions.assertFalse(list.hasCity(dummyCity));

    }
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city = new City("Estevan","SK");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(list.getCount(), 0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });


    }
}
