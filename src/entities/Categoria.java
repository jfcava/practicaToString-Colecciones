package entities;

import java.util.Set;

public class Categoria extends Base{
    private String nombre;
    private String descripcion;
    private Set<Producto> productos;
}
