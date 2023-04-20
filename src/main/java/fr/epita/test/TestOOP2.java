package main.java.fr.epita.test;

import main.java.fr.epita.service.InsuranceReader;
import main.java.fr.epita.service.PatientsReader;

public class TestOOP2 {
    public static void main(String[] args) {
        System.out.println("List of the Patients: ");

        PatientsReader patientsReader = new PatientsReader();
        patientsReader.patientReader();
        for (String st: patientsReader.stringList)
            System.out.println(st);

        System.out.println("----------------------------****************************----------------------------****************************----------------------------****************************----------------------------");
        System.out.println("List of the Insurance: ");

        InsuranceReader insuranceReader = new InsuranceReader();
        insuranceReader.insuranceReader();
        for(String i : insuranceReader.list)
            System.out.println(i);
    }
}
