package items;

public class RangedWeapon extends Weapon {

    public RangedWeapon(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, int numberOfUses, int damage) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION, numberOfUses, damage);
    }

    @Override
    public ReturnEquipMessage equip() {
        return ReturnEquipMessage.EQUIP_RANGED;
    }

    @Override
    public AttackDTO attack() {
        AttackDTO attackDTO;
        if (isEquipped()) {
            if (getNumberOfUses() != 0) {
                attackDTO = new AttackDTO(ReturnAttackMessage.RANGED_ATTACK, getDamage());
                return attackDTO;
            }
            attackDTO = new AttackDTO(ReturnAttackMessage.CANT_RANGED_ATTACK, getDamage());
            return attackDTO;
        }
        attackDTO = new AttackDTO(ReturnAttackMessage.CANT_ATTACK, getDamage());
        return attackDTO;
    }

    @Override
    public String breakStatus() {
        return "(Empty)";
    }
}
