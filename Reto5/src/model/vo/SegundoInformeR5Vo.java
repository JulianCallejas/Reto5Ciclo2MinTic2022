package model.vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SegundoInformeR5Vo {

    private ResultSet rs;
       
    Integer ID_Proyecto;
    String Constructora;
    Integer Numero_Habitaciones;
    String Ciudad;

    String[] nombreColumnas = new String[]{
        "ID_Proyecto", "Constructora", "Numero_Habitaciones", "Ciudad"
    };

    Class[] tipoColumnas = new Class[]{
        java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
    };

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    
    
    public ResultSet getRs() {
        return rs;
    }

    public Integer getID_Proyecto() {
        return ID_Proyecto;
    }

    public String getConstructora() {
        return Constructora;
    }

    public Integer getNumero_Habitaciones() {
        return Numero_Habitaciones;
    }

    public String getCiudad() {
        return Ciudad;
    }

   

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public Class[] getTipoColumnas() {
        return tipoColumnas;
    }

    

    public SegundoInformeR5Vo() {
        this.rs = null;
    }

    public SegundoInformeR5Vo(ResultSet SegundoInformeR5Vo) {
        this.rs = SegundoInformeR5Vo;
    }

    public void imprimirDatos() {

    }

    public Boolean Next() {
        try {
            return rs.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public List obtenerRegistroActual() {
        List<Object> registro = new ArrayList<>();
        try {
           
            ID_Proyecto = Integer.parseInt(rs.getString(1));
            Constructora = rs.getString(2);
            Numero_Habitaciones = (int) Double.parseDouble(rs.getString(3));
            Ciudad = rs.getString(4);

            registro.add(ID_Proyecto);
            registro.add(Constructora);
            registro.add(Numero_Habitaciones);
            registro.add(Ciudad);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            
        }

        return registro;

    }

}
