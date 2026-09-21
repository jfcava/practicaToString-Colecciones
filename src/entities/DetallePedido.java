package entities;

import java.util.Objects;

public class DetallePedido{
    private int cantidad;
    private double subtotal;
    private Producto producto;

    public DetallePedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = cantidad * producto.getPrecio();
    }

    public Producto getProducto(){
        return producto;
    }

    public double getSubtotal(){
        return subtotal;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                ", precioUnitario=" + producto.getPrecio() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o ) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePedido that = (DetallePedido) o;
        return Objects.equals(getProducto(), that.getProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getProducto());
    }
}
