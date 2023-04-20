package main.java.fr.epita.test;

import main.java.fr.epita.service.PatientBLService;

import java.util.ArrayList;

public class TestBLI2 {
    public static void main(String[] args) {
        PatientBLService patientBLService = new PatientBLService();
        PatientBLService.computeSeniorityByPatient(new ArrayList<>());
    }
}
