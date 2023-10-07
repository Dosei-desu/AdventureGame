package items;

public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, int numberOfUses, int damage) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION, numberOfUses, damage);
    }

    @Override
    public ReturnEquipMessage equip() {
        return ReturnEquipMessage.EQUIP_MELEE;
    }

    @Override
    public AttackDTO attack() {
        AttackDTO attackDTO;
        if (isEquipped()) {
            if (getNumberOfUses() > 0) {
                setNumberOfUses(getNumberOfUses() - 1);
                attackDTO = new AttackDTO(ReturnAttackMessage.MELEE_ATTACK, getDamage());
                return attackDTO;
            } else if (getNumberOfUses() == -1) {
                attackDTO = new AttackDTO(ReturnAttackMessage.MELEE_ATTACK, getDamage());
                return attackDTO;
            }
            attackDTO = new AttackDTO(ReturnAttackMessage.CANT_MELEE_ATTACK, getDamage());
            return attackDTO;
        }
        attackDTO = new AttackDTO(ReturnAttackMessage.CANT_ATTACK, getDamage());
        return attackDTO;
    }
}
