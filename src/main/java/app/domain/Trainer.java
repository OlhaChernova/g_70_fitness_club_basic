package app.domain;

import java.util.Objects;

public class Trainer {

    private Long id;
    private String name;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return isActive == trainer.isActive && Objects.equals(id, trainer.id) && Objects.equals(name, trainer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isActive);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + isActive +
                '}';
    }
}
