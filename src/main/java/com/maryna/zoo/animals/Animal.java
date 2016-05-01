package com.maryna.zoo.animals;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Animal {

    protected String name;
    protected String favouriteFood;
    private Set<Animal> friends = new HashSet<>();

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public Set<Animal> getFriends() {
        return friends;
    }

    public void addFriend(Animal friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
            System.out.println(getName() + " has established friendship with " + friend.getName());
            friend.addFriend(this);
        }
    }

    public void removeFriend(Animal friend) {
        if (friends.contains(friend)) {
            friends.remove(friend);
            System.out.println(getName() + " has lost friendship with " + friend.getName());
            friend.removeFriend(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Animal{" +
                "name='" + name + "\', friends[");
        sb.append(friends.stream().map(animal -> animal.getName()).collect(Collectors.joining(", ")));
        sb.append("']}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        if (!name.equals(animal.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
