package model.vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComprasDeLiderVo {

    private ResultSet ComprasDeLider;
    String lider;
    Double valor;
    List<String> nombreColumnas = new ArrayList<>();
    Class[] tipoColumnas = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };

    public List<String> getNombreColumnas() {
        return nombreColumnas;
    }

    public Class[] getTipoColumnas() {
        return tipoColumnas;
    }
    

    public ComprasDeLiderVo() {
        this.ComprasDeLider = null;
        nombreColumnas.add("LIDER");
        nombreColumnas.add("VALOR");
                
    }

    public ComprasDeLiderVo(ResultSet ComprasDeLider) {
        this.ComprasDeLider = ComprasDeLider;
    }

    public ResultSet getComprasDeLider() {
        return ComprasDeLider;
    }

    public void setComprasDeLider(ResultSet ComprasDeLider) {
        this.ComprasDeLider = ComprasDeLider;
    }

    public void imprimirDatos() {
        String reg;
        try {
            while (ComprasDeLider.next()) {
                lider = ComprasDeLider.getString(1);
                valor = Double.valueOf(ComprasDeLider.getString(2));
                reg = String.format("%-25s %,15.1f", lider, valor);
                System.out.println(reg);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }
    
    public Boolean Next(){
        try {
            return ComprasDeLider.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public List obtenerRegistroActual(){
        List<Object> registro = new ArrayList<>();
        try {
            lider = ComprasDeLider.getString(1);
            valor = Double.valueOf(ComprasDeLider.getString(2));
            registro.add(lider);
            registro.add(valor);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return registro;
        
    }
    

}
