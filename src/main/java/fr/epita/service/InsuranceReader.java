package main.java.fr.epita.service;

import main.java.fr.epita.model.Insurances;
import main.java.fr.epita.model.Patients;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InsuranceReader {

    public List<String> list = new ArrayList<>();
    public List<Insurances> insurancesList = new ArrayList<>();

    public void insuranceReader() {
        Insurances insurances = new Insurances();
        String csvFile = "/Users/bsnt/workspace/java_workspace/UMLandOOPS_2023f_tilak_basnet/src/main/java/resources/insurances.csv";
        String line;
        int index = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            while((line=br.readLine()) != null){
                if(index == 0){
                    index++;
                    continue;
                }
                String[] word = line.split(";");
                for(int i=0; i< word.length; i++){
                    insurances.setInsurance_id(Integer.parseInt(word[0]));
                    insurances.setInsurance_name(word[1]);
                }
                insurancesList.add(new Insurances(insurances.getInsurance_id(),insurances.getInsurance_name()));
                list.add(insurances.toString());
                index++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

