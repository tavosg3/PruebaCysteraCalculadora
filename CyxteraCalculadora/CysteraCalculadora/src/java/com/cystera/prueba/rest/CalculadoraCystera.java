/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cystera.prueba.rest;

import com.cystera.prueba.api.dto.IdSesionDTO;
import com.cystera.prueba.api.dto.RespuestaDTO;
import com.cystera.prueba.ejb.CalculadoraCysteraBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author tavos
 */
@Path("/calculadoraCystera")
public class CalculadoraCystera {
    
    @EJB
    private CalculadoraCysteraBean cysteraBean;
    
    /**
     * 
     * @return 
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/nuevaSesion")
    public Response nuevaSesion(){
        try {
            Logger.getLogger(CalculadoraCystera.class.getName()).log(Level.INFO, "[CalculadoraCystera][nuevaSesion]");
            return Response.status(Response.Status.OK).entity(cysteraBean.iniciarSesion()).build();
        } catch (Exception ex) {
            Logger.getLogger(CalculadoraCystera.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.SEE_OTHER).entity(new RespuestaDTO(null,"Error creando Sesion")).build();
        }
        
    }
    
    /**
     * 
     * @param operando
     * @param idSesion
     * @return 
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/agregarOperando")
    public Response agregarOperando(@QueryParam("operando") double operando, @QueryParam("idSesion") int idSesion){
   
        try {
            Logger.getLogger(CalculadoraCystera.class.getName()).log(Level.INFO, "{0}[CalculadoraCystera][agregarOperando] operando {1} idSesion {2}", new Object[]{idSesion, operando, idSesion});
            return Response.status(Response.Status.OK).entity(cysteraBean.agregarOperando(operando, idSesion)).build();
        } catch (Exception ex) {
            Logger.getLogger(CalculadoraCystera.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.SEE_OTHER).entity(new RespuestaDTO(null,"Error obteniendo Sesion " + idSesion)).build();
        }
    }
    
    /**
     * 
     * @param operacion
     * @param idSesion
     * @return 
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/calcular")
    public Response calcular(@QueryParam("operacion") String operacion, @QueryParam("idSesion") int idSesion){
   
        try {
            Logger.getLogger(CalculadoraCystera.class.getName()).log(Level.INFO, "[CalculadoraCystera][calcular] operando {1} idSesion {2}", new Object[]{idSesion, operacion, idSesion});
            return Response.status(Response.Status.OK).entity(cysteraBean.calcular(operacion, idSesion)).build();
        } catch (Exception ex) {
            Logger.getLogger(CalculadoraCystera.class.getName()).log(Level.SEVERE, null, ex);            
            return Response.status(Response.Status.SEE_OTHER).entity(new RespuestaDTO(null,ex.getMessage())).build();
        }
    }
    
    

}
