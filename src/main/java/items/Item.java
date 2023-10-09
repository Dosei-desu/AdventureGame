package items;

public class Item {
    //'Protected' means that it cannot be used outside the class, but can be used by subclasses and package methods
    //to make this work, such that these variables are not accessible where they shouldn't be
    protected final String NAME;
    protected final String FUNCTION;
    protected final String DESCRIPTION;
    protected final String ROOM_DESCRIPTION;
    //dynamic variables
    protected boolean isEquippable;
    protected boolean isEquipped;
    protected int numberOfUses;

    public Item(String NAME, String FUNCTION, String DESCRIPTION) {
        this.NAME = NAME;
        this.FUNCTION = FUNCTION;
        this.DESCRIPTION = DESCRIPTION;
        this.ROOM_DESCRIPTION = "";
        setEquippable(false);
        setEquipped(false);
    }

    public Item(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION) {
        this.NAME = NAME;
        this.FUNCTION = FUNCTION;
        this.DESCRIPTION = DESCRIPTION;
        this.ROOM_DESCRIPTION = ROOM_DESCRIPTION;
        setEquippable(false);
        setEquipped(false);
    }

    public String getName() {
        return NAME;
    }

    public String getItemBrief(){
        return NAME + " : " + FUNCTION;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getROOM_DESCRIPTION() {
        return ROOM_DESCRIPTION;
    }

    public boolean isEquippable() {
        return isEquippable;
    }

    public void setEquippable(boolean equippable) {
        isEquippable = equippable;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean isEquipped){
        this.isEquipped = isEquipped;
    }

    public ReturnEquipMessage equip(){
        return ReturnEquipMessage.CANT_EQUIP;
    }

    public AttackDTO attack(){
        AttackDTO attackDTO = new AttackDTO(ReturnAttackMessage.CANT_ATTACK,0);
        return attackDTO;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public void useOnce(){
        setNumberOfUses(getNumberOfUses()-1);
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public String breakStatus() {
        return "";
    }


}
