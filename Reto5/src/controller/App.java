
package controller;

import java.sql.ResultSet;
import view.ReportesView;
import model.dao.*;
import model.vo.*;

import java.time.*;

public class App {
    public static void main(String[] args) {
//        var reportesView = new ReportesView();
//        reportesView.lideresQueMasGastan();
        
//        var reportesView = new ReportesView(); 
//        var limiteInferior = 50_000d;
//        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
        
//        var reportesView = new ReportesView();
//        var banco = "Conavi"; 
//        reportesView.proyectosFinanciadosPorBanco(banco);
        
        String fecha = "2021-03-07";
        LocalDate prueba = LocalDate.parse(fecha);
        System.out.println(prueba);
        System.out.println(prueba.getClass());
        Integer as = 1;
        System.out.println(as.getClass());
        
        String pru = "Compra.IDCompra";
        Integer ipunto = pru.indexOf(".");
        System.out.println(pru.substring(ipunto+1));
                
        



    }

  

    
}
