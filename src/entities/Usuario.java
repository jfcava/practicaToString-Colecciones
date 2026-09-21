package entities;

import enums.Rol;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasenia;
    private Rol rol;
    private Set<Pedido> pedidos;

    public Usuario(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.pedidos = new HashSet<>();
    }

    public void addPedido (Pedido pedido){
        this.pedidos.add(pedido);
    }

    public int getCantidadPedidos() {
        return pedidos.size();
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    public Set<Pedido> getPedidos(){
        return this.pedidos;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + getId() +
                ", nombre='" + getNombreCompleto() + '\'' +
                ", mail='" + mail + '\'' +
                ", rol=" + rol +
                ", pedidos=" + pedidos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o ) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(mail, usuario.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}
