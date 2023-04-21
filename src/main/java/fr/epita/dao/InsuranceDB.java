package main.java.fr.epita.dao;

import main.java.fr.epita.model.Insurances;
import main.java.fr.epita.service.InsuranceReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsuranceDB {
    public void createInsuranceDAO(){

        InsuranceReader insuranceReader = new InsuranceReader();
        insuranceReader.insuranceReader();
        // insurance_id int,
        //    insurance_name varchar,
        String query= "INSERT INTO INSURANCES(insurance_id, insurance_name) VALUES(?, ?)";
        //Try to  Connection the postgres local database
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if (conn != null) {
                for (Insurances insurances : insuranceReader.insurancesList) {
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1,insurances.getInsurance_id());
                    preparedStatement.setString(2,insurances.getInsurance_name());
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
        //End the Database connection
    }
}
