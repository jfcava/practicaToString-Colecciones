package entities;

public class Producto extends Base{
    private String nombre;
    private double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;

    public Producto(String nombre, double precio, String descripcion, int stock, String imagen, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
    }
}
