package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Aluno;

public class FetchTableData {
    
    public static Object[][] load(Connection conn, Aluno aluno) {
        
        ArrayList<Object[]> result = new ArrayList<Object[]>();

        String sqlLoad = 
        "SELECT                      " +
        "    materias.nome_materia,   " +
        "    notas.bimestre,          " +
        "    notas.nota,              " +
        "    notas.faltas,            " +
        "    notas.data_modificacao   " +
        "FROM                        " +
        "    notas                   " +
        "JOIN                        " +                         
        "    materias ON notas.id_materia = materias.id_materia " +
        "WHERE                       " +
        "    notas.id_aluno = ?      " +
        "ORDER BY                    " +
        "    materias.nome_materia ASC, " +
        "    notas.bimestre ASC; ";
    
        
        try (PreparedStatement stm = conn.prepareStatement(sqlLoad);) {
            stm.setInt(1, aluno.get_id());
            
            try (ResultSet rs = stm.executeQuery();) {
                while(rs.next()) {
                    Object[] aux = new Object[5];
                    aux[0] = rs.getString(1);
                    aux[1] = rs.getInt(2);
                    aux[2] = rs.getDouble(3);
                    aux[3] = rs.getInt(4);
                    aux[4] = rs.getTimestamp(5);
                    result.add(aux);
                    conn.commit();
                }
            } catch (Exception ex) {    
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        } 
        return result.toArray(new Object[0][]);

    }

}
