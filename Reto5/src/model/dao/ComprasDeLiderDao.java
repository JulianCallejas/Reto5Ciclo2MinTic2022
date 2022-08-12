package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JDBCUtilities;

public class ComprasDeLiderDao {

    public static ResultSet obtenerDatos() {
        try {
            JDBCUtilities jdbcu = new JDBCUtilities();
            Connection conexion = jdbcu.getConnection();
            String sqlreto35 = "SELECT 	Lider.Nombre || ' ' || Lider.Primer_Apellido || ' ' || Lider.Segundo_Apellido as LIDER,\n"
                    + "		sum(Compra.Cantidad * MaterialConstruccion.Precio_Unidad) as VALOR\n"
                    + "FROM Compra INNER JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion \n"
                    + "			INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto\n"
                    + "			INNER JOIN Lider ON Proyecto.ID_Lider = Lider.ID_Lider\n"
                    + "GROUP BY Lider\n"
                    + "ORDER BY VALOR DESC\n"
                    + "LIMIT 10\n"
                    + ";";
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
