package domain;

public abstract class Have extends TTC{
    private Boolean have;

    public Have(String h) {
        super(h);
    }

    public String getValue() {
        return String.valueOf(this.have);
    }

    public void setValue(String r) {
        this.have = Boolean.parseBoolean(r);
    }

}
