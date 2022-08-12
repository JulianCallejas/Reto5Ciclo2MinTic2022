
package model.generador;

import java.util.ArrayList;

public class GeneradorSQL {
    
    private ArrayList<String> listaCampos = new ArrayList<>();
    private ArrayList<Class> tipoCampos = new ArrayList<>();
    private ArrayList<Tabla> listaTablas = new ArrayList<>();
    private ArrayList<String> listaFiltros = new ArrayList<>();

    public GeneradorSQL() {
    
    }
    
    public GeneradorSQL(ArrayList<Tabla> listaTablas, ArrayList<String> listaCampos, ArrayList<Class> tipoCampos, ArrayList<String> listaFiltros) {
    
        this.listaCampos = listaCampos;
        this.listaFiltros = listaFiltros;
        this.listaTablas = listaTablas;
        this.tipoCampos = tipoCampos;
        
    }
    
    public String sqlCampos(){
        String sqlCampos = listaCampos.get(0);
        if (listaCampos.size() > 1){
            for(Integer ci = 1; ci < listaCampos.size();ci++){
                sqlCampos += ", " + listaCampos.get(ci);
            }
        }
        return sqlCampos;
    }
    
    public String sqlTablas(){
        String sqlTablas = "";
        Integer tpi = -1;
        Boolean estaproyecto = false;
        for(Tabla tbl : listaTablas){
            if (tbl.getNombreTabla() == "Proyecto"){
                estaproyecto = true;
                tpi = listaTablas.indexOf(tbl);
            }
        }
        
        if(estaproyecto){
            sqlTablas += listaTablas.get(tpi).getNombreTabla();
            for(Integer it = 0; it<listaTablas.size(); it++){
                sqlTablas += it != tpi ? " INNER JOIN " + listaTablas.get(it).getJoinSql() : "";
            }
        } else{
            sqlTablas += listaTablas.get(0).getNombreTabla();
            for(Integer it = 1; it<listaTablas.size(); it++){
                sqlTablas += it != tpi ? " INNER JOIN " + listaTablas.get(it).getJoinSql() : "";
            }
        }
        
        return sqlTablas;
        
    }
    
    public String sqlFiltros(){
        String sqlFiltros = "";
        if(listaFiltros.size()>0){
            sqlFiltros = "WHERE ";
            for(Integer fil = 0; fil < listaFiltros.size(); fil++){
                sqlFiltros += listaFiltros.get(fil) + " ";
            }
        }
        return sqlFiltros;
    }
    
    
    public String generarSQL(){
         
        String sql = String.format("SELECT %s \n"
                + "FROM %s \n"
                + "%s", sqlCampos(), sqlTablas(),sqlFiltros());
        
        return sql;
    }    

    public ArrayList<Class> getTipoCampos() {
        return tipoCampos;
    }

    public ArrayList<String> getListaCampos() {
        return listaCampos;
    }
    
    public Class[] getTipoCamposArray() {
        Class[] tipoCampos1 = new Class[listaCampos.size()];
        for(Integer iter = 0; iter < listaCampos.size();iter++){
            tipoCampos1[iter] = tipoCampos.get(iter);
        }
        return tipoCampos1;
    }
    
    public boolean[] getCanEdit(){
        boolean[] canEdit = new boolean[listaCampos.size()];
        for(Integer iter = 0; iter < listaCampos.size();iter++){
            canEdit[iter] = false;
        }
        return canEdit;
    }
    
}
