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

/**
 *
 * @author benic
 */
@Entity
@Table(name = "operador")
@NamedQueries({
    @NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o")})
public class Operador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoperador")
    private Integer idoperador;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadorIdoperador")
    private List<VentasRecarga> ventasRecargaList;

    public Operador() {
    }

    public Operador(Integer idoperador) {
        this.idoperador = idoperador;
    }

    public Operador(Integer idoperador, String nombre) {
        this.idoperador = idoperador;
        this.nombre = nombre;
    }

    public Integer getIdoperador() {
        return idoperador;
    }

    public void setIdoperador(Integer idoperador) {
        this.idoperador = idoperador;
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
        hash += (idoperador != null ? idoperador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.idoperador == null && other.idoperador != null) || (this.idoperador != null && !this.idoperador.equals(other.idoperador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.recargas.venta.persistencia.entidades.Operador[ idoperador=" + idoperador + " ]";
    }
    
}
