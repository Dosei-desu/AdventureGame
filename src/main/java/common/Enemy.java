package common;

import items.Weapon;

public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;
    private int maxHealth;

    public Enemy(String enemy, String description, int health, Weapon weapon) {
        this.name = enemy;
        this.description = description;
        this.health = health;
        this.maxHealth = health;
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

    public int getMaxHealth(){
        return maxHealth;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int attack(){
        return weapon.getDamage();
    }

    public void takeDamage(int damage){
        health -= damage;
    }
}
