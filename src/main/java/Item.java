public class Item {
    private final String NAME;
    private final String FUNCTION;
    private final String DESCRIPTION;

    public Item(String NAME, String FUNCTION, String DESCRIPTION) {
        this.NAME = NAME;
        this.FUNCTION = FUNCTION;
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    public String getFunction() {
        return FUNCTION;
    }

    public String getItemBrief(){
        String string = NAME + " : " + FUNCTION;
        return string;
    }

    public String getDescription() {
        return DESCRIPTION;
    }
}
