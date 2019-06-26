/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cystera.prueba.ejb;

import com.cystera.prueba.api.dto.IdSesionDTO;
import com.cystera.prueba.api.dto.RespuestaDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;


/**
 *
 * @author tavos
 */
@Stateless
public class CalculadoraCysteraBean {
    
   // private static Logger  logger = LoggerFactory.getLogger(CalculadoraCysteraBean.class.getName());
    
    private int idSesion = 1;
    
    private Map<Integer, List<Double>> sesiones = new HashMap<>();
    
    private IdSesionDTO idSesionDTO;
    private RespuestaDTO respuestaDTO;
    
    /**
     * 
     * @return 
     * @throws java.lang.Exception 
     */
    public IdSesionDTO iniciarSesion() throws Exception{
        Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.INFO, "[CalculadoraCysteraBean][iniciarSesion]");         
        idSesionDTO = new IdSesionDTO();
        idSesionDTO.setIdSesion(idSesion);
        sesiones.put(idSesion, new ArrayList<>());
        idSesion++;
        Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.INFO, "[CalculadoraCysteraBean][iniciarSesion] {0}", idSesion);   
        return idSesionDTO;
    }
    
    /**
     * 
     * @param operando
     * @param idSesion
     * @return 
     * @throws java.lang.Exception 
     */
    public RespuestaDTO agregarOperando(double operando, int idSesion) throws Exception{
    
      
        Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.INFO, "[CalculadoraCysteraBean][agregarOperando] operando {0} idSesion {1}", new Object[]{operando, idSesion});         
        List<Double> operandos;
        
        if (sesiones.get(idSesion) != null){
            operandos = sesiones.get(idSesion);
        
            operandos.add(operando);
            sesiones.put(idSesion, operandos);
            respuestaDTO = new RespuestaDTO();
            respuestaDTO.setMensaje("Ok");
            Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.INFO, "[CalculadoraCysteraBean][agregarOperando] Ok ");         
       
        }
        else{
            Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.SEVERE, "Error obteniendo Sesion" );             
            respuestaDTO = new RespuestaDTO();
            respuestaDTO.setMensaje("Error obteniendo Sesion " + idSesion);
            throw new Exception("Error obteniendo Sesion");
        }
        return respuestaDTO;
    }
    
    /**
     * 
     * @param operacion
     * @param idSesion
     * @return 
     * @throws java.lang.Exception 
     */
    public RespuestaDTO calcular(String operacion, int idSesion) throws Exception {

        Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.INFO, "[CalculadoraCysteraBean][calcular] operacion {0} idSesion {1}", new Object[]{operacion, idSesion});
        double resultado = 0;
        String operacionM = operacion.toUpperCase();

        List<Double> operandos = sesiones.get(idSesion);
        
        if(operandos == null || operandos.size() < 2){
            throw new Exception("Operandos Insuficiente");
        }
        if (sesiones.get(idSesion) != null) {
            switch (operacionM) {
                case "SUMA":
                    for (double num : operandos) {
                        resultado += num;
                    }
                    break;
                case "RESTA":
                    resultado = operandos.get(0);
                    for (int num = 1; num < operandos.size(); num++) {
                        resultado -= operandos.get(num);
                    }
                    break;
                case "MULT":
                    resultado = operandos.get(0);
                    for (int num = 1; num < operandos.size(); num++) {
                        resultado *= operandos.get(num);
                    }
                    break;
                case "DIVIS":
                    resultado = operandos.get(0);
                    for (int num = 1; num < operandos.size(); num++) {
                        double divisor = operandos.get(num);
                        if (divisor == 0) {
                            throw new Exception("Division por cero (0)");
                        }
                        resultado /= divisor;
                    }
                    break;
                case "POTEN":
                    resultado = operandos.get(0);
                    if (operandos.size() == 2) {
                        for (int num = 1; num < operandos.size(); num++) {
                            resultado = Math.pow(resultado, operandos.get(num));
                        }
                    } else {
                        throw new Exception("La operacion de Potencia permite solo dos (2) valores");
                    }
                    break;

                default:
                    throw new Exception("Operacion No Encontrada");

            }
            respuestaDTO = new RespuestaDTO();
            respuestaDTO.setMensaje("Ok");
            respuestaDTO.setResultado(resultado);
            Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.INFO, "[CalculadoraCysteraBean][calcular] Ok ");
        } else {
            Logger.getLogger(CalculadoraCysteraBean.class.getName()).log(Level.SEVERE, "Error obteniendo Sesion");
            respuestaDTO = new RespuestaDTO();
            respuestaDTO.setMensaje("Error obteniendo Sesion " + idSesion);
            throw new Exception("Error obteniendo Sesion" + idSesion);
        }

        return respuestaDTO;
    }
    
}