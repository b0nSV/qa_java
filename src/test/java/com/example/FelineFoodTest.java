package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineFoodTest {
    private final String animalKind;
    private final List<String> expectedFood;

    public FelineFoodTest(String animalKind, List<String> expectedFood){
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineFoodData () {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void shouldReturnCorrectFoodForEachAnimalKind () throws Exception {
        Feline feline = new Feline();
        assertEquals(expectedFood, feline.getFood(animalKind));
    }
}
