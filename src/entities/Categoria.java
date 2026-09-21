package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base{
    private String nombre;
    private String descripcion;
    private Set<Producto> productos = new HashSet<>();

    public Categoria(String nombre, String descripcion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void addProducto (Producto producto){
        this.productos.add(producto);
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadProductos=" + productos.size() +
                '}';
    }
}
