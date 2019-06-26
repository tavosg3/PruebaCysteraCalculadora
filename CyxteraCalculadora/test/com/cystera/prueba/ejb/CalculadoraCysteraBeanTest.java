/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cystera.prueba.ejb;

import com.cystera.prueba.api.IdSesionDTO;
import com.cystera.prueba.api.RespuestaDTO;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tavos
 */
public class CalculadoraCysteraBeanTest {
    
    public CalculadoraCysteraBeanTest() {
    }

    @Test
    public void testIniciarSesion() throws Exception {
        System.out.println("[CalculadoraCysteraBeanTest][iniciarSesion]");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CalculadoraCysteraBean instance = (CalculadoraCysteraBean)container.getContext().lookup("java:global/classes/CalculadoraCysteraBean");
        IdSesionDTO expResult = null;
        IdSesionDTO result = instance.iniciarSesion();
        assertEquals(expResult, result);
        container.close();
        fail("Error en la ejecucion de [CalculadoraCysteraBeanTest][iniciarSesion].");
    }

    @Test
    public void testAgregarOperando() throws Exception {
        System.out.println("[CalculadoraCysteraBeanTest][AgregarOperando]");
        double operando = 0.0;
        int idSesion = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CalculadoraCysteraBean instance = (CalculadoraCysteraBean)container.getContext().lookup("java:global/classes/CalculadoraCysteraBean");
        RespuestaDTO expResult = null;
        RespuestaDTO result = instance.agregarOperando(operando, idSesion);
        assertEquals(expResult, result);
        container.close();
        fail("Error en la ejecucion de [CalculadoraCysteraBeanTest][AgregarOperando].");
    }

    @Test
    public void testCalcular() throws Exception {
        System.out.println("[CalculadoraCysteraBeanTest][Calcular]");
        String operacion = "";
        int idSesion = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CalculadoraCysteraBean instance = (CalculadoraCysteraBean)container.getContext().lookup("java:global/classes/CalculadoraCysteraBean");
        RespuestaDTO expResult = null;
        RespuestaDTO result = instance.calcular(operacion, idSesion);
        assertEquals(expResult, result);
        container.close();
        fail("\"Error en la ejecucion de [CalculadoraCysteraBeanTest][AgregarOperando].");
    }
    
}
