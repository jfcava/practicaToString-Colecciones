package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Base {
    private static Long contador = 1L;

    private long id;
    private boolean eliminado;
    private LocalDateTime createdAt;

    public Base (){
        this.id = contador++;
        this.eliminado = false;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", eliminado=" + eliminado +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return getId() == base.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
