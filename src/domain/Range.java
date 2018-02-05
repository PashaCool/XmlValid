package domain;

public class Range extends TTC{
    private Integer range;
    
    public Range() {
        super("Range");
    }
    
    public String getValue() {
        return String.valueOf(range);
    }
    
    public void setValue(String r) {
        range = Integer.parseInt(r);
    }
}
