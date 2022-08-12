package model.vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DeudasPorProyectoVo {

    private ResultSet DeudasPorProyecto;
    int id;
    Double valor;

    String[] nombreColumnas = new String[]{
        "ID", "VALOR"
    };

    Class[] tipoColumnas = new Class[]{
        java.lang.Integer.class, java.lang.Double.class
    };
    
    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public Class[] getTipoColumnas() {
        return tipoColumnas;
    }
    
    

    public ResultSet getDeudasPorProyectoVo() {
        return DeudasPorProyecto;
    }

    public void setDeudasPorProyecto(ResultSet DeudasPorProyectoVo) {
        this.DeudasPorProyecto = DeudasPorProyectoVo;
    }

    public DeudasPorProyectoVo() {
        this.DeudasPorProyecto = null;
    }

    public DeudasPorProyectoVo(ResultSet DeudasPorProyectoVo) {
        this.DeudasPorProyecto = DeudasPorProyectoVo;
    }

    public void imprimirDatos() {
        String reg;
        try {
            while (DeudasPorProyecto.next()) {
                id = Integer.parseInt(DeudasPorProyecto.getString(1));
                valor = Double.valueOf(DeudasPorProyecto.getString(2));
                reg = String.format("%3d %,15.1f", id, valor);
                System.out.println(reg);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
    
    public Boolean Next(){
        try {
            return DeudasPorProyecto.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public List obtenerRegistroActual(){
        List<Object> registro = new ArrayList<>();
        try {
            id = (int) Double.parseDouble(DeudasPorProyecto.getString(1));
            valor = Double.valueOf(DeudasPorProyecto.getString(2));
            
            registro.add(id);
            registro.add(valor);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return registro;
    }
    

}
