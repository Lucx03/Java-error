
package com.mycompany.prefa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class display {
    
    JFrame frame;
    DefaultTableModel tableModel; 
    JScrollPane scrollpane; 
    JTable table;
    
    Connection conn;
    Statement stmt;
    ResultSet results;
    
    // copy paste #2
    String db_username = "root";
    String db_password = "";
    String db_url = "jdbc:mysql://localhost:3306/fed_data";
    
    display(){
        frame = new JFrame("Display Records");
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Car Plate No");
        tableModel.addColumn("Car Make");
        tableModel.addColumn("Car Model");
        tableModel.addColumn("Current Mileage");
        tableModel.addColumn("Service Date");
        tableModel.addColumn("Next Service Mileage");
        tableModel.addColumn("Next Service Date");
        tableModel.addColumn("Customer Name");
        tableModel.addColumn("Customer Contact Number");
        tableModel.addColumn("Remarks");
        
        try
        {
            
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_username, db_password);
            
            
            String sql = "SELECT * FROM car";
            stmt = conn.prepareStatement(sql); 
            results = stmt.executeQuery(sql);
            
            while(results.next())
            {
                Object[] row = new Object[10]; 
                
                row[0] = results.getString("plate"); 
                row[1] = results.getString("make"); 
                row[2] = results.getString("model"); 
                row[3] = results.getString("current_mileage"); 
                row[4] = results.getString("service_date"); 
                row[5] = results.getString("next_service_mileage"); 
                row[6] = results.getString("next_Service_date"); 
                row[7] = results.getString("customer_name"); 
                row[8] = results.getString("customer_contact"); 
                row[9] = results.getString("remark"); 
                
                
                tableModel.addRow(row);
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
        table = new JTable(tableModel); // insert model into table
        scrollpane = new JScrollPane(table);
        
        frame.add(scrollpane);
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        display app = new display();
    }
    
}

    

