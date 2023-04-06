package conexao.professor;

import dao.ProfessorDao;


public class DeletarProfessorId {
    public static void main(String[] args) {

        var professorDao = new ProfessorDao();

        professorDao.deletarProfessorId(1L);
    }
}
