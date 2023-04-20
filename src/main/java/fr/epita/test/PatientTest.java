package main.java.fr.epita.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

    public class PatientTest {
        private String name;
        private Date subscriptionDate;

        public PatientTest(String name, Date subscriptionDate) {
            this.name = name;
            this.subscriptionDate = subscriptionDate;
        }

        public PatientTest() {

        }
        public String getName() {
            return name;
        }

        public Date getSubscriptionDate() {
            return subscriptionDate;
        }

        public static void main(String[] args) {
            ArrayList<PatientTest> patients = new ArrayList<>();
            patients.add(new PatientTest("John", new Date(2022, 3, 27)));
            patients.add(new PatientTest("Jane", new Date(2022, 2, 27)));
            patients.add(new PatientTest("Bob", new Date(2021, 11, 27)));

            Comparator<PatientTest> comparator = Comparator.comparing(PatientTest::getSubscriptionDate);
            Collections.sort(patients, comparator.reversed());

            for (PatientTest patient : patients) {
                System.out.println(patient.getName() + " - " + patient.getSubscriptionDate());
            }
        }

}
