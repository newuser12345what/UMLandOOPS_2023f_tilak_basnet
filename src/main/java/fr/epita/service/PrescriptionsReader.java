package main.java.fr.epita.service;

import main.java.fr.epita.model.Insurances;
import main.java.fr.epita.model.Prescriptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionsReader {

    public List<String> list = new ArrayList<>();
    public List<Prescriptions> prescriptionsList = new ArrayList<>();

    //presc_id;presc_ref_pat;presc_code;presc_days
    public void prescriptionsReader() {
        Prescriptions prescriptions = new Prescriptions();
        String csvFile = "/Users/bsnt/workspace/java_workspace/UMLandOOPS_2023f_tilak_basnet/src/main/java/resources/prescriptions.csv";
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
                    prescriptions.setPresc_id(Integer.parseInt(word[0]));
                    prescriptions.setPresc_ref_pat(word[1]);
                    prescriptions.setPresc_code(Integer.parseInt(word[2]));
                    prescriptions.setPresc_days(Integer.parseInt(word[3]));
                }
                prescriptionsList.add(new Prescriptions(prescriptions.getPresc_id(),prescriptions.getPresc_ref_pat(),prescriptions.getPresc_code(),prescriptions.getPresc_days()));
                list.add(prescriptions.toString());
                index++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
