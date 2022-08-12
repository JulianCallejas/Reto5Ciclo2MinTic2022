package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JDBCUtilities;

public class SegundoInformeR5Dao {

    public static ResultSet obtenerDatos() {
        try {
            JDBCUtilities jdbcu = new JDBCUtilities();
            Connection conexion = jdbcu.getConnection();
            String sqlreto35 = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad\n"
                    + "FROM Proyecto\n"
                    + "WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla');";
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
