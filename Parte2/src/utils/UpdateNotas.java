package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import entities.Aluno;
import entities.Bimester;
import entities.Subject;

public class UpdateNotas {
    
    public static void update(Aluno aluno, Subject subject, Bimester bimester, Timestamp now, Connection conn) {
        subject.loadCodigo(conn);
        String sqlUpdate = 
        "UPDATE                         "+ 
        "    notas                      "+
        "SET                            "+
        "    nota = ?,                  "+
        "    faltas = ?,                "+
        "    data_modificacao = ?       "+ 
        "WHERE                          "+
        "    id_materia = ?             "+
        "AND                            "+
        "    id_aluno = ?               "+
        "AND                            "+
        "    bimestre = ?;              "
        ;

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setDouble(1, bimester.getGrade());
            stm.setInt(2, bimester.getAbsence());
            stm.setTimestamp(3, now);
            stm.setInt(4, subject.getCodigo());
            stm.setInt(5, aluno.get_id());
            stm.setInt(6, bimester.getNumber());
            stm.executeUpdate();
            conn.commit();
        } catch(Exception ex) {
            try {
                conn.rollback();
            } catch(SQLException ex_sql) {
                System.out.println(ex_sql.getStackTrace());
            }
        }
    }

}
