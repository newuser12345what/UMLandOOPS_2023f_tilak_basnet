package main.java.fr.epita.test;

import main.java.fr.epita.dao.MedicationsDao;
import main.java.fr.epita.dao.PatientsDao;
import main.java.fr.epita.dao.PrescriptionsDao;
import main.java.fr.epita.model.Prescriptions;

public class TestJDB3 {
    public static void main(String[] args) {
        MedicationsDao medicationsDao = new MedicationsDao();
        PrescriptionsDao prescriptions = new PrescriptionsDao();



        // Create the Medication data into the Database
        medicationsDao.createMedicationsDAO();
        // read the medication data form the database
        medicationsDao.readMedicationsDAO();

        // Create the prescriptions data in the database
        prescriptions.createPrescriptionsDAO();
        // read the prescription data from database
        prescriptions.readPrescriptionsDAO();



    }

}
