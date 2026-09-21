package entities;

import enums.Estado;
import enums.FormaPago;
import interfaces.Calculable;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;
    private Set<DetallePedido> detallesPedidos = new HashSet<>();

    public Pedido(LocalDate fecha, FormaPago formaPago) {
        super();
        this.fecha = fecha;
        this.estado = Estado.PENDIENTE;
        this.total = 0.0;
        this.formaPago = formaPago;
    }


    public void addDetallePedido(int cantidad, Producto producto){
        detallesPedidos.add(new DetallePedido(cantidad, producto));
        this.calcularTotal();
    }

    public void deleteDetallePedidoByProducto(Producto producto){
        DetallePedido detalleEncontrado = findDetallePedidoByProducto(producto);
        if(detalleEncontrado != null){
            this.detallesPedidos.remove(detalleEncontrado);
            this.calcularTotal();
        }
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto){
        if(producto == null){
            return null;
        }

        for (DetallePedido detalle : detallesPedidos){
            if(producto.equals(detalle.getProducto())){
                return detalle;
            }
        }
        return null;
    }

    @Override
    public void calcularTotal() {
        double suma = 0.0;
        if(this.detallesPedidos != null){
            for(DetallePedido detalle: detallesPedidos){
                if(detalle != null){
                    suma += detalle.getSubtotal();
                }
            }
        }
        this.total = suma;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formaPago=" + formaPago +
                ", cantidadItems=" + detallesPedidos.size() +
                ", detalles=" + detallesPedidos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
