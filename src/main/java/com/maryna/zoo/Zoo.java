package com.maryna.zoo;

import com.maryna.zoo.animals.Animal;

import java.security.SecureRandom;
import java.util.*;

public class Zoo {
    private int day = 1;

    private final Set<Animal> animals;

    private Random random = new SecureRandom();

    public Zoo(Set<Animal> animals) {
        this.animals = Collections.unmodifiableSet(animals);
    }

    public void printAnimals() {
        animals.forEach(animal -> System.out.println(animal));
    }

    public void nextDay() {
        day++;
        System.out.println("=============DAY " + day + " START");

        animals.forEach(animal -> animal.removeFriend(pickFriendForRemoval(animal)));
        animals.forEach(animal -> {
            Animal friend = pickNewFriend(animal);
            if (friend != null) {
                animal.addFriend(friend);
            }
        });

        System.out.println("=============DAY " + day + " END");
    }

    private Animal pickFriendForRemoval(Animal animal) {
        if (animal.getFriends().isEmpty()) {
            return null;
        }
        Animal friendToRemove = pickRandomAnimal(animal.getFriends());
        return friendToRemove;
    }

    private Animal pickNewFriend(Animal animal) {
        Animal friend = pickRandomAnimal(getAnimalsEligibleForFriendship(animal));
        return friend;
    }

    private Animal pickRandomAnimal(Set<Animal> animals) {
        if (animals.isEmpty()) {
            return null;
        }
        int size = animals.size();
        int randomIndex = random.nextInt(size);
        return new ArrayList<>(animals).get(randomIndex);
    }

    private Set<Animal> getAnimalsEligibleForFriendship(Animal animal) {
        Set<Animal> animalsCopy = new HashSet<>(animals);
        animalsCopy.removeAll(animal.getFriends());
        animalsCopy.remove(animal);
        return animalsCopy;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }
}
