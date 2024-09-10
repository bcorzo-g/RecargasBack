package com.recargas.venta.servicio.objetosconsulta;

public class VentasRecargaConsulta {

private Integer idventas_recarga;
private Integer valor_recarga;
private Integer operador_idoperador;
private Integer vendedor_idvendedor;
private String nombreoperador;
private String nombrevendedor;

    public Integer getIdventas_recarga() {
        return idventas_recarga;
    }

    public void setIdventas_recarga(Integer idventas_recarga) {
        this.idventas_recarga = idventas_recarga;
    }

    public Integer getValor_recarga() {
        return valor_recarga;
    }

    public void setValor_recarga(Integer valor_recarga) {
        this.valor_recarga = valor_recarga;
    }

    public Integer getOperador_idoperador() {
        return operador_idoperador;
    }

    public void setOperador_idoperador(Integer operador_idoperador) {
        this.operador_idoperador = operador_idoperador;
    }

    public Integer getVendedor_idvendedor() {
        return vendedor_idvendedor;
    }

    public void setVendedor_idvendedor(Integer vendedor_idvendedor) {
        this.vendedor_idvendedor = vendedor_idvendedor;
    }

    public String getNombreoperador() {
        return nombreoperador;
    }

    public void setNombreoperador(String nombreoperador) {
        this.nombreoperador = nombreoperador;
    }

    public String getNombrevendedor() {
        return nombrevendedor;
    }

    public void setNombrevendedor(String nombrevendedor) {
        this.nombrevendedor = nombrevendedor;
    }

}
