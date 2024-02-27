/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.Practica.controller;

import com.practica01.Practica.domain.Arbol;
import com.practica01.Practica.service.ArbolService;
import com.practica01.Practica.service.FirebaseStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author brand
 */
@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/arboles")
    public String listarArboles(Model model) {
        var arboles = arbolService.getArboles();
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "/arbol/listado";
    }

        @Autowired
    private FirebaseStorageService firebaseStorageService;
    @PostMapping("/guardarArbol")
    public String guardarArbol(Arbol arbol,@RequestParam("imagenFile")MultipartFile imagenFile) {
        
       if(!imagenFile.isEmpty()){
            arbolService.guardarArbol(arbol);
            String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, 
                    "categoria", arbol.getIdArbol());
            arbol.setRutaImagen(rutaImagen);
        }
        arbolService.guardarArbol(arbol);
        return "redirect:/arbol/arboles";
    }
    
    
     @GetMapping("/modifica/{idArbol}")
    public String modifica(Arbol arbol, Model model){
        arbol=arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return"/arbol/modifica";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String eliminarArbol(Arbol arbol) {
        arbolService.eliminarArbol(arbol);
        return "redirect:/arbol/arboles";
    }



}
