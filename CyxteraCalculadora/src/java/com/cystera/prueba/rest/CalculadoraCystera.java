/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cystera.prueba.rest;

import com.cystera.prueba.ejb.CalculadoraCysteraBean;
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
        
        return Response.status(Response.Status.OK).entity(cysteraBean.iniciarSesion()).build();
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
   
       return Response.status(Response.Status.OK).entity(cysteraBean.agregarOperando(operando, idSesion)).build();
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
   
       return Response.status(Response.Status.OK).entity(cysteraBean.calcular(operacion, idSesion)).build();
    }
    
    

}
