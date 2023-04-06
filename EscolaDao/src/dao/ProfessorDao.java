package dao;

import conexao.Factory;
import model.Aluno;
import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDao {
    private Connection conn;
    public ProfessorDao() {
        conn = Factory.getConnection();
    }
    public void cadastarProfessor(Professor professor) {
        String sql = "INSERT INTO professor(nome, formacao) VALUES (?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getFormacao());
            stmt.execute();
            System.out.println("Professor cadastrado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar cadastrar professor ", ex);
        }
    }

    public void alterarProfessor(Long id, Professor professor) {
        String sql = "UPDATE professor SET nome = ?, formacao = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getFormacao());
            stmt.setLong(3, id);
            stmt.execute();
            System.out.println("Professor modificado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar alterar professor ", ex);
        }
    }

    public void deletarProfessorId(Long Id) {
        String sql = "DELETE FROM professor WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, Id);
            stmt.execute();
            System.out.println("Professor deletado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar deletar professor ", ex);
        }
    }

    public Professor selecionarProfessorId(Long id) {
        String sql = "SELECT * FROM professor WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            var professor = new Professor();

            while (rs.next()) {
                professor.setId(rs.getLong("id"));
                professor.setNome(rs.getString("nome"));
                professor.setFormacao(rs.getString("formacao"));
            }
            return professor;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Professor> listarProfessores() {
        String sql = "SELECT * FROM professor";
        List<Professor> professores = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var professor = new Professor();
                professor.setId(rs.getLong("id"));
                professor.setNome(rs.getString("nome"));
                professor.setFormacao(rs.getString("formacao"));
                professores.add(professor);
            }
            return professores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
