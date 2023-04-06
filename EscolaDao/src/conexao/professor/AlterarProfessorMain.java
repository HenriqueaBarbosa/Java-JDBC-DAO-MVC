package conexao.professor;

import dao.ProfessorDao;
import model.Professor;

public class AlterarProfessorMain {
    public static void main(String[] args) {
        var professor = new Professor();
        var professorDao = new ProfessorDao();

        professor.setNome("Mateus");
        professor.setFormacao("Engenheiro de Software");

        professorDao.alterarProfessor(2L, professor);
    }
}
