package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JDBCUtilities;

public class TercerInformeR5Dao {

    public static ResultSet obtenerDatos() {
        try {
            JDBCUtilities jdbcu = new JDBCUtilities();
            Connection conexion = jdbcu.getConnection();
            String sqlreto35 = "SELECT Compra.ID_Compra, Proyecto.Constructora, Proyecto.Banco_Vinculado \n"
                    + "FROM Proyecto INNER JOIN Compra ON  Proyecto.ID_Proyecto = Compra.ID_Proyecto\n"
                    + "WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento';";
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
