package com.kodokoto.items;

// food class for the game, each instance has its own unique attributes

public class Food 
{
    protected int hungerImpact;
    protected int healthImpact;
    protected int happinessImpact;

    public Food(int hungerImpact, int healthImpact, int happinessImpact) {
        this.hungerImpact = hungerImpact;
        this.healthImpact = healthImpact;
        this.happinessImpact = happinessImpact;
    }

    // getters

    public int getHealthImpact() {
        return healthImpact;
    }

    public int getHappinessImpact() {
        return happinessImpact;
    }

    public int getHungerImpact() {
        return hungerImpact;
    }
}


