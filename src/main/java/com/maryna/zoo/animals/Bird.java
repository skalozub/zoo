package com.maryna.zoo.animals;

public abstract class Bird extends Animal {

    protected double wingSpan;

    public double getWingSpan() {
        return wingSpan;
    }

    public static abstract class Builder<T extends Bird> {
        protected T bird;

        public Builder withFavouriteFood(String favouriteFood) {
            bird.favouriteFood = favouriteFood;
            return this;
        }

        public Builder withWingSpan(double wingSpan) {
            bird.wingSpan = wingSpan;
            return this;
        }

        public T build() {
            return bird;
        }
    }
}
