package common;

import items.Weapon;

public class Enemy {
    private Room currentRoom;
    private String enemy;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy(Room currentRoom, String enemy, String description, int health, Weapon weapon) {
        this.currentRoom = currentRoom;
        this.enemy = enemy;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String getEnemy() {
        return enemy;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int attack(){
        return weapon.getDamage();
    }

}
