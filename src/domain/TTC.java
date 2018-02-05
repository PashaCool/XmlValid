package domain;

public abstract class TTC {
    private String name;
    private String element;

    public TTC(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String el) {
        element = el;
    }

    public abstract void setValue(String value);

    public abstract String getValue();

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public int hashCode() {
        int res = 0;
        for (int i = 0; i < name.length(); i++) {
            res += name.indexOf(i);
        }
        for (int j = 0; j < element.length(); j++) {
            res += element.indexOf(j);
        }
        return res * name.lastIndexOf(name.indexOf(0), name.indexOf(name.length() - 1));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TTC other = (TTC) obj;
        if (!name.equals(other.name))
            return false;
        if (!element.equals(other.element))
            return false;
        return true;
    }
}
