package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Predator feline;

    @Test
    public void getKittensNoParamsReturnOne() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void getFoodNoParamsReturnPredatorFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"),lion.getFood());
    }

    @Test
    public void wrongLionSexException() {
        try {
            Lion lion = new Lion("Гермафродит", feline);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            assertEquals("Используйте допустимые значения пола животного - \"Самец\" или \"Самка\"", thrown.getMessage());
        }
    }
}