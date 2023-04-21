package main.java.fr.epita.test;

import main.java.fr.epita.dao.PatientsDao;

public class TestJDB2 {
    public static void main(String[] args) {
        PatientsDao patientsDao = new PatientsDao();
        patientsDao.createPatientsDAO();
    }
}
