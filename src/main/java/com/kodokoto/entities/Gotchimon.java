package com.kodokoto.entities;

import com.kodokoto.graphics.Animation;
import com.kodokoto.items.Food;

public abstract class Gotchimon extends Entity {


    // logic variables
    protected final int maxHunger;
    protected final int maxHappiness;
    protected final int maxHealth;
    protected int hunger;
    protected int happiness;
    protected int health;

    protected boolean alive = true;

    // render variables
    protected int direction = 0;    // 0 = none, 1 = up, 2 = down, 3 = left, 4 = right
    protected Animation anim;

    public Gotchimon(float x, float y, int maxHealth, int maxHunger, int maxHappiness) 
    {
        super(x, y);
        this.maxHealth = maxHealth;
        this.maxHunger = maxHunger;
        this.maxHappiness = maxHappiness;    
    }


    // pet logic 

    @Override
    public void update() 
    {

        if (hunger > maxHunger) {
            hunger = maxHunger;
        }
        if (happiness > maxHappiness) {
            happiness = maxHappiness;
        }
        if (health > maxHealth) {
            health = maxHealth;
        }
        if (health < 0) {
            alive = false;
        }

        if (alive) {
            move();
        }
        
    }

    public void move()
    {
        // 2% chance of changing direction if not moving
        // 5% chance of changing direction if moving
        if (direction==0 && Math.random() < 0.02 ||direction!=0 && Math.random() < 0.05)
        {
            direction = (int) ((Math.random() * (5 - 0)) + 0);
        }

        switch (direction)
        {
            case 1:
                anim.update();
                y -= 1;
                if (isCollidingWithTiles())
                {
                    y += 1;
                }
                break;
            case 2:
                anim.update();
                y += 1;
                if (isCollidingWithTiles())
                {
                    y -= 1;
                }
                break;
            case 3:
                anim.update();
                x -= 1;
                if (isCollidingWithTiles())
                {
                    x += 1;
                }
                break;
            case 4:
                anim.update();
                x += 1;
                if (isCollidingWithTiles())
                {
                    x -= 1;
                }
                break;
            default:
                break;
        }
    }

    // playing with a pet reduces hunger and increases happiness

    public void play()
    {
        if (alive)
        {
            hunger -= 10;
            happiness += 10;    
        }
    };

    // feeding the pet changes their stats depending the food they are given

    public void feed(Food food)
    {
        if (alive)
        {
            hunger += food.getHungerImpact();
            happiness += food.getHappinessImpact();
            health += food.getHealthImpact();    
        }
    };

    // getters and seters

    public void setHunger(int amount)
    {
        hunger = amount;
    };

    public void setHappiness(int amount)
    {
        happiness = amount;
    };

    public void setHealth(int amount)
    {
        health = amount;
    };

    public int getHunger()
    {
        return hunger;
    };

    public int getHealth()
    {
        return health;
    };

    public int getHappiness()
    {
        return happiness;
    };

    // serialization id

    public static final long serialVersionUID = 1L;

}
