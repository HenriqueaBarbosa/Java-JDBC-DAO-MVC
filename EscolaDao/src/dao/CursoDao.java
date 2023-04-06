package dao;

import conexao.Factory;
import model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDao {
    private Connection conn;

    public CursoDao () {
        conn = Factory.getConnection();
    }

    public void registarCurso(Curso curso) {
        String sql = "INSERT INTO curso(nome) VALUES (?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.execute();
            System.out.println("Curso registrado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar registrar curso ", ex);
        }
    }

    public void alterarCurso(Long id, Curso curso) {
        String sql = "UPDATE curso SET nome = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setLong(2, id);
            stmt.execute();
            System.out.println("Curso modificado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar modificar curso ", ex);
        }
    }

    public void deletarCurso(Long id) {
        String sql = "DELETE FROM curso WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            System.out.println("Curso deletado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar deletar curso ", ex);
        }
    }

    public Curso selecionarCursoId(Long id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            var curso = new Curso();

            while (rs.next()) {
                curso.setId(rs.getLong("id"));
                curso.setNome(rs.getString("nome"));
            }
            return curso;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Curso> listarCursos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var curso = new Curso();
                curso.setId(rs.getLong("id"));
                curso.setNome(rs.getString("nome"));
                cursos.add(curso);
            }
            return cursos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
