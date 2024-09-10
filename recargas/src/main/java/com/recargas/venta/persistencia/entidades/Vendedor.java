/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recargas.venta.persistencia.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "vendedor")
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendedor")
    private Integer idvendedor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorIdvendedor")
    private List<VentasRecarga> ventasRecargaList;

    public Vendedor() {
    }

    public Vendedor(Integer idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Vendedor(Integer idvendedor, String nombre) {
        this.idvendedor = idvendedor;
        this.nombre = nombre;
    }

    public Integer getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Integer idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VentasRecarga> getVentasRecargaList() {
        return ventasRecargaList;
    }

    public void setVentasRecargaList(List<VentasRecarga> ventasRecargaList) {
        this.ventasRecargaList = ventasRecargaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvendedor != null ? idvendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idvendedor == null && other.idvendedor != null) || (this.idvendedor != null && !this.idvendedor.equals(other.idvendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.recargas.venta.persistencia.entidades.Vendedor[ idvendedor=" + idvendedor + " ]";
    }
    
}
