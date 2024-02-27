package com.practica01.Practica.service.impl;

import com.practica01.Practica.dao.ArbolDao;
import com.practica01.Practica.domain.Arbol;
import com.practica01.Practica.service.ArbolService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles() {
        var arboles = arbolDao.findAll();

        return arboles;
    }

    @Override
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }

    @Override
    public void guardarArbol(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    public void eliminarArbol(Arbol arbol) {
        arbolDao.delete(arbol);
    }

 
}
