package com.maryna.zoo.animals;

public class Chicken extends Bird{

    private boolean isBroiler;

    private Chicken(String name) {
        this.name = name;
    }

    public boolean isBroiler() {
        return isBroiler;
    }

    public static class Builder extends Bird.Builder<Chicken>{
        public Builder(String name) {
            bird = new Chicken(name);
            bird.name = name;
        }

        public Builder broiler() {
            bird.isBroiler = true;
            return this;
        }

        public Builder notBroiler() {
            bird.isBroiler = false;
            return this;
        }
    }
}
