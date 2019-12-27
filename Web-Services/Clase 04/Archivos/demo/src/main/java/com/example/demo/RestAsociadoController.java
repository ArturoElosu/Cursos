package com.example.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pep")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestAsociadoController {
	
/*	@GetMapping(value = "/responsablesPago" , produces = "application/json")
    public String getDatosResponsableCriteria (@QueryParam("tipo") String tipo,
    		@QueryParam("cuit") String cuit,
    		@QueryParam("descripcion") String descripcion,
    		@DefaultValue("ssss") @QueryParam("activo") String activo) throws IOException {
    	return new String("Se enviaron los query: cuit :" + cuit + " desc: " + descripcion + " activo:" + activo);
	}*/
 	
	@GetMapping(value = "/responsablesPago/{cuit}" , produces = "application/json")
    public String buscarResponsablePorCuit(@PathVariable("cuit") Long cuit) throws IOException {

		return new String("Se envio el valor : " + cuit);
    }
	
	@GetMapping(value = "/responsablesPago/{id}/detalle" , produces = "application/json")
    public String getDatosResponsablePorId (@PathVariable("id") Long id) throws IOException {
			   
	    return new String("Se envio el valor : " + id);
    }	
	
	@PostMapping(value = "/responsablePago" , produces = "application/json")
    public String crearResponsable (@RequestBody ReqId id) throws IOException {
			   
	    return new String("Se recibio por post el valor : " + id.getId());
    }
}

