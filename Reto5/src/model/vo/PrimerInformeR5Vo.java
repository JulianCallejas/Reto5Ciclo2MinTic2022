package model.vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrimerInformeR5Vo {

    private ResultSet rs;
    Integer ID_Lider;
    String Nombre;
    String Primer_Apellido;
    String Ciudad_Residencia;

    String[] nombreColumnas = new String[]{
        "ID_Lider", "Nombre", "Primer_Apellido", "Ciudad_Residencia"
    };

    Class[] tipoColumnas = new Class[]{
        java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
    };

    public ResultSet getRs() {
        return rs;
    }

    public Integer getID_Lider() {
        return ID_Lider;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public String getCiudad_Residencia() {
        return Ciudad_Residencia;
    }

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public Class[] getTipoColumnas() {
        return tipoColumnas;
    }

    public void setPrimerInformeR5Vo(ResultSet PrimerInformeR5Vo) {
        this.rs = PrimerInformeR5Vo;
    }

    public PrimerInformeR5Vo() {
        this.rs = null;
    }

    public PrimerInformeR5Vo(ResultSet PrimerInformeR5Vo) {
        this.rs = PrimerInformeR5Vo;
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
            ID_Lider = Integer.parseInt(rs.getString(1));
            Nombre = rs.getString(2);
            Primer_Apellido = rs.getString(3);
            Ciudad_Residencia = rs.getString(4);

            registro.add(ID_Lider);
            registro.add(Nombre);
            registro.add(Primer_Apellido);
            registro.add(Ciudad_Residencia);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return registro;

    }

}
