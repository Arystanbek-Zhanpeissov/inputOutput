import java.sql.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException {
        DBConnection db = new DBConnection();
        Scanner scan = new Scanner(System.in);
        System.out.println("Input = 1, Output = 2");
        int x = scan.nextInt();
        switch (x)
        {
            case 1:
                try {
                    System.out.println("Enter your name");
                    String name = scan.next();
                    System.out.println("Enter your age: ");
                    int age = scan.nextInt();
                    String query = "Insert into \"DBTestTable\" (name, age) values (?,?); ";
                    PreparedStatement stmt =  db.getConnection().prepareStatement(query);
                    stmt.setString(1,name);
                    stmt.setInt(2,age);
                    stmt.executeUpdate();
                    System.out.println("Data Saved");

                } catch (SQLException e) {
                    System.out.println("Failed");
                }
                ;
                break;
            case 2:
                try {
                    Statement stmt =  db.getConnection().createStatement();
                    String query = "SELECT * FROM \"DBTestTable\";";
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int age = rs.getInt("age");
                        System.out.println("Id = " + id +"name = " + name + " and age " + age);

                    }
                } catch (SQLException e) {
                    System.out.println("Failed");
                }
                ;
        }

    }
}