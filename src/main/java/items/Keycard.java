package items;

public class Keycard extends Item{
    private final String ROOM_NAME;
    public Keycard(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_NAME) {
        super(NAME, FUNCTION, DESCRIPTION);
        this.ROOM_NAME = ROOM_NAME;
    }

    public Keycard(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION, String ROOM_NAME) {
        super(NAME, FUNCTION, DESCRIPTION, ROOM_DESCRIPTION);
        this.ROOM_NAME = ROOM_NAME;
    }

    public String getKeycardRoomName(){
        return ROOM_NAME;
    }
}
