
package controller;
import java.util.ArrayList;
import model.dao.*;
import model.vo.*;


public class ReportesController {
    private static Double limiteinferior;
    private static String banco;

    public void setLimiteinferior(Double limiteinferior) {
        this.limiteinferior = limiteinferior;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }


    public ReportesController() {
        limiteinferior = null;
        banco = null;
    }
    
    public ReportesController(Double limiteinferior) {
        this.limiteinferior = limiteinferior;
        this.banco = null;
    }
    
    public ReportesController(String banco) {
        this.limiteinferior = null;
        this.banco = banco;
    }
    
    
    public static ComprasDeLiderVo ComprasDeLider(){
        ComprasDeLiderVo informe = new ComprasDeLiderVo();
        informe.setComprasDeLider(ComprasDeLiderDao.obtenerDatos());
        return informe;
        
    }
        
        
    public static DeudasPorProyectoVo DeudasPorProyecto(){
        DeudasPorProyectoVo informe = new DeudasPorProyectoVo();
        informe.setDeudasPorProyecto(DeudasPorProyectoDao.obtenerDatos(limiteinferior));
        return informe;
        
    }
    
    public static DeudasPorProyectoVo DeudasPorProyecto(Double limiteinferior){
        DeudasPorProyectoVo informe = new DeudasPorProyectoVo();
        informe.setDeudasPorProyecto(DeudasPorProyectoDao.obtenerDatos(limiteinferior));
        return informe;
        
    }
    
    public static ProyectoBancoVo ProyectoBanco(){
        ProyectoBancoVo informe = new ProyectoBancoVo();
        informe.setProyectoBanco(ProyectoBancoDao.obtenerDatos(banco));
        return informe;
        
    }
    
    public static ProyectoBancoVo ProyectoBanco(String banco){
        ProyectoBancoVo informe = new ProyectoBancoVo();
        informe.setProyectoBanco(ProyectoBancoDao.obtenerDatos(banco));
        return informe;
        
    }
    
    public static PrimerInformeR5Vo PrimerInformeR5(){
        PrimerInformeR5Vo informe = new PrimerInformeR5Vo();
        informe.setPrimerInformeR5Vo(PrimerInformeR5Dao.obtenerDatos());
        return informe;
        
    }
    
    public static SegundoInformeR5Vo SegundoInformeR5(){
        SegundoInformeR5Vo informe = new SegundoInformeR5Vo();
        informe.setRs(SegundoInformeR5Dao.obtenerDatos());
        return informe;
        
    }
    
    
     public static TercerInformeR5Vo TercerInformeR5(){
        TercerInformeR5Vo informe = new TercerInformeR5Vo();
        informe.setRs(TercerInformeR5Dao.obtenerDatos());
        return informe;
    }
     
     public static GeneradorInformeVo generarInforme(String sql, ArrayList<String> nombreColumnas, ArrayList<Class> tipoColumnas){
         GeneradorInformeVo informe = new GeneradorInformeVo();
         informe.setRs(GeneradorInformeDao.obtenerDatos(sql));
         informe.setNombreColumnas(nombreColumnas);
         informe.setTipoColumnas(tipoColumnas);
         return informe;
     }
    
}
