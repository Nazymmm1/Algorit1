package Lab3;

import java.util.Objects;
public class MyTestingClass {
    private String name;
    private int id;

    public MyTestingClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Custom hashCode method
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "MyTestingClass{name='" + name + "', id=" + id + "}";
    }
}