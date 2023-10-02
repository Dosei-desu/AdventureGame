public class Food extends Item{
    private final int HEALTH_POINTS;
    public Food(String NAME, String FUNCTION, String DESCRIPTION, int HEALTH_POINTS) {
        super(NAME, FUNCTION, DESCRIPTION);
        this.HEALTH_POINTS = HEALTH_POINTS;
    }

    public Food(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, int HEALTH_POINTS) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION);
        this.HEALTH_POINTS = HEALTH_POINTS;
    }

    public int getFoodHealthPoints(){
        return HEALTH_POINTS;
    }
}
