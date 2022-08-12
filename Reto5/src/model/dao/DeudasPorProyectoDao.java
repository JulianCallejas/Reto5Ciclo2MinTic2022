package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JDBCUtilities;

public class DeudasPorProyectoDao {

    public static ResultSet obtenerDatos(Double limiteInferior) {
        try {
            JDBCUtilities jdbcu = new JDBCUtilities();
            Connection conexion = jdbcu.getConnection();
            String sqlreto34 = String.format("SELECT 	Compra.ID_Proyecto,\n"
                    + "		sum(Compra.Cantidad * MaterialConstruccion.Precio_Unidad) as VALOR\n"
                    + "FROM Compra JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion\n"
                    + "GROUP BY Compra.ID_Proyecto, Compra.Pagado\n"
                    + "HAVING Compra.Pagado = \"No\" AND VALOR>%.0f\n"
                    + "ORDER BY VALOR DESC\n"
                    + ";", limiteInferior);
            PreparedStatement ps = conexion.prepareStatement(sqlreto34);
            ResultSet rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            System.out.println("El error es " + e);
            ResultSet rs = null;
            return rs;
        }
    }

}
