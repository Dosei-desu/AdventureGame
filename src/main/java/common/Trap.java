package common;

import items.Weapon;

public class Trap extends Enemy{
    //the reason why we make a sub-class of enemy is to cases where we want to have a specific action due to it being a
    //trap and not a normal enemy
    public Trap(String enemy, String description, int health, Weapon weapon) {
        super(enemy, description, health, weapon);
    }
}
