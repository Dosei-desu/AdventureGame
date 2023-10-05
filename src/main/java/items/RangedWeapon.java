package items;

public class RangedWeapon extends Weapon{

    public RangedWeapon(String NAME, String FUNCTION, String DESCRIPTION, int numberOfUses) {
        super(NAME, FUNCTION, DESCRIPTION, numberOfUses);
    }

    public RangedWeapon(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, int numberOfUses) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION, numberOfUses);
    }

    @Override
    public ReturnEquipMessage equip(){
        return ReturnEquipMessage.EQUIP_RANGED;
    }

    @Override
    public ReturnAttackMessage attack() {
        if (isEquipped()) {
            if (getNumberOfUses() > 0) {
                setNumberOfUses(getNumberOfUses() - 1);
                return ReturnAttackMessage.RANGED_ATTACK;
            }
            return ReturnAttackMessage.CANT_RANGED_ATTACK;
        }
        return ReturnAttackMessage.CANT_ATTACK;
    }
}
