package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Subject {

    private int codigo;
    private String nome;

    public Subject(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Subject(int codigo){
        this.codigo = codigo;
    }

    public Subject(String nome) {
        this.nome = nome;
    }

    public void loadCodigo(Connection conn) {
        String sqlLoad =
        "       SELECT                  "+
        "            id_materia         "+       
        "       FROM                    "+
        "            materias           "+
        "       WHERE                   "+
        "           nome_materia = ?    ";

        try (PreparedStatement stm = conn.prepareStatement(sqlLoad);) {
            stm.setString(1, this.getNome());
            
            try (ResultSet rs = stm.executeQuery();) {
                if(rs.next()) {
                    this.setCodigo(rs.getInt(1));
                    conn.commit();
                }
            } catch (Exception ex) {    
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        } 

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

}
