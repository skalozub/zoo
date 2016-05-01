package com.maryna.zoo;

import com.maryna.zoo.animals.Animal;
import com.maryna.zoo.animals.Chicken;
import com.maryna.zoo.animals.Dog;
import com.maryna.zoo.animals.Parrot;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.maryna.zoo.animals.Dog.Type.*;

public class Main {

    public static void main(String args[]) {

        String choice;

        Zoo zoo = new Zoo(createAnimals());
        Scanner scanIn = new Scanner(System.in);

        do {
            menu();
            choice = scanIn.nextLine();

            switch (choice) {
                case "1":
                    zoo.printAnimals();
                    break;
                case "2":
                    zoo.nextDay();
            }

        } while (!"3".equals(choice));

        scanIn.close();
    }

    private static void menu() {
        System.out.println();
        System.out.println("1. List all animals with their properties and friends' names.");
        System.out.println("2. Live one day.");
        System.out.println("3. Exit.");
    }

    private static Set<Animal> createAnimals() {
        Set<Animal> animals = new HashSet<>();
        animals.add(new Dog.Builder(HUNTING_DOG, "Dog one").withFavouriteFood("Meat").build());
        animals.add(new Dog.Builder(ASSISTANCE_DOG, "Dog two").withFavouriteFood("Fresh meat").build());
        animals.add(new Dog.Builder(RACING_DOG, "Dog three").withFavouriteFood("Pedigree").build());
        animals.add(new Parrot.Builder("Parrot one").withFavouriteFood("Grain").withWingSpan(0.25).build());
        animals.add(new Parrot.Builder("Parrot two").withFavouriteFood("Corn").withWingSpan(0.5).build());
        animals.add(new Chicken.Builder("Chicken one").broiler().withFavouriteFood("Corn").withWingSpan(0.75).build());
        animals.add(new Chicken.Builder("Chicken two").notBroiler().withFavouriteFood("Corn").withWingSpan(0.75).build());
        return animals;
    }
}
