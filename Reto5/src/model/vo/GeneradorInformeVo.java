
package model.vo;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GeneradorInformeVo {
    
    private ArrayList<String> nombreColumnas = new ArrayList<>();
    private ArrayList<Class> tipoColumnas = new ArrayList<>();
    
    private ResultSet rs;

    public GeneradorInformeVo(ResultSet rs) {
        this.rs = rs;
    }
    
     public GeneradorInformeVo() {
        this.rs = null;
    }

    public void setNombreColumnas(ArrayList<String> nombreColumnas) {
        for (Integer iterador = 0;iterador<nombreColumnas.size();iterador++){
            Integer ipunto = nombreColumnas.get(iterador).indexOf(".");
            this.nombreColumnas.add(nombreColumnas.get(iterador).substring(ipunto+1));
        }
    }

    public void setTipoColumnas(ArrayList<Class> tipoColumnas) {
        this.tipoColumnas = tipoColumnas;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
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
        Integer numeroColumnas = this.nombreColumnas.size();
                
        try {
            for (Integer itera = 0; itera < numeroColumnas; itera++ ){
                Class tipo = tipoColumnas.get(itera);
                if (tipo == java.lang.Integer.class){
                    Integer reg = (int)Double.parseDouble(rs.getString(itera+1));
                    registro.add(reg);
                }else if (tipo == java.lang.Double.class){
                    Double reg = Double.parseDouble(rs.getString(itera+1));
                    registro.add(reg);
                }else if (tipo == java.time.LocalDate.class){
                    LocalDate reg = LocalDate.parse(rs.getString(itera+1));
                    registro.add(reg);
                }else{
                    String reg = rs.getString(itera+1);
                    registro.add(reg);
                }
            }
           
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return registro;

    }

    public ArrayList<String> getNombreColumnas() {
        return nombreColumnas;
    }

    public ArrayList<Class> getTipoColumnas() {
        return tipoColumnas;
    }
    
    
    
}
