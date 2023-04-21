package main.java.fr.epita.service;

import main.java.fr.epita.model.Patients;

import java.util.*;

public class PatientBLService{
    static PatientsReader patientsReader = new PatientsReader();
    public static void computeSeniority(){ // method body
        patientsReader.patientReader();
        Comparator<Patients> comparator = Comparator.comparing(Patients::getPat_subscription_date);
        patientsReader.patientsList.sort(comparator.reversed());
        for (Patients patient : patientsReader.patientsList) {
            System.out.println(patient);
        }
    }

    public static void computeSeniorityByPatient(){
        patientsReader.patientReader();

        // Sort the patients list according to the subscription date
        patientsReader.patientsList.sort(new Comparator<Patients>() {
            public int compare(Patients o1, Patients o2) {
                return o1.getPat_subscription_date().compareTo(o2.getPat_subscription_date());
            }
        });

        for(Map.Entry<Date, List<Patients>> entry : patientsReader.computeSeniorityPatients.entrySet()){
            //Date date  = entry.getKey();
            List<Patients> patients = entry.getValue();
            System.out.println("{");

            for(Patients patients1: patients){
                System.out.println("    " +patients1.getPat_num_hc() + " = "+ patients1.getPat_insurance_id());
            }
            System.out.println("}");
        }
    }

}
