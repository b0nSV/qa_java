package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    Feline feline;

    @Before
    public void before(){
        feline = new Feline();
    }

    @Test
    public void eatMeatNoParamsPredatorFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyNoParamsFeline() {
        assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void getKittensNoParamsReturnsOne() {
        assertEquals(1,feline.getKittens());
    }

    @Test
    public void getKittensPositiveNumberReturnsPositiveNumber() {
        assertEquals(2147483647,feline.getKittens(2147483647));
    }

    @Test
    public void getKittensNegativeNumberReturnsNegativeNumber() {
        assertEquals(-2147483648,feline.getKittens(-2147483648));
    }

    @Test
    public void getFoodUnknownAnimalKindException () {
        try {
            feline.getFood("Семеноед");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
        }
    }
}