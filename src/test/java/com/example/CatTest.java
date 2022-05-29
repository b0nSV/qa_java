package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat cat;

    @Mock
    Feline feline;

    @Before
    public void before() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundNoParamsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodNoParamsPredatorFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}