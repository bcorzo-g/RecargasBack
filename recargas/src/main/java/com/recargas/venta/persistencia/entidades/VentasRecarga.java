/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recargas.venta.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author benic
 */
@Entity
@Table(name = "ventas_recarga")
@NamedQueries({
    @NamedQuery(name = "VentasRecarga.findAll", query = "SELECT v FROM VentasRecarga v")})
public class VentasRecarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventas_recarga")
    private Integer idventasRecarga;
    @Basic(optional = false)
    @Column(name = "valor_recarga")
    private int valorRecarga;
    @JoinColumn(name = "operador_idoperador", referencedColumnName = "idoperador")
    @ManyToOne(optional = false)
    private Operador operadorIdoperador;
    @JoinColumn(name = "vendedor_idvendedor", referencedColumnName = "idvendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedorIdvendedor;

    public VentasRecarga() {
    }

    public VentasRecarga(Integer idventasRecarga) {
        this.idventasRecarga = idventasRecarga;
    }

    public VentasRecarga(Integer idventasRecarga, int valorRecarga) {
        this.idventasRecarga = idventasRecarga;
        this.valorRecarga = valorRecarga;
    }

    public Integer getIdventasRecarga() {
        return idventasRecarga;
    }

    public void setIdventasRecarga(Integer idventasRecarga) {
        this.idventasRecarga = idventasRecarga;
    }

    public int getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(int valorRecarga) {
        this.valorRecarga = valorRecarga;
    }

    public Operador getOperadorIdoperador() {
        return operadorIdoperador;
    }

    public void setOperadorIdoperador(Operador operadorIdoperador) {
        this.operadorIdoperador = operadorIdoperador;
    }

    public Vendedor getVendedorIdvendedor() {
        return vendedorIdvendedor;
    }

    public void setVendedorIdvendedor(Vendedor vendedorIdvendedor) {
        this.vendedorIdvendedor = vendedorIdvendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventasRecarga != null ? idventasRecarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasRecarga)) {
            return false;
        }
        VentasRecarga other = (VentasRecarga) object;
        if ((this.idventasRecarga == null && other.idventasRecarga != null) || (this.idventasRecarga != null && !this.idventasRecarga.equals(other.idventasRecarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.recargas.venta.persistencia.entidades.VentasRecarga[ idventasRecarga=" + idventasRecarga + " ]";
    }
    
}
