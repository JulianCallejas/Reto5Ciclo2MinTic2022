package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JDBCUtilities;

public class ProyectoBancoDao {

    public static ResultSet obtenerDatos(String banco) {
        try {
            JDBCUtilities jdbcu = new JDBCUtilities();
            Connection conexion = jdbcu.getConnection();
            String sqlreto32 = String.format("SELECT 	Proyecto.ID_PROYECTO as ID,\n"
                    + "		Proyecto.Constructora,\n"
                    + "		Proyecto.Ciudad,\n"
                    + "		Proyecto.Clasificacion,\n"
                    + "		Tipo.Estrato,\n"
                    + "		Lider.Nombre || ' ' || Lider.Primer_Apellido || ' ' || Lider.Segundo_Apellido as LIDER\n"
                    + "FROM 	Proyecto INNER JOIN Lider ON Proyecto.ID_Lider = Lider.ID_Lider \n"
                    + "				 INNER JOIN Tipo ON Proyecto.ID_Tipo = Tipo.ID_Tipo\n"
                    + "WHERE Proyecto.Banco_Vinculado LIKE \"%s\"\n"
                    + "ORDER BY Proyecto.Fecha_Inicio DESC, Proyecto.Ciudad, Proyecto.Constructora\n"
                    + ";", banco);
            PreparedStatement ps = conexion.prepareStatement(sqlreto32);
            ResultSet rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            System.out.println("El error es " + e);
            ResultSet rs = null;
            return rs;
        }
    }

}
