package conexao.professor;

import dao.ProfessorDao;
import model.Professor;

public class CadastrarProfessorMain {
    public static void main(String[] args) {
        var professor = new Professor();
        var professorDao = new ProfessorDao();

        professor.setNome("Marcos");
        professor.setFormacao("ADS");

        professorDao.cadastarProfessor(professor);
    }
}
