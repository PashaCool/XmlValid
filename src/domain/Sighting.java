package domain;

public class Sighting extends TTC {
    private Integer sigh_range;

    public Sighting() {
        super("Sighting range");
    }

    public String getValue() {
        return String.valueOf(sigh_range);
    }

    public void setValue(String r) {
        sigh_range = Integer.parseInt(r);
    }

}
