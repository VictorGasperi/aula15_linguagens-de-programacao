package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Aluno {

    private int _id;
    private String _name;
    private String _pass;

    public Aluno(String name, String pass) {
        this._name = name;
        this._pass = pass;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_pass() {
        return _pass;
    }

    public void set_pass(String _pass) {
        this._pass = _pass;
    }

    public void inserir(Connection conn) {

        String sqlInsert = "INSERT INTO alunos(id_aluno, nome, senha) values (null, ?, ?)";

        try(PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, this.get_name());
            stm.setString(2, this.get_pass());
            stm.execute();
            conn.commit();
        } catch(Exception ex) {
            try {
                conn.rollback();
            } catch(SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

    }

    public void carregar(Connection conn) {
        String sqlLoad = "SELECT * FROM alunos WHERE nome = ? AND senha = ?";

        try (PreparedStatement stm = conn.prepareStatement(sqlLoad);) {
            stm.setString(1, this.get_name());
            stm.setString(2, this.get_pass());
            try (ResultSet rs = stm.executeQuery();) {
                if(rs.next()) {
                    this.set_id(rs.getInt(1));
                } 
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        } catch (SQLException sql_ex) {
            System.out.println(sql_ex.getStackTrace());
        }
    
    }

}
