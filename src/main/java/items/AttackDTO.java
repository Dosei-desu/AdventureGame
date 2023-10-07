package items;

public class AttackDTO {
    private ReturnAttackMessage returnAttackMessage;
    private int damage;

    public AttackDTO(ReturnAttackMessage returnAttackMessage, int damage) {
        this.returnAttackMessage = returnAttackMessage;
        this.damage = damage;
    }

    public ReturnAttackMessage getReturnAttackMessage() {
        return returnAttackMessage;
    }

    public int getDamage() {
        return damage;
    }
}
