package com.recargas.venta.servicio;

import com.recargas.venta.negocio.ProcesoVentas;
import com.recargas.venta.persistencia.entidades.VentasRecarga;
import com.recargas.venta.servicio.objetosconsulta.OperadorConsulta;
import com.recargas.venta.servicio.objetosconsulta.VendedorConsulta;
import com.recargas.venta.servicio.objetosconsulta.VentasRecargaConsulta;
import com.recargas.venta.servicio.objetosDTO.VentasTotalesDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/ventas")
public class VentasRecargas {

    @Autowired
    private ProcesoVentas pv;
    
@RequestMapping(value="/vervendedores",method=RequestMethod.GET)
public ResponseEntity<List<VendedorConsulta>> verVendedores() {
    
    List<VendedorConsulta> respuesta = pv.traerVendedores();

        return new ResponseEntity(respuesta, HttpStatus.OK);
}
    
@RequestMapping(value="/veroperadores",method=RequestMethod.GET)
public ResponseEntity<List<OperadorConsulta>> verOperadores() {
    
    List<OperadorConsulta> respuesta = pv.traerOperadores();

        return new ResponseEntity(respuesta, HttpStatus.OK);
}
    
@RequestMapping(value="/verventas",method=RequestMethod.GET)
public ResponseEntity<List<VentasRecargaConsulta>> verVentas() {
    
    List<VentasRecargaConsulta> respuesta = pv.traerVentasRecarga();

        return new ResponseEntity(respuesta, HttpStatus.OK);
}
    
@RequestMapping(value = "/ventastotaloperador", method = RequestMethod.GET)
    public ResponseEntity<List<VentasTotalesDTO>> listarVentasOperador() {

        List<VentasTotalesDTO> respuesta = pv.traerVentasRecargaOperador();

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

@RequestMapping(value = "/ventastotalvendedor", method = RequestMethod.GET)
    public ResponseEntity<List<VentasTotalesDTO>> listarVentasVendedor() {

        List<VentasTotalesDTO> respuesta = pv.traerVentasRecargaVendedor();

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

@RequestMapping(value = "/crearventa", method = RequestMethod.POST)

    //recibo como parametro los datos de la nueva venta
    public ResponseEntity<VentasRecargaConsulta> GuardarVenta(@RequestBody VentasRecarga nueva) {

        VentasRecargaConsulta vr = pv.guardarVenta(nueva);

        //retorno la venta con los datos registrados
        return new ResponseEntity(vr, HttpStatus.OK);
    }

}
