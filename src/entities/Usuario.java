package entities;

import enums.Rol;

import java.util.Set;

public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasenia;
    private Rol rol;
    private Set<Pedido> pedidos;

}
