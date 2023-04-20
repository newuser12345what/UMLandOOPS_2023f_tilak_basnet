package main.java.fr.epita.test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Patient, String> treeMap = new TreeMap<>(new CustomComparator());
        treeMap.put(new Patient("John"), "2022-01-01");
        treeMap.put(new Patient("Jane"), "2022-02-01");
        treeMap.put(new Patient("Bob"), "2022-03-01");

        // To print all patients in a TreeMap according to subscription date priority and date
        for (Map.Entry<Patient, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }

    static class CustomComparator implements Comparator<Patient> {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class Patient {
        private String name;

        public Patient(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}