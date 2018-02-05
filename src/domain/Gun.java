package domain;

import java.util.ArrayList;
import java.util.List;

public class Gun {
    private String id;
    private String model;
    private Integer handy;
    private String origin;
    private List<TTC> tCharecter = new ArrayList<TTC>();
    private Material material;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHandy() {
        return handy;
    }

    public void setHandy(String handy) {
        this.handy = Integer.parseInt(handy);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<TTC> getTTCList() {
        return tCharecter;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material mat) {
        material = mat;
    }

    @Override
    public String toString() {
        StringBuilder buld = new StringBuilder();
        buld.append("Gun id: ").append(getId()).append('\n');
        buld.append("Model: ").append(getModel()).append('\n');
        buld.append("For hands: ").append(getHandy()).append('\n');
        buld.append("Origin region: ").append(getOrigin()).append('\n');
        buld.append("Characters of gun: ").append('\n');
        for(TTC ttc : getTTCList()) {
            buld.append('\t').append(ttc.getName()).append(": ").append(ttc.getValue()).append('\n');
        }
        buld.append("Material: ").append(getMaterial()).append('\n');
        return buld.toString();
    }
}
