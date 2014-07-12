package com.edgar.maven;

import org.hibernate.Session;

public class ProbarHibernate {

    public static void main(String[] args) {
        
        try{
        Session sesion=HibernateUtilidades.getSessionFactory().openSession();
        
        //PASO 1 EMPEZAR LA SESION
        sesion.getTransaction().begin();
        
        //PASO 2 HACER UNA OPERCION!!
        sesion.save(new Prueba(23, "edgar morales", 234000f));
        
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
