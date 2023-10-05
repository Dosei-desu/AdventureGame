package items;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String NAME, String FUNCTION, String DESCRIPTION, int numberOfUses) {
        super(NAME, FUNCTION, DESCRIPTION, numberOfUses);
    }

    public MeleeWeapon(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, int numberOfUses) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION, numberOfUses);
    }

    @Override
    public ReturnEquipMessage equip(){
        return ReturnEquipMessage.EQUIP_MELEE;
    }

    @Override
    public ReturnAttackMessage attack() {
        //maybe the player takes damage when attacking with a melee weapon
        if(isEquipped()) {
            if (getNumberOfUses() > 0) {
                setNumberOfUses(getNumberOfUses() - 1);
                return ReturnAttackMessage.MELEE_ATTACK;
            }
            return ReturnAttackMessage.CANT_MELEE_ATTACK;
        }
        return ReturnAttackMessage.CANT_ATTACK;
    }
}
