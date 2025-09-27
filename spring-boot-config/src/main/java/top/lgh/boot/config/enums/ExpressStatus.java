package enums;

public enum ExpressStatus {
    CREATE("已揽收"),
    TRANSIT("在途中"),
    SUCCESS("已签收");
    private final String label;
    ExpressStatus(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
