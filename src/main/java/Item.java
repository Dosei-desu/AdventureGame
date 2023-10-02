public class Item {
    private final String NAME;
    private final String FUNCTION;
    private final String DESCRIPTION;
    private final String ROOM_DESCRIPTION;

    public Item(String NAME, String FUNCTION, String DESCRIPTION) {
        this.NAME = NAME;
        this.FUNCTION = FUNCTION;
        this.DESCRIPTION = DESCRIPTION;
        this.ROOM_DESCRIPTION = "";
    }

    public Item(String NAME, String FUNCTION, String DESCRIPTION, String ROOM_DESCRIPTION) {
        this.NAME = NAME;
        this.FUNCTION = FUNCTION;
        this.DESCRIPTION = DESCRIPTION;
        this.ROOM_DESCRIPTION = ROOM_DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    public String getFunction() {
        return FUNCTION;
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
}
