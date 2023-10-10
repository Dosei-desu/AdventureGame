package items;

public class EquipDTO {
    private Item item;
    private ReturnEquipMessage returnEquipMessage;

    public EquipDTO(ReturnEquipMessage returnEquipMessage, Item item) {
        this.item = item;
        this.returnEquipMessage = returnEquipMessage;
    }

    public Item getItem() {
        return item;
    }

    public ReturnEquipMessage getReturnEquipMessage() {
        return returnEquipMessage;
    }
}
