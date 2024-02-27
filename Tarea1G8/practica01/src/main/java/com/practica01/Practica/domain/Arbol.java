/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.Practica.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author brand
 */
@Data
@Entity
@Table(name = "arbol")

public class Arbol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;
    private String rutaImagen;
    private String nombre;
    private String tipoFlor;
    private String durezaMadera;

    public Arbol() {
    }

    public Arbol(String rutaImagen, String nombre, String tipoFlor, String durezaMadera) {
        this.rutaImagen = rutaImagen;
        this.nombre = nombre;
        this.tipoFlor = tipoFlor;
        this.durezaMadera = durezaMadera;
    }
}
