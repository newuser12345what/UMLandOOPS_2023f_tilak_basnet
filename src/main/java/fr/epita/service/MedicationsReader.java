package main.java.fr.epita.service;

import main.java.fr.epita.model.Medications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicationsReader {
    public List<String> list = new ArrayList<>();
    public List<Medications> medicationsList = new ArrayList<>();

    public void medicationsReader() {
        Medications medications = new Medications();
        String csvFile = "/Users/bsnt/workspace/java_workspace/UMLandOOPS_2023f_tilak_basnet/src/main/java/resources/medications.csv";
        String line;
        int index = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            //medication_code;medication_name;medication_comment
            while((line=br.readLine()) != null){
                if(index == 0){
                    index++;
                    continue;
                }
                String[] word = line.split(";");
                for(int i=0; i< word.length; i++){
                    medications.setMedication_code(Integer.parseInt(word[0]));
                    medications.setMedication_name(word[1]);
                    medications.setMedication_name(word[2]);
                }
                medicationsList.add(new Medications(medications.getMedication_code(),medications.getMedication_name(),medications.getMedication_comment()));
                list.add(medications.toString());
                index++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
