package main.java.fr.epita.service;

import main.java.fr.epita.model.Patients;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PatientsReader {
    public List<String> stringList = new ArrayList<>();
    public Map<Date, List<Patients>> computeSeniorityPatients = new TreeMap<>();
    public List<Patients> patientsList = new ArrayList<>();
    public void patientReader() {
        Patients patients = new Patients();
        String csvFile = "/Users/bsnt/workspace/java_workspace/UMLandOOPS_2023f_tilak_basnet/src/main/java/resources/patients.csv";
        String line = "";
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Skip the first line to read of csvFile
                if (index == 0) {
                    index++;
                    continue;
                }
                String[] words = line.split(";");
                for (int i = 0; i < words.length; i++) {

                    //pat_num_HC; pat_lastname; pat_firstname; pat_address; pat_tel; pat_insurance_id; pat_subscription_date
                    // set the data to tha patients class instances
                    patients.setPat_num_hc(words[0]);
                    patients.setPat_lastname(words[1]);
                    patients.setPat_firstname(words[2]);
                    patients.setPat_address(words[3]);
                    patients.setPat_tel(words[4]);
                    patients.setPat_insurance_id(Integer.valueOf(words[5]));

                    String dateString = words[6];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = dateFormat.parse(dateString);

                    patients.setPat_subscription_date(date);

                }

                patientsList.add(
                        new  Patients(patients.getPat_num_hc(),
                                patients.getPat_lastname(),
                                patients.getPat_firstname(),
                                patients.getPat_address(),
                                patients.getPat_tel(),
                                patients.getPat_insurance_id(),
                                patients.getPat_subscription_date())
                );


                stringList.add(patients.toString());
                index++;
            }
            computeSeniorityPatients.put(patients.getPat_subscription_date(),patientsList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}