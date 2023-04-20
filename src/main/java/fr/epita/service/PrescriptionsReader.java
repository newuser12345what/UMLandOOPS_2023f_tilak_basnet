package main.java.fr.epita.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrescriptionsReader {
    public static void main(String[] args){
        try{
            List<List<String>> dataList = new ArrayList<>();
            String file = "/Users/bsnt/workspace/java_workspace/UMLandOOPS_2023f_tilak_basnet/src/main/java/resources/prescriptions.csv";
            FileReader fileObj = new FileReader(file);
            Scanner scannerObj = new Scanner(fileObj);

            scannerObj.useDelimiter(";");

            while(scannerObj.hasNextLine()){
                List<String> stringList = Arrays.asList(scannerObj.next().split(";"));//  new ArrayList<>();
                dataList.add(stringList);
            }
            for(List<String> list : dataList){
                for(String str : list){
                    System.out.print(str + " ");
                }
            }
            scannerObj.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
