import entities.*;
import enums.FormaPago;
import enums.Rol;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Instancio 2 usuarios.
        Usuario u1 = new Usuario("Juan", "Cavallieri", "juancavallieri@gmail.com", "2235123456", "123456", Rol.ADMIN);
        Usuario u2 = new Usuario("Gaston", "Perez", "gastonperez@gmail.com", "2235987654", "qweasd", Rol.USUARIO);

        //Creo lista de productos.
        Set<Producto> listaProductos = new HashSet<>();
        //Instancio 10 productos.
        Producto prod1 = new Producto("Pizza Muzzarella", 4500.0, "Pizza clásica con salsa de tomate y muzzarella derretida", 20, "/images/pizza_muzza.jpg", true);
        Producto prod2 = new Producto("Pizza Napolitana", 5200.0, "Pizza con rodajas de tomate fresco, ajo y albahaca", 15, "/images/pizza_napo.jpg", true);
        Producto prod3 = new Producto("Pizza Especial 4 Quesos", 6800.0, "Muzzarella, provolone, roquefort y parmesano", 10, "/images/pizza_4quesos.jpg", true);
        Producto prod4 = new Producto("Hamburguesa Clásica", 3800.0, "Medallón de carne, lechuga, tomate, cebolla y mayo", 30, "/images/hamburguesa_clasica.jpg", true);
        Producto prod5 = new Producto("Hamburguesa BBQ Bacon", 5100.0, "Doble medallón, bacon crocante y salsa barbacoa ahumada", 25, "/images/hamburguesa_bacon.jpg", true);
        Producto prod6 = new Producto("Hamburguesa Veggie", 4200.0, "Medallón de lentejas y garbanzo, cheddar vegano y rúcula", 0, "/images/hamburguesa_veggie.jpg", false);
        Producto prod7 = new Producto("Coca-Cola 500ml", 1200.0, "Gaseosa Coca-Cola fría, botella personal", 100, "/images/coca.jpg", true);
        Producto prod8 = new Producto("Jugo de Naranja Natural", 1800.0, "Jugo exprimido en el momento, vaso 400ml", 40, "/images/jugo_naranja.jpg", true);
        Producto prod9 = new Producto("Agua Mineral 500ml", 800.0, "Agua mineral sin gas, botella personal", 150, "/images/agua.jpg", true);
        Producto prod10 = new Producto("Torta Rogel", 3500.0, "Torta rogel tradicional con dulce de leche y merengue", 12, "/images/rogel.jpg", true);

        //Agrego productos a la lista
        listaProductos.add(prod1);
        listaProductos.add(prod2);
        listaProductos.add(prod3);
        listaProductos.add(prod4);
        listaProductos.add(prod5);
        listaProductos.add(prod6);
        listaProductos.add(prod7);
        listaProductos.add(prod8);
        listaProductos.add(prod9);
        listaProductos.add(prod10);

        //Instancio 3 categorias y asigno productos
        Categoria pizzas = new Categoria("Pizzas", "Pizzas artesanales con masa fresca");
        pizzas.addProducto(prod1);
        pizzas.addProducto(prod2);
        pizzas.addProducto(prod3);

        Categoria hamburguesas = new Categoria("Hamburguesas", "Hamburguesas gourmet con ingredientes frescos");
        hamburguesas.addProducto(prod4);
        hamburguesas.addProducto(prod5);
        hamburguesas.addProducto(prod6);

        Categoria bebidas = new Categoria("Bebidas", "Gaseosas, jugos y bebidas frías");
        bebidas.addProducto(prod7);
        bebidas.addProducto(prod8);
        bebidas.addProducto(prod9);

        //Instancio 3 pedidos.
        Pedido p1 = new Pedido(LocalDate.now(), FormaPago.TARJETA);
        Pedido p2 = new Pedido(LocalDate.now(), FormaPago.TRANSFERENCIA);
        Pedido p3 = new Pedido(LocalDate.now(), FormaPago.EFECTIVO);

        //Asigno 2 detalles a cada pedido
        p1.addDetallePedido(1, prod1);
        p1.addDetallePedido(2, prod4);

        p2.addDetallePedido(1, prod7);
        p2.addDetallePedido(1, prod5);

        p3.addDetallePedido(1, prod10);
        p3.addDetallePedido(1, prod8);

        //Asocio pedidos a usuarios
        u1.addPedido(p1);
        u1.addPedido(p2);
        u2.addPedido(p3);

        //Mostramos resultados por consola
        //Un producto
        System.out.println("### Producto individual: ");
        System.out.println(prod1.toString());

        //Listado de productos cargados
        System.out.println("\n### Listado de productos cargados: ");
        for (Producto prod : listaProductos){
            System.out.println(prod.toString());
        }

        //Pedidos del usuario que mas pedidos posee
        System.out.println("\n### Pedidos del usuario que mas pedidos posee: ");
        Usuario usuarioConMasPedidos = (u1.getCantidadPedidos() > u2.getCantidadPedidos()) ? u1 : u2;
        System.out.println("\nUsuario: " + usuarioConMasPedidos.getNombreCompleto());
        System.out.println("Cantidad de Pedidos: " + usuarioConMasPedidos.getCantidadPedidos());
        System.out.println("Pedidos:");
        for (Pedido pedido : usuarioConMasPedidos.getPedidos()){
            System.out.println(pedido.toString());
        }

        //Instancio producto con campo nombre igual al prod1
        Producto productoCopia = new Producto("Pizza Muzzarella", 10000.0, "Otra muzzarella", 10, "img/pizzita.jpg", true);

        System.out.println("\n### Comparacion de productos: ");

        for (Producto producto : listaProductos){
            if(productoCopia.equals(producto)){
                System.out.println("El producto ya existe en la coleccion.");
                System.out.println("\nTiene el mismo nombre que el producto: " + producto.toString());
            }
        }
    }
}
