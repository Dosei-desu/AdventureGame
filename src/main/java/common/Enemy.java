package common;

import items.Weapon;

public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;
    private int maxHealth;

    public Enemy(String name, String description, int health, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.maxHealth = health; //never affected after this, creating a pseudo-final variable
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth(){ //only used for visual component in "look()" method
        return maxHealth;
    }

    public Weapon getWeapon() { //used for when an enemy dies and we need its weapon to drop to the room
        return weapon;
    }

    public int attack(){ //used to get the damage from an enemy to damage the player
        return weapon.getDamage();
    }

    public void takeDamage(int damage){ //used to damage the enemy based on input
        health -= damage;
    }
}
