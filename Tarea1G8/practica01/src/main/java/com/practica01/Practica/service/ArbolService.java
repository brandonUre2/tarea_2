/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica01.Practica.service;

import com.practica01.Practica.domain.Arbol;
import java.util.List;

/**
 *
 * @author brand
 */
public interface ArbolService {
        
    public List<Arbol> getArboles();
    
    public Arbol getArbol(Arbol arbol);
    
    public void guardarArbol(Arbol arbol);
    
    public void eliminarArbol(Arbol arbol);
}
    

