package com.back.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.back.dto.DetalleViewdb;


@RestController
@RequestMapping("/api/vista")
public class Bodegacontroller {
    
     
    @PersistenceContext
    private EntityManager entityManager;
    

    @GetMapping(value ="/listarVista",produces="application/json")
    public List<DetalleViewdb> listarVista(){
        List<Object[]> result = (List<Object[]>)entityManager.createNativeQuery("SELECT *FROM detalleViewdb ").getResultList();
        DetalleViewdb data=new DetalleViewdb();
        List<DetalleViewdb> datos=new ArrayList<DetalleViewdb>();
        for(Object[] object: result) {
            data.setId(String.valueOf(object[0]));
            data.setIdDetalle((Integer) object[1]);
            data.setCodigo(String.valueOf(object[2]));
            data.setNombre(String.valueOf(object[3]));
            data.setCostoBruto ((Double)object[4]);
            data.setObservacion(String.valueOf(object[5]));
            data.setCostoNeto((Double)object[6]);
            data.setPrecioDescri(String.valueOf(object[7]));
            data.setIdPrecio((Integer) object[8]);
            data.setPrecioBruto((Double)object[9]);
            data.setPrecioNeto((Double)object[10]);
            data.setEquivalencia((Double)object[11]);
            data.setDescuento(String.valueOf(object[12]));
            data.setSubsidio((Double)object[13]);
            data.setNumeroBodega((Integer) object[14]);
            data.setIdBodega((Integer) object[15]);
            data.setExistencias ((Double)object[16]);
            data.setId_us((Integer) object[17]);
            data.setTipo(String.valueOf(object[18]));
            data.setProposito(String.valueOf(object[19]));

            datos.add(data);

        }
        return datos;

    }


}

