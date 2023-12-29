//jangan lupa tukar depandenci

package com.mycompany.prefa;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;

public class PreFA implements ActionListener{
    
    JFrame frame;
    JLabel lbl_title, lbl_1, lbl_2, lbl_3, lbl_4, lbl_5, lbl_6, lbl_7, lbl_8, lbl_9, lbl_10, lbl_car_id;
    JPanel pnl_title, pnl_content, pnl_1, pnl_2, pnl_3, pnl_4, pnl_5, pnl_6, pnl_7, pnl_8, pnl_9, pnl_10, pnl_button, pnl_id;
    JTextField txt_plate, txt_maker, txt_mileage, txt_next_mileage, txt_cust_name, txt_phone_no, txt_next_date_chooser, txt_date_chooser, txt_car_id;
    JTextArea txt_remarks;
    JComboBox cb_maker, cb_model;

    JButton btnSubmit, btnUpdate, btnDisplay, btnFind;

    Connection conn;
    PreparedStatement stmt;
    String db_url = "jdbc:mysql://localhost/fed_data";

    String db_username = "root";

    String db_password = "";

    String carPlateNo, carMaker, carModel, currentMileage, serviceDate, nextCurrentMileage, nextServiceDate, custName, custContactNo, remarks;

     PreFA(){
         
         frame = new JFrame();
        frame.setTitle("Pre Final IPT");
        frame.setLayout(new BorderLayout());

        lbl_title = new JLabel("Car Record Management System");
        pnl_title = new JPanel();
        pnl_title.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnl_title.add(lbl_title);

        lbl_car_id = new JLabel("Car ID: ");
        pnl_id = new JPanel();
        lbl_car_id.setPreferredSize(new Dimension(200, 15));
        txt_car_id = new JTextField(20);

        lbl_1 = new JLabel("Car Plate Number :");
        txt_plate = new JTextField(20);
        pnl_1 = new JPanel();
        lbl_1.setPreferredSize(new Dimension(200, 15));
        pnl_1.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_2 = new JLabel("Car Maker :");
        String car_maker[] = {"Perodua", "Proton"};
        cb_maker = new JComboBox(car_maker);
        pnl_2 = new JPanel();
        lbl_2.setPreferredSize(new Dimension(200, 15));
        pnl_2.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_3 = new JLabel("Car Model :");
        String car_model[] = {"Myvi", "Viva", "Saga", "Skyline"};
        cb_model = new JComboBox(car_model);
        pnl_3 = new JPanel();
        lbl_3.setPreferredSize(new Dimension(200, 15));
        pnl_3.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_4 = new JLabel("Current Mileage :");
        txt_mileage = new JTextField(20);
        pnl_4 = new JPanel();
        lbl_4.setPreferredSize(new Dimension(200, 15));
        pnl_4.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_5 = new JLabel("Service Date :");
        txt_date_chooser = new JTextField(20);
        pnl_5 = new JPanel();
        lbl_5.setPreferredSize(new Dimension(200, 15));
        pnl_5.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_6 = new JLabel("Next Current Mileage :");
        txt_next_mileage = new JTextField(20);
        pnl_6 = new JPanel();
        lbl_6.setPreferredSize(new Dimension(200, 15));
        pnl_6.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_7 = new JLabel("Next Service Date :");
        txt_next_date_chooser = new JTextField(20);
        pnl_7 = new JPanel();
        lbl_7.setPreferredSize(new Dimension(200, 15));
        pnl_7.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_8 = new JLabel("Customer Name  :");
        txt_cust_name = new JTextField(20);
        pnl_8 = new JPanel();
        lbl_8.setPreferredSize(new Dimension(200, 15));
        pnl_8.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_9 = new JLabel("Customer Contact No :");
        txt_phone_no = new JTextField(20);
        pnl_9 = new JPanel();
        lbl_9.setPreferredSize(new Dimension(200, 15));
        pnl_9.setLayout(new FlowLayout(FlowLayout.LEFT));

        lbl_10 = new JLabel("Remarks :");
        txt_remarks = new JTextArea(5, 20);
        pnl_10 = new JPanel();
        lbl_10.setPreferredSize(new Dimension(200, 15));
        pnl_10.setLayout(new FlowLayout(FlowLayout.LEFT));

        pnl_button = new JPanel();
        pnl_button.setLayout(new FlowLayout(FlowLayout.CENTER));

        btnSubmit = new JButton("Insert");
        pnl_button = new JPanel();
        btnSubmit.addActionListener(this);

        btnUpdate = new JButton("Update");
        pnl_button = new JPanel();
        btnUpdate.addActionListener(this);

        btnDisplay = new JButton("Display");
        pnl_button = new JPanel();
        btnDisplay.addActionListener(this);
        
        btnFind = new JButton("Find");
        pnl_button = new JPanel();
        btnFind.addActionListener(this);

        pnl_id.add(lbl_car_id);
        pnl_id.add(txt_car_id);

        pnl_1.add(lbl_1);
        pnl_1.add(txt_plate);

        pnl_2.add(lbl_2);
        pnl_2.add(cb_maker);

        pnl_3.add(lbl_3);
        pnl_3.add(cb_model);

        pnl_4.add(lbl_4);
        pnl_4.add(txt_mileage);

        pnl_5.add(lbl_5);
        pnl_5.add(txt_date_chooser);

        pnl_6.add(lbl_6);
        pnl_6.add(txt_next_mileage);

        pnl_7.add(lbl_7);
        pnl_7.add(txt_next_date_chooser);

        pnl_8.add(lbl_8);
        pnl_8.add(txt_cust_name);

        pnl_9.add(lbl_9);
        pnl_9.add(txt_phone_no);

        pnl_10.add(lbl_10);
        pnl_10.add(txt_remarks);

        pnl_button.add(btnSubmit);
        pnl_button.add(btnUpdate);
        pnl_button.add(btnDisplay);
        pnl_button.add(btnFind);

        pnl_content = new JPanel();
        pnl_content.setLayout(new BoxLayout(pnl_content, BoxLayout.Y_AXIS));

        pnl_content.add(pnl_id);
        pnl_content.add(pnl_1);
        pnl_content.add(pnl_2);
        pnl_content.add(pnl_3);
        pnl_content.add(pnl_4);
        pnl_content.add(pnl_5);
        pnl_content.add(pnl_6);
        pnl_content.add(pnl_7);
        pnl_content.add(pnl_8);
        pnl_content.add(pnl_9);
        pnl_content.add(pnl_10);
        pnl_content.add(pnl_button);

        frame.add(pnl_title, BorderLayout.NORTH);
        frame.add(pnl_content, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        
        PreFA obj = new PreFA();

    }

     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {

            insert_data();

        }

        if (e.getSource() == btnUpdate) {

            update_data();

        }
        if (e.getSource() == btnDisplay) {

            display app = new display();

        }
        
        if (e.getSource() == btnFind) {

            select_data();

        }
    }

