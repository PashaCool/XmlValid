package domain;

public enum Origin {
    RU("ğó"), EU("ÅÑ"), UK("ÂÁ"), US("ÑØÀ"), AFR("Àôğ"), CH("Êèò"), JP("ßïí");

    private String name;

    public String getName() {
        return name;
    }

    private Origin(String name) {
        this.name = name;
    }
}
