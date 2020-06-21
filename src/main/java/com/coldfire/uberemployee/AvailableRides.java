package com.coldfire.uberemployee;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AvailableRides {
        public AvailableRides()
        {
            ArrayList<String> list=new ArrayList<>();
            DatabaseConnector dc=new DatabaseConnector("127.0.0.1","uber","postgres","Ayush81298!");
            try {
                Connection connection = dc.getConnection();

                String sql = "SELECT username,pickup_location, drop_location FROM ridedetails WHERE completed=false";
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    System.out.println("User:" + rs.getString(1) + "Pickup Location: " + rs.getString(2) + " Drop Location: " + rs.getString(3));
                    list.add(rs.getString(1));
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            Scanner scan=new Scanner(System.in);
            String client=list.get(scan.nextInt()-1);
            System.out.println("You will be servicing "+ client);
        }
}
