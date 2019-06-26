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
public class IdSesionDTO implements Serializable{
    
    private static final long serialVersionUID = 1;
    private Integer idSesion;

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }
    
}
