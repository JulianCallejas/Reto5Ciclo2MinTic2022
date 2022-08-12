
package model.generador;

import java.util.ArrayList;
import java.util.LinkedHashSet;


public class Tabla {
    private String nombreTabla;
    private ArrayList<String> listaCampos = new ArrayList<>();
    private ArrayList<Class> tipoCampos = new ArrayList<>();
    private String tablaRequerida;
    private String llave;

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }
            
    public Tabla(ArrayList<String> listaCampos, ArrayList<Class> tipoCampos, String tablaRequerida, String nombreTabla) {
        this.listaCampos = listaCampos;
        this.tipoCampos = tipoCampos;
        this.tablaRequerida = tablaRequerida;
        this.nombreTabla = nombreTabla;
    }
    
    public Tabla() {
        
    }
    
    

    public ArrayList<String> getListaCampos() {
        return listaCampos;
    }

    public void setListaCampos(ArrayList<String> listaCampos) {
        this.listaCampos = listaCampos;
    }

    public ArrayList<Class> getTipoCampos() {
        return tipoCampos;
    }

    public void setTipoCampos(ArrayList<Class> tipoCampos) {
        this.tipoCampos = tipoCampos;
    }

    public String getTablaRequerida() {
        return tablaRequerida;
    }

    public void setTablaRequerida(String tablaRequerida) {
        this.tablaRequerida = tablaRequerida;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getJoinSql(){
        String joinsql = String.format("%s ON %s.%s = %s.%s", this.nombreTabla,this.nombreTabla,this.llave,this.tablaRequerida,this.llave);
        return joinsql;
    }
    
    
    
    
}
