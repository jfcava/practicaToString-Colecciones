package entities;

import enums.Estado;
import enums.FormaPago;

import java.time.LocalDate;

public class Pedido extends Base{
    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;


}
