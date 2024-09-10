package com.recargas.venta.negocio;

import com.recargas.venta.persistencia.daos.OperadorDAO;
import com.recargas.venta.persistencia.daos.VendedorDAO;
import com.recargas.venta.persistencia.daos.VentasRecargaDAO;
import com.recargas.venta.persistencia.entidades.Operador;
import com.recargas.venta.persistencia.entidades.Vendedor;
import com.recargas.venta.persistencia.entidades.VentasRecarga;
import com.recargas.venta.servicio.objetosconsulta.OperadorConsulta;
import com.recargas.venta.servicio.objetosconsulta.VendedorConsulta;
import com.recargas.venta.servicio.objetosconsulta.VentasRecargaConsulta;
import com.recargas.venta.servicio.objetosDTO.VentasTotalesDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcesoVentas {

    @Autowired
    private VendedorDAO vDAO;
    
    @Autowired
    private OperadorDAO oDAO;
    
    @Autowired
    private VentasRecargaDAO vrDAO;
    
    public List<VendedorConsulta> traerVendedores() {
        List<VendedorConsulta> respuesta = new ArrayList();
//        respuesta=null;

        List<Vendedor> entidades = vDAO.findAll();
        for (Vendedor v : entidades) {
            VendedorConsulta rvendedor = new VendedorConsulta();
            rvendedor.setIdvendedor(v.getIdvendedor());
            rvendedor.setNombre(v.getNombre());
            
            respuesta.add( rvendedor);
        }
        return respuesta;
    }
    
    public List<OperadorConsulta> traerOperadores() {
        
        List<OperadorConsulta> respuesta = new ArrayList();
//        respuesta=null;
        List<Operador> entidades = oDAO.findAll();
        for (Operador o : entidades) {
            OperadorConsulta roperador = new OperadorConsulta();
            roperador.setIdoperador(o.getIdoperador());
            roperador.setNombre(o.getNombre());
            
            respuesta.add( roperador);
        }
        return respuesta;
    }

public List<VentasTotalesDTO> traerVentasRecargaOperador() {
        
    List<VentasTotalesDTO> totalesoperador = new ArrayList();
    List<VentasRecarga> ventasoperador = new ArrayList();

        List<Operador> entidades = oDAO.findAll();
        
        for (Operador o : entidades) {

            ventasoperador  = null;
            ventasoperador  = o.getVentasRecargaList();
            
            // Recorrer la lista VentasRecarga
            
            int valor = 0;
            int cuenta = 0;
            for (VentasRecarga venta : ventasoperador) {
                
                valor += venta.getValorRecarga();
                cuenta += 1;

            }
            VentasTotalesDTO ventaDTO = new VentasTotalesDTO();
            ventaDTO.setNombre(o.getNombre());
            ventaDTO.setVentas(cuenta);
            ventaDTO.setValor(valor);
            
            totalesoperador.add(ventaDTO);
            
            }
        
        return totalesoperador;
        
    }
    
    public List<VentasRecargaConsulta> traerVentasRecarga() {
        List<VentasRecargaConsulta> respuesta = new ArrayList();

        List<VentasRecarga> entidades = vrDAO.findAll();
        for (VentasRecarga vr : entidades) {
            VentasRecargaConsulta rventasrecarga = new VentasRecargaConsulta();
            rventasrecarga.setIdventas_recarga(vr.getIdventasRecarga());
            rventasrecarga.setValor_recarga(vr.getValorRecarga());
            rventasrecarga.setOperador_idoperador(vr.getOperadorIdoperador().getIdoperador());
            rventasrecarga.setVendedor_idvendedor(vr.getVendedorIdvendedor().getIdvendedor());
            rventasrecarga.setNombreoperador(vr.getOperadorIdoperador().getNombre());
            rventasrecarga.setNombrevendedor(vr.getVendedorIdvendedor().getNombre());
            
            respuesta.add( rventasrecarga);
        }
        return respuesta;
    }
    

public List<VentasTotalesDTO> traerVentasRecargaVendedor() {
        
    List<VentasTotalesDTO> totalesvendedor = new ArrayList();
    List<VentasRecarga> ventasvendedor = new ArrayList();

        List<Vendedor> entidades = vDAO.findAll();
        
        for (Vendedor v : entidades) {

            ventasvendedor  = null;
            ventasvendedor  = v.getVentasRecargaList();
            
            // Recorrer la lista VentasRecarga
            
            int valor = 0;
            int cuenta = 0;
            for (VentasRecarga venta : ventasvendedor) {
                
                valor += venta.getValorRecarga();
                cuenta += 1;

            }
            VentasTotalesDTO ventaDTO = new VentasTotalesDTO();
            ventaDTO.setNombre(v.getNombre());
            ventaDTO.setVentas(cuenta);
            ventaDTO.setValor(valor);
            
            totalesvendedor.add(ventaDTO);
            
            }
        
        return totalesvendedor;
        
    }    

    public VentasRecargaConsulta guardarVenta(VentasRecarga nueva) {

        VentasRecarga venta = new VentasRecarga();
        VentasRecargaConsulta vtarta = new VentasRecargaConsulta();
        
        venta.setOperadorIdoperador(nueva.getOperadorIdoperador());
        venta.setVendedorIdvendedor(nueva.getVendedorIdvendedor());
        venta.setValorRecarga(nueva.getValorRecarga());

        //guardo la entidad VentasRecarga a bd y recibo el resultado
        venta = vrDAO.save(venta);

        //si venta es diferente de null, guardó bien y entonces le pongo a la nueva VentasRecarga el id con el que se registró
        //para retornar el objeto y si no retorno, con id 0 para indicar que no se registró con exito
        if (venta != null) {
            nueva.setIdventasRecarga(venta.getIdventasRecarga());
        } else {
            nueva.setIdventasRecarga(0);
        }
        
            vtarta.setIdventas_recarga(nueva.getIdventasRecarga());
            vtarta.setValor_recarga(nueva.getValorRecarga());
            vtarta.setOperador_idoperador(nueva.getOperadorIdoperador().getIdoperador());
            vtarta.setVendedor_idvendedor(nueva.getVendedorIdvendedor().getIdvendedor());
            vtarta.setNombreoperador(nueva.getOperadorIdoperador().getNombre());
            vtarta.setNombrevendedor(nueva.getVendedorIdvendedor().getNombre());
        
        return vtarta;

    }
    
}
