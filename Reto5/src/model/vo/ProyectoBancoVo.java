package model.vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProyectoBancoVo {

    private ResultSet ProyectoBanco;
    Integer id;
    String constructora;
    String ciudad;
    String clasificacion;
    Integer estrato;
    String lider;

    String[] nombreColumnas = new String[]{
        "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"
    };

    Class[] tipoColumnas = new Class[]{
        java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
    };

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public Class[] getTipoColumnas() {
        return tipoColumnas;
    }

    public ResultSet getProyectoBanco() {
        return ProyectoBanco;
    }

    public ProyectoBancoVo() {
        this.ProyectoBanco = null;
    }

    public ProyectoBancoVo(ResultSet ProyectoBanco) {
        this.ProyectoBanco = ProyectoBanco;
    }

    public void setProyectoBanco(ResultSet ProyectoBanco) {
        this.ProyectoBanco = ProyectoBanco;
    }

    public void imprimirDatos() {
        String reg;
        try {
            while (ProyectoBanco.next()) {
                id = Integer.parseInt(ProyectoBanco.getString(1));
                constructora = ProyectoBanco.getString(2);
                ciudad = ProyectoBanco.getString(3);
                clasificacion = ProyectoBanco.getString(4);
                estrato = Integer.parseInt(ProyectoBanco.getString(5));
                lider = ProyectoBanco.getString(6);
                reg = String.format("%3d %-25s %-20s %-15s %7d %-30s", id, constructora, ciudad, clasificacion, estrato, lider);
                System.out.println(reg);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public Boolean Next() {
        try {
            return ProyectoBanco.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public List obtenerRegistroActual() {
        List<Object> registro = new ArrayList<>();
        try {
            id = (int) Double.parseDouble(ProyectoBanco.getString(1));
            constructora = ProyectoBanco.getString(2);
            ciudad = ProyectoBanco.getString(3);
            clasificacion = ProyectoBanco.getString(4);
            estrato = (int) Double.parseDouble(ProyectoBanco.getString(5));
            lider = ProyectoBanco.getString(6);

            registro.add(id);
            registro.add(constructora);
            registro.add(ciudad);
            registro.add(clasificacion);
            registro.add(estrato);
            registro.add(lider);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return registro;
    }

}
