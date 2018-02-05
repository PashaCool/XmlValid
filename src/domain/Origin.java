package domain;

public enum Origin {
    RU("��"), EU("��"), UK("��"), US("���"), AFR("���"), CH("���"), JP("���");

    private String name;

    public String getName() {
        return name;
    }

    private Origin(String name) {
        this.name = name;
    }
}
