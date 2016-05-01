package com.maryna.zoo;

import com.maryna.zoo.animals.Animal;
import com.maryna.zoo.animals.Dog;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.maryna.zoo.animals.Dog.Type.ASSISTANCE_DOG;
import static com.maryna.zoo.animals.Dog.Type.HUNTING_DOG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class ZooTest {
    private Zoo zoo;

    @Before
    public void setUp() throws Exception {
        Set<Animal> animals = new HashSet<>();
        animals.add(new Dog.Builder(HUNTING_DOG, "Dog one").withFavouriteFood("Meat").build());
        animals.add(new Dog.Builder(ASSISTANCE_DOG, "Dog two").withFavouriteFood("Fresh meat").build());
        zoo = new Zoo(animals);
    }

    @Test
    public void testNextDay() throws Exception {
        zoo.getAnimals().forEach(animal -> assertEquals(0, animal.getFriends().size()));
        for (int i = 0; i < 5; i++) {
            zoo.nextDay();
            zoo.getAnimals().forEach(animal -> {
                assertEquals(1, animal.getFriends().size());
                Animal friend = animal.getFriends().iterator().next();
                assertNotNull(friend);
                assertNotEquals(animal, friend);
            });
        }
    }
}
