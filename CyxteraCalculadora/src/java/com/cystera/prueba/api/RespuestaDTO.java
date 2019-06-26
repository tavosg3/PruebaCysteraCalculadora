/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cystera.prueba.api;

import java.io.Serializable;

/**
 *
 * @author tavos
 */
public class RespuestaDTO implements Serializable{
    
    private static final long serialVersionUID = 1;
    
    private Double resultado;

    private String mensaje;

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
     
}
