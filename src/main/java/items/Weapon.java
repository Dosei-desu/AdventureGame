package items;

public abstract class Weapon extends Item{
    private int numberOfUses;
    private boolean equipped;
    private int damage;

    public Weapon(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, int numberOfUses, int damage) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION);
        this.numberOfUses = numberOfUses;
        this.damage = damage;
        setEquippable(true);
        setEquipped(false);
    }

    public AttackDTO attack(){
        return attack();
    }

    public int getDamage() {
        return damage;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}
