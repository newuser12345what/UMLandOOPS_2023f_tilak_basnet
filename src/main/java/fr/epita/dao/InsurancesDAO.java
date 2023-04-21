package main.java.fr.epita.dao;

import main.java.fr.epita.model.Insurances;
import main.java.fr.epita.service.InsuranceReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class InsurancesDAO {
    static Insurances insurances = new Insurances();
    public void createInsuranceDAO(){

        InsuranceReader insuranceReader = new InsuranceReader();
        insuranceReader.insuranceReader();

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

    // This method is use for manually insert data
    public void createInsurance(){
        Scanner data = new Scanner(System.in);

        System.out.println("Enter the Insurance_id");
        int insurance_id = data.nextInt();
        insurances.setInsurance_id(insurance_id);

        System.out.println("Enter the Insurance Name");
        String insurance_name = data.nextLine();
        insurances.setInsurance_name(insurance_name);

        String query= "INSERT INTO INSURANCES(insurance_id, insurance_name) VALUES(?, ?)";
        //Try to  Connection the postgres local database
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {

            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1,insurances.getInsurance_id());
                preparedStatement.setString(2,insurances.getInsurance_name());
                preparedStatement.executeUpdate();
                conn.close(); // Close the Database connection
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

    public  void readInsuranceDAO(){
        ArrayList<String> insuranceList = new ArrayList<>();
        String query= "SELECT * FROM INSURANCES";
        try(Connection connection = DriverManager
                .getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if(connection != null){
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    // Fetch the data form the local database table and set value insurance_id, insurance_name varchar,
                    insurances.setInsurance_id(resultSet.getInt("insurance_id"));
                    insurances.setInsurance_name( resultSet.getString("insurance_name"));
                    insuranceList.add(insurances.toString());
                }
                for (String i: insuranceList) {
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
    public  void updateInsuranceDAO(){
        Scanner data = new Scanner(System.in);

        System.out.println("Enter the Insurance_id which you want to update : ");
        int insurance_id = data.nextInt();
        insurances.setInsurance_id(insurance_id);

        System.out.println("Enter the Insurance Name for update value(new name):");
        String insurance_name = data.nextLine();
        insurances.setInsurance_name(insurance_name);

       // String query= "INSERT INTO INSURANCES(insurance_id, insurance_name) VALUES(?, ?)";

        String query = "UPDATE INSURANCES SET insurance_name = ? WHERE insurance_id = ? ";
        //Try to  Connection the postgres local database
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {

            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.executeUpdate();
                conn.close(); // Close the Database connection
                System.out.println(" Data updated Successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteInsuranceDAO(){

    }

}
