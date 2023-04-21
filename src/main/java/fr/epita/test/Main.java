package main.java.fr.epita.test;

import main.java.fr.epita.model.Patients;
import main.java.fr.epita.service.PatientsReader;

public class Main {
    public static void main(String[] args) {


        PatientsReader patientsReader = new PatientsReader();
        patientsReader.patientReader();

        for (Patients patients : patientsReader.patientsList) {

            System.out.println(patients.getPat_num_hc());
        }


    }
}