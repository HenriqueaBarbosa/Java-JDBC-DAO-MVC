package dao;

import conexao.Factory;
import model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao {
    private Connection conn;
    public AlunoDao() {
        conn = Factory.getConnection();
    }

    public void matricularAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome, idade, endereco) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,aluno.getNome());
            stmt.setInt(2,aluno.getIdade());
            stmt.setString(3,aluno.getEndereco());
            stmt.execute();
            System.out.println("Aluno matriculado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar matricular aluno ", ex);
        }
    }

    public void alterarAluno(Long id, Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, idade = ?, endereco = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEndereco());
            stmt.setLong(4, id);
            stmt.execute();
            System.out.println("Aluno modificado!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar alterar aluno ", ex);
        }
    }

    public void deletarAluno(Long id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            System.out.println("Aluno deletado");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar deletar aluno ", ex);
        }
    }

    public Aluno selecionarAlunoId(Long id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            var aluno = new Aluno();

            while (rs.next()) {
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setId(rs.getLong("id"));
            }
            return aluno;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar selecionar aluno por id ",ex);
        }
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                var aluno = new Aluno();
                aluno.setId(rs.getLong("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEndereco(rs.getString("endereco"));
                alunos.add(aluno);
            }

            return alunos;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar listar alunos ",ex);
        }
    }
}
