package common;

import items.Item;

public class EatDTO {
    private ReturnEatMessage returnEatMessage;
    private int foodHealValue;

    public EatDTO(ReturnEatMessage returnEatMessage, int foodHealValue) {
        this.returnEatMessage = returnEatMessage;
        this.foodHealValue = foodHealValue;
    }

    public ReturnEatMessage getReturnEatMessage() {
        return returnEatMessage;
    }

    public int getFoodHealValue() {
        return foodHealValue;
    }

    @Override
    public String toString() {
        return "EatDTO{" +
                "returnEatMessage=" + returnEatMessage +
                ", foodHealValue=" + foodHealValue +
                '}';
    }
}
