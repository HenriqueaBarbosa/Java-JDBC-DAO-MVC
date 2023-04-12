package dao;

import conexao.Factory;
import model.Aluno;
import model.Curso;
import model.Professor;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaDao {
    private Connection conn;

    public TurmaDao() {
        conn = Factory.getConnection();
    }

    public void inserirDadosTurma(Long numeroTurma , Long idCurso, Long idProfessor, Long idAluno) {
        String sql = "INSERT INTO turma(turma_turma, curso_id, professor_id, aluno_id) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, numeroTurma);
            stmt.setLong(2, idCurso);
            stmt.setLong(3, idProfessor);
            stmt.setLong(4, idAluno);
            stmt.execute();
            System.out.println("Dados inseridos na turma");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDao.class.getName())
                    .log(Level.SEVERE, "Erro ao tentar inserir dados na turma", ex);
        }
    }

    public List<Turma> listarDadosPorTurma(Long numeroTurma) {
        List<Turma> dadosTurma = new ArrayList<>();
        String sql = "SELECT t.turma_turma AS turma, c.nome AS nome_curso, "
                    +"p.nome AS nome_professor, a.nome AS nome_aluno FROM turma t "
                    +"INNER JOIN curso c ON t.curso_id = c.id "
                    +"INNER JOIN professor p ON t.professor_id = p.id "
                    +"INNER JOIN aluno a ON t.aluno_id = a.id "
                    +"WHERE t.turma_turma = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, numeroTurma);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                var turma = new Turma();
                var curso = new Curso();
                var professor = new Professor();
                var aluno = new Aluno();

                turma.setId(rs.getLong("turma"));
                curso.setNome(rs.getString("nome_curso"));
                turma.setCurso(curso);
                professor.setNome(rs.getString("nome_professor"));
                turma.setProfessor(professor);
                aluno.setNome(rs.getString("nome_aluno"));
                turma.setAluno(aluno);

                dadosTurma.add(turma);

            }
            return dadosTurma;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
