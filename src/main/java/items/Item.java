package items;

public class Item {
    //'Protected' means that it cannot be used outside the class, but can be used by subclasses and package methods
    //to make this work, such that these variables are not accessible where they shouldn't be
    protected final String NAME;
    protected final String FUNCTION;
    protected final String DESCRIPTION;
    protected final String ROOM_DESCRIPTION;

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
