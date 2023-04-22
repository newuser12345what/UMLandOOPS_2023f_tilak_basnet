package main.java.fr.epita.dao;

import main.java.fr.epita.model.Medications;
import main.java.fr.epita.service.MedicationsReader;

import java.sql.*;
import java.util.ArrayList;

public class MedicationsDao {
    public void createMedicationsDAO() {

        MedicationsReader medicationsReader = new MedicationsReader();
        medicationsReader.medicationsReader();
        //medication_code;medication_name;medication_comment
        String query = "INSERT INTO MEDICATIONS(medication_code;medication_name;medication_comment) VALUES(?,?,?)";
        //Try to  Connection the postgres local database
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if (conn != null) {
                for (Medications medications : medicationsReader.medicationsList) {
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1,medications.getMedication_code());
                    preparedStatement.setString(2, medications.getMedication_name());
                    preparedStatement.setString(3, medications.getMedication_comment());
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
    public  void readMedicationsDAO(){
        Medications medications = new Medications();

        ArrayList<String> list = new ArrayList<>();

        String query= "SELECT * FROM MEDICATIONS ";

        //medication_code;medication_name;medication_comment
        try(Connection connection = DriverManager
                .getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if(connection != null){
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    // Fetch the data form the local database table and set value insurance_id, insurance_name varchar,
                    medications.setMedication_code(resultSet.getInt("medication_code"));
                    medications.setMedication_name(resultSet.getString("medication_name"));
                    medications.setMedication_comment(resultSet.getString("medication_comment"));

                    list.add(medications.toString());
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
