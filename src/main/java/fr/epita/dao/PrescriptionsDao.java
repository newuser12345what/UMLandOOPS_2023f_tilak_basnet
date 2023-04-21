package main.java.fr.epita.dao;

import main.java.fr.epita.model.Prescriptions;
import main.java.fr.epita.service.PrescriptionsReader;

import java.sql.*;
import java.util.ArrayList;

public class PrescriptionsDao {

    public void createPrescriptionsDAO() {

        PrescriptionsReader prescriptionsReader = new PrescriptionsReader();
        prescriptionsReader.prescriptionsReader();
        //presc_id;presc_ref_pat;presc_code;presc_days
        String query = "INSERT INTO MEDICATIONS(medication_code;medication_name;medication_comment) VALUES(?,?,?)";
        //Try to  Connection the postgres local database
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if (conn != null) {
                for (Prescriptions prescriptions : prescriptionsReader.prescriptionsList) {
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1,prescriptions.getPresc_id());
                    preparedStatement.setLong(2, prescriptions.getPresc_ref_pat());
                    preparedStatement.setLong(3, prescriptions.getPresc_code());
                    preparedStatement.setInt(4,prescriptions.getPresc_days());
                    preparedStatement.executeUpdate();
                }
                conn.close();// Close the Database connection
                System.out.println("Inserted Data Successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void readPrescriptionsDAO(){
        Prescriptions prescriptions = new Prescriptions();

        ArrayList<String> list = new ArrayList<>();

        String query= "SELECT * FROM PRESCRIPTIONS";

        try(Connection connection = DriverManager
                .getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if(connection != null){
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    // Fetch the data form the local database table and set value insurance_id, insurance_name varchar,
                    //presc_id;presc_ref_pat;presc_code;presc_days
                    prescriptions.setPresc_id(resultSet.getInt("presc_id"));
                    prescriptions.setPresc_ref_pat(resultSet.getLong("presc_ref_pat"));
                    prescriptions.setPresc_code(resultSet.getInt("presc_code"));
                    prescriptions.setPresc_days(resultSet.getInt("presc_days"));

                    list.add(prescriptions.toString());
                }
                for (String i: list) {
                    System.out.println(i);
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
