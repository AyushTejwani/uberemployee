package com.coldfire.uberemployee;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AvailableRides {
        public AvailableRides()
        {
            DatabaseConnector dc=new DatabaseConnector("127.0.0.1","uber","postgres","Ayush81298!");
            try
            {
                Connection connection=dc.getConnection();
                String sql="SELECT pickup_location, drop_location FROM ridedetails WHERE completed=false";
                Statement statement=connection.createStatement();
                ResultSet rs=statement.executeQuery(sql);
                while (rs.next())
                    System.out.println("Pickup Location: "+ rs.getString(1)+" Drop Location: "+rs.getString(2));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
}
