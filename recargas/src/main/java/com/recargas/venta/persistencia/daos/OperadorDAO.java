package com.recargas.venta.persistencia.daos;

import com.recargas.venta.persistencia.entidades.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorDAO extends JpaRepository<Operador, Integer>{
    
}
