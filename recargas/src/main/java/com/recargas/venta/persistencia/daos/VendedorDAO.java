package com.recargas.venta.persistencia.daos;

import com.recargas.venta.persistencia.entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorDAO extends JpaRepository<Vendedor, Integer>{
    
}
