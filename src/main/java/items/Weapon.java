package items;

public abstract class Weapon extends Item{
    private int numberOfUses;
    private boolean equipped;

    public Weapon(String NAME, String FUNCTION, String DESCRIPTION, int numberOfUses) {
        super(NAME, FUNCTION, DESCRIPTION);
        this.numberOfUses = numberOfUses;
        setEquippable(true);
        setEquipped(false);
    }

    public Weapon(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, int numberOfUses) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION);
        this.numberOfUses = numberOfUses;
        setEquippable(true);
        setEquipped(false);
    }

    public ReturnAttackMessage attack(){
        //dummy return, which will never be used because Abstract Class cannot be instantiated
        return ReturnAttackMessage.CANT_ATTACK;
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
