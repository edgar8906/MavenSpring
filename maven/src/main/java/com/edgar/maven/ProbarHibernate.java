package com.edgar.maven;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProbarHibernate {

    public static void main(String[] args) {
        
        try{
        Session sesion=HibernateUtilidades.getSessionFactory().openSession();
        
        //PASO 1 EMPEZAR LA SESION
        sesion.getTransaction().begin();
        
        //PASO 2 HACER UNA OPERCION!!
        sesion.save(new Prueba(23, "edgar morales", 234000f));
        
        //sesion.update(new Prueba(23, "pedro", 400000f));
        
        /*
        //PARA PROBARLO
        
        Query q = sesion.createQuery("from Pueba");
            ArrayList<Prueba> usuarios = (ArrayList<Prueba>) q.list();
            for(Prueba pru:usuarios){
                System.out.println(pru);
            }
        */
        
        Criteria c = sesion.createCriteria(Prueba.class);
        ArrayList<Prueba> usuarios2 = (ArrayList<Prueba>) c.list();
            for(Prueba pru2:usuarios2){
                System.out.println(pru2);
            }
        
        //PASO 3 HACER COMMIT EN BASE DE DATOS
        
        sesion.getTransaction().commit();
        
        //CERRAR LA SESION, NO SE TE OLVIDE NUNC ESTEEE!!
        //NO OLVIDAR EL SESION.FLUSH PARA TRANSACCIONES MASIVAS(O PAGO DE NOMINA)        
        sesion.close();
        
        System.out.println("SE HA GUARDADO CON EXITO ESTE REGISTRO");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
