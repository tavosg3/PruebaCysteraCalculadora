/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cystera.prueba.ejb;

import com.cystera.prueba.api.IdSesionDTO;
import com.cystera.prueba.api.RespuestaDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author tavos
 */
@Stateless
public class CalculadoraCysteraBean {
    
    private int idSesion;
    
    private Map<Integer, List<Double>> sesiones = new HashMap<>();
    
    private IdSesionDTO idSesionDTO;
    private RespuestaDTO respuestaDTO;

    /**
     * 
     * @return 
     */
    public IdSesionDTO iniciarSesion(){
                
        idSesionDTO = new IdSesionDTO();
        idSesionDTO.setIdSesion(idSesion++);
        sesiones.put(idSesion, new ArrayList<>());
        return idSesionDTO;
    }
    
    /**
     * 
     * @param operando
     * @param idSesion
     * @return 
     */
    public RespuestaDTO agregarOperando(double operando, int idSesion){
    
        List<Double> operandos;
        operandos = sesiones.get(idSesion);
        for (Double operando1 : operandos) {
            System.out.println("");
        }
        operandos.add(operando);
        sesiones.put(idSesion, operandos);
        respuestaDTO = new RespuestaDTO();
        respuestaDTO.setMensaje("Ok");
        
        return respuestaDTO;
    }
    
    /**
     * 
     * @param operacion
     * @param idSession
     * @return 
     */
    public RespuestaDTO calcular(String operacion, int idSession ) {

        double resultado = 0;
        String operacionM = operacion.toUpperCase();
        List<Double> operandos = sesiones.get(idSession);
       
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
                        //throw new CyxteraException(ExceptionNumberEnum.ERROR_DIVISION_CERO.getCode());
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
                }
                
                
                break;

            default:
                    resultado = -1.0;
                break;

        }
        respuestaDTO = new RespuestaDTO();
        respuestaDTO.setMensaje("Ok");
        respuestaDTO.setResultado(resultado);
        return respuestaDTO;
    }
  
}