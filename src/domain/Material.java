package domain;

public enum Material {
    stal,
    plastik,
    splav;
    
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
