package com.maryna.zoo.animals;

public class Dog extends Animal{

    private Dog(Type type) {
        this.type = type;
    }

    private final Type type;

    public Type getType() {
        return type;
    }

    public enum Type {
        HUNTING_DOG, ASSISTANCE_DOG, RACING_DOG;
    }

    public static class Builder {
        private final Dog dog;

        public Builder(Type dogType, String name) {
            dog = new Dog(dogType);
            dog.name = name;
        }

        public Builder withFavouriteFood(String favouriteFood) {
            dog.favouriteFood = favouriteFood;
            return this;
        }

        public Dog build() {
            return dog;
        }
    }
}
