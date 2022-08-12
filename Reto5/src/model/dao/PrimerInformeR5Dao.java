package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JDBCUtilities;

public class PrimerInformeR5Dao {

    public static ResultSet obtenerDatos() {
        try {
            JDBCUtilities jdbcu = new JDBCUtilities();
            Connection conexion = jdbcu.getConnection();
            String sqlreto35 = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia\n"
                    + "FROM Lider\n"
                    + "ORDER BY Ciudad_Residencia;";
            PreparedStatement ps = conexion.prepareStatement(sqlreto35);
            ResultSet rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            System.out.println("El error es " + e);
            ResultSet rs = null;
            return rs;
        }
    }

}
