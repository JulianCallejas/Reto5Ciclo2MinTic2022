package model.vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TercerInformeR5Vo {

    private ResultSet rs;

    
    Integer ID_Compra;
    String Constructora;
    String Banco_Vinculado;

    String[] nombreColumnas = new String[]{
        "ID_Compra", "Constructora", "Banco_Vinculado"
    };

    Class[] tipoColumnas = new Class[]{
        java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
    };

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    
    public ResultSet getRs() {
        return rs;
    }

    public Integer getID_Compra() {
        return ID_Compra;
    }

    public String getConstructora() {
        return Constructora;
    }

    public String getBanco_Vinculado() {
        return Banco_Vinculado;
    }

  

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public Class[] getTipoColumnas() {
        return tipoColumnas;
    }

    

    public TercerInformeR5Vo() {
        this.rs = null;
    }

    public TercerInformeR5Vo(ResultSet SegundoInformeR5Vo) {
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
            
            ID_Compra = (int) Double.parseDouble(rs.getString(1));
            Constructora = rs.getString(2);
            Banco_Vinculado = rs.getString(3);

            registro.add(ID_Compra);
            registro.add(Constructora);
            registro.add(Banco_Vinculado);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            
        }

        return registro;

    }

}
