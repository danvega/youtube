package dev.danvega;

import com.github.javafaker.Faker;

import java.sql.*;

public class Application {

    private static final Faker faker = new Faker();

    public static void main(String[] args) throws SQLException {

        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:people","sa","")) {
            createSchema(connection);

            // create 100 rows of fake data
            for(int i = 1; i <= 100; ++i) {
                createAddress(connection, i);
                createPerson(connection, i);
            }

            // print out all people
            printPeople(connection);
        }

    }

    private static void printPeople(Connection connection) throws SQLException {
        PreparedStatement findAllPeople = connection.prepareStatement("SELECT * FROM PERSON");
        ResultSet rs = findAllPeople.executeQuery();

        while(rs.next()) {
            String person = String.format("Person %d: %s | %s | %s | %s | (Address ID: %d)",
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone_number"),
                    rs.getString("email"),
                    rs.getInt("address_id"));
            System.out.println(person);
        }
    }

    private static void createSchema(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String addressSchema = "create table address (id integer, address varchar(255), city varchar(255), state varchar(255), zip varchar(255), primary key (id))";
        String personSchema = "create table person (id integer, email varchar(255), first_name varchar(255), last_name varchar(255), phone_number varchar(255), address_id integer, primary key (id))";

        statement.executeUpdate(addressSchema);
        statement.executeUpdate(personSchema);
    }

    private static void createAddress(Connection connection, int i) throws SQLException {
        String insertAddressSQL = "INSERT INTO ADDRESS (id,address,city,state,zip) VALUES(?,?,?,?,?)";
        PreparedStatement createAddress = connection.prepareStatement(insertAddressSQL);
        createAddress.setInt(1, i);
        createAddress.setString(2, faker.address().streetAddress());
        createAddress.setString(3, faker.address().city());
        createAddress.setString(4, faker.address().state());
        createAddress.setString(5, faker.address().zipCode());
        createAddress.executeUpdate();
    }

    private static void createPerson(Connection connection, int i) throws SQLException {
        String insertPersonSQL = "INSERT INTO PERSON (id,first_name,last_Name,phone_number,email,address_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement createPerson = connection.prepareStatement(insertPersonSQL);
        createPerson.setInt(1, i);
        createPerson.setString(2, faker.name().firstName());
        createPerson.setString(3, faker.name().lastName());
        createPerson.setString(4, faker.phoneNumber().cellPhone());
        createPerson.setString(5, faker.internet().emailAddress());
        createPerson.setInt(6, i);
        createPerson.executeUpdate();
    }

}
