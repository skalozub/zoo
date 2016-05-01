package com.maryna.zoo.animals;

public class Parrot extends Bird {

    private Parrot(String name) {
         this.name = name;
    }

    public static class Builder extends Bird.Builder<Parrot> {
        public Builder(String name) {
            bird = new Parrot(name);
            bird.name = name;
        }
    }
}
