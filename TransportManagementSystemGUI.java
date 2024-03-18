import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransportManagementSystemGUI {
    private JFrame mainframe;
    private JTextField driverNameField, driverAgeField, driverGenderField, driverExperienceField;
    private JTextField vehicleModelField, vehicleRegField, vehicleManufDateField;
    private JTextField maintenancePrevDateField, maintenanceTypeField, maintenanceScheduledDateField;
    private JTextField reportDateField, reportDataField;
    private JTextArea displayArea;
    private Vehicle[] vehicle_list = new Vehicle[200];

    public TransportManagementSystemGUI() {
        mainframe = new JFrame("Transport Management System");
        mainframe.setSize(500, 700);
        mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(0, 2,3,5);
        mainframe.setLayout(layout);

        // Driver fields
        mainframe.add(new JLabel("  Driver Name:"));
        driverNameField = new JTextField();
        mainframe.add(driverNameField);

        mainframe.add(new JLabel("  Driver Age:"));
        driverAgeField = new JTextField();
        mainframe.add(driverAgeField);

        mainframe.add(new JLabel("  Driver Gender:"));
        driverGenderField = new JTextField();
        mainframe.add(driverGenderField);

        mainframe.add(new JLabel("  Driver Experience:"));
        driverExperienceField = new JTextField();
        mainframe.add(driverExperienceField);

        // Vehicle fields
        mainframe.add(new JLabel("  Vehicle Model:"));
        vehicleModelField = new JTextField();
        mainframe.add(vehicleModelField);

        mainframe.add(new JLabel("  Vehicle Registration Number:"));
        vehicleRegField = new JTextField();
        mainframe.add(vehicleRegField);

        mainframe.add(new JLabel("  Vehicle Manufacture Date:"));
        vehicleManufDateField = new JTextField();
        mainframe.add(vehicleManufDateField);

        // Maintenance fields
        mainframe.add(new JLabel("  Maintenance Previous Date:"));
        maintenancePrevDateField = new JTextField();
        mainframe.add(maintenancePrevDateField);

        mainframe.add(new JLabel("  Maintenance Type:"));
        maintenanceTypeField = new JTextField();
        mainframe.add(maintenanceTypeField);

        mainframe.add(new JLabel("  Maintenance Scheduled Date:"));
        maintenanceScheduledDateField = new JTextField();
        mainframe.add(maintenanceScheduledDateField);

        // Report fields
        mainframe.add(new JLabel("  Report Date:"));
        reportDateField = new JTextField();
        mainframe.add(reportDateField);

        mainframe.add(new JLabel("  Report Data:"));
        reportDataField = new JTextField();
        mainframe.add(reportDataField);

        // Buttons
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    add_data();
                }catch (Exception error){
                    JOptionPane.showMessageDialog(mainframe,"Ensure that all fields are correctly filled");
                }
            }
        });
        mainframe.add(addButton);

        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display_data();
            }
        });
        mainframe.add(displayButton);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setPreferredSize(new Dimension(200,200));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(200,200));

        mainframe.setVisible(true);
    }

    public void add_data() {
        // Get data from text fields
        String driverName = driverNameField.getText();
        int driverAge = Integer.parseInt(driverAgeField.getText());
        String driverGender = driverGenderField.getText();
        int driverExperience = Integer.parseInt(driverExperienceField.getText());

        String vehicleModel = vehicleModelField.getText();
        String vehicleReg = vehicleRegField.getText();
        String vehicleManufDate = vehicleManufDateField.getText();

        String maintenancePrevDate = maintenancePrevDateField.getText();
        String maintenanceType = maintenanceTypeField.getText();
        String maintenanceScheduledDate = maintenanceScheduledDateField.getText();

        String reportDate = reportDateField.getText();
        String reportData = reportDataField.getText();

        // Create objects
        Driver driver = new Driver(driverName, driverAge, driverGender, driverExperience);
        Maintenance maintenance = new Maintenance(maintenancePrevDate, maintenanceType, maintenanceScheduledDate);
        Report report = new Report(reportDate, reportData);
        Vehicle vehicle = new Vehicle(vehicleModel, vehicleReg, vehicleManufDate, driver, maintenance, report);

        for (int i = 0; i < vehicle_list.length; i++) {
            if (vehicle_list[i] == null) {
                vehicle_list[i] = vehicle;
                break;
            }
        }

        JOptionPane.showMessageDialog(mainframe, vehicleModelField.getText() +" " + vehicleRegField.getText() + " has been added successfully");

        driverNameField.setText("");
        driverAgeField.setText("");
        driverGenderField.setText("");
        driverExperienceField.setText("");

        vehicleModelField.setText("");
        vehicleManufDateField.setText("");
        vehicleRegField.setText("");

        maintenancePrevDateField.setText("");
        maintenanceScheduledDateField.setText("");
        maintenanceTypeField.setText("");

        reportDataField.setText("");
        reportDateField.setText("");
    }

    public void display_data() {
        JFrame top_level = new JFrame("Vehicle details");
        top_level.setSize(400,500);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setPreferredSize(new Dimension(200,200));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        top_level.add(scrollPane);

        // Display all information
        displayArea.append("Displaying All Vehicles:\n");
        get_all_vehicles_and_their_details();

        top_level.setVisible(true);
    }

    private void get_all_vehicles_and_their_details() {
        // Method to display details of all vehicles
        displayArea.append("Vehicle Details:\n");
        displayArea.append("\n");
        for (int i = 0; i < vehicle_list.length; i++) {
            if (vehicle_list[i] != null) {
                displayArea.append("Vehicle " + (i + 1) + ":\n");
                displayArea.append(vehicle_list[i].get_details());
                displayArea.append("\n");
                displayArea.append("\n");
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new TransportManagementSystemGUI();
    }
}