    public void update_data() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(db_url, db_username, db_password);

            String sql = "UPDATE car SET plate =?, make = ?,model = ?,current_mileage = ?,service_date =?,next_service_mileage =?,next_Service_date=?,customer_name=?,customer_contact=?,remark=? WHERE id=?";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, txt_plate.getText());
            stmt.setString(2, (String) cb_maker.getSelectedItem());

            stmt.setString(3, (String) cb_model.getSelectedItem());

            stmt.setString(4, txt_mileage.getText());

            stmt.setString(5, txt_date_chooser.getText());

            stmt.setString(6, txt_next_mileage.getText());

            stmt.setString(7, txt_next_date_chooser.getText());

            stmt.setString(8, txt_cust_name.getText());
            stmt.setString(9, txt_phone_no.getText());
            stmt.setString(10, txt_remarks.getText());
            stmt.setInt(11, Integer.parseInt(txt_car_id.getText()));

            int status = stmt.executeUpdate();

            if (status > 0) {

                JOptionPane.showMessageDialog(null, "UpdateSuccess");

            } else {
                JOptionPane.showMessageDialog(null, "Update Failed");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Connection Establishing Failed");
        }

    }

    public void select_data() {
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_username, db_password);

            String sql = "SELECT * FROM car WHERE id = ?";
            stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, Integer.parseInt(txt_car_id.getText()));
            rs = stmt.executeQuery();

            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    txt_car_id.setText(Integer.toString(rs.getInt("id")));
                    txt_plate.setText(rs.getString("plate"));
                    cb_maker.setSelectedItem(rs.getString("make"));
                    cb_model.setSelectedItem(rs.getString("model"));
                    txt_mileage.setText(rs.getString("current_mileage"));
                    txt_date_chooser.setText(rs.getString("service_date"));
                    txt_next_mileage.setText(rs.getString("next_service_mileage"));
                    txt_next_date_chooser.setText(rs.getString("next_Service_date"));
                    txt_cust_name.setText(rs.getString("customer_name"));
                    txt_phone_no.setText(rs.getString("customer_contact"));
                    txt_remarks.setText(rs.getString("remark"));

                }
                JOptionPane.showMessageDialog(null, "Data Loaded.");

            } else {
                JOptionPane.showMessageDialog(null, "No data found.");
                txt_car_id.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    public void insert_data() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            JOptionPane.showMessageDialog(null, "Driver Loaded");
            try {

                conn = DriverManager.getConnection(db_url, db_username, db_password);
                JOptionPane.showMessageDialog(null, "Connection Established");

                try {

                    carPlateNo = txt_plate.getText();
                    carMaker = (String) cb_maker.getSelectedItem();
                    carModel = (String) cb_model.getSelectedItem();
                    currentMileage = txt_mileage.getText();

                    serviceDate = txt_date_chooser.getText();
                    nextCurrentMileage = txt_next_mileage.getText();
                    nextServiceDate = txt_next_date_chooser.getText();
                    custName = txt_cust_name.getText();
                    custContactNo = txt_phone_no.getText();
                    remarks = txt_remarks.getText();

                    String sql = "INSERT INTO car (plate, make,model,current_mileage,service_date,next_service_mileage,next_Service_date,customer_name,customer_contact,remark)VALUES(?,?,?,?,?,?,?,?,?,? ) ";

                    stmt = conn.prepareStatement(sql);

                    stmt.setString(1, carPlateNo);
                    stmt.setString(2, carMaker);
                    stmt.setString(3, carModel);
                    stmt.setString(4, currentMileage);

                    stmt.setString(5, serviceDate);

                    stmt.setString(6, nextCurrentMileage);

                    stmt.setString(7, nextServiceDate);

                    stmt.setString(8, custName);
                    stmt.setString(9, custContactNo);
                    stmt.setString(10, remarks);

                    int status = stmt.executeUpdate();

                    if (status > 0) {

                        JOptionPane.showMessageDialog(null, "Record Insert Successfully");

                        txt_plate.setText("");
                        cb_maker.setSelectedIndex(0);
                        cb_model.setSelectedIndex(0);
                        txt_mileage.setText("");

                        txt_date_chooser.setText("");

                        txt_next_mileage.setText("");

                        txt_next_date_chooser.setText("");

                        txt_cust_name.setText("");
                        txt_phone_no.setText("");
                        txt_remarks.setText("");

                    } else {
                        JOptionPane.showMessageDialog(null, "Record insert failed.");
                    }

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "Error " + ex);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error Establishing Connection");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading Driver");
        }

    }
}

