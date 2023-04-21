package main.java.fr.epita.dao;

import main.java.fr.epita.model.Patients;
import main.java.fr.epita.service.PatientsReader;

import java.sql.*;
import java.util.ArrayList;

public class PatientsDao {
    public void createPatientsDAO() {
        PatientsReader patientsReader = new PatientsReader();
        patientsReader.patientReader();
        //pat_num_HC, pat_lastname, pat_firstname, pat_address, pat_tel, pat_insurance_id, pat_subscription_date
        String query = "INSERT INTO PATIENTS(pat_num_HC, pat_lastname, pat_firstname, pat_address, pat_tel, pat_insurance_id, pat_subscription_date) VALUES(?,?,?,?,?,?,?)";
        //Try to  Connection the postgres local database
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if (conn != null) {
                for (Patients patients : patientsReader.patientsList) {
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1,patients.getPat_num_hc());
                    preparedStatement.setString(2, patients.getPat_lastname());
                    preparedStatement.setString(3, patients.getPat_firstname());
                    preparedStatement.setString(4, patients.getPat_address());
                    preparedStatement.setString(5, patients.getPat_tel());
                    preparedStatement.setInt(6, patients.getPat_insurance_id());

                    preparedStatement.setString(7, String.valueOf(patients.getPat_subscription_date()));

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
    public  void readInsuranceDAO(){
        Patients patients = new Patients();
        ArrayList<String> list = new ArrayList<>();
        String query= "SELECT * FROM PATIENTS";
        try(Connection connection = DriverManager
                .getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if(connection != null){
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    // Fetch the data form the local database table and set value insurance_id, insurance_name varchar,
                    ////pat_num_HC, pat_lastname, pat_firstname, pat_address, pat_tel, pat_insurance_id, pat_subscription_date
                    patients.setPat_num_hc(resultSet.getString("pat_num_HC"));
                    patients.setPat_lastname(resultSet.getString("pat_lastname"));
                    patients.setPat_firstname(resultSet.getString("pat_firstname"));
                    patients.setPat_address(resultSet.getString("pat_address"));
                    patients.setPat_tel(resultSet.getString("pat_tel"));
                    patients.setPat_insurance_id(resultSet.getInt("pat_insurance_id"));
                    patients.setPat_subscription_date(resultSet.getDate("pat_subscription_date"));
                    list.add(patients.toString());
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
