import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleRegistrationApp extends JFrame {
    private VehicleManager manager;

    private JTextField txtVehicleID, txtModel, txtBrand, txtEngineCapacity, txtSpecificAttribute;
    private JComboBox<String> cmbType;
    private JLabel lblSpecificAttribute;
    private JTextArea txtOutput;

    // Custom UI Color Palette (Mauve & Soft Lavender Palette)
    private final Color COLOR_BACKGROUND = new Color(135, 90, 105); 
    private final Color COLOR_PANEL = new Color(245, 240, 242);     
    private final Color COLOR_TEXT_MAIN = new Color(45, 25, 35);    
    private final Color COLOR_BTN_ADD = new Color(41, 128, 185);    
    private final Color COLOR_BTN_SEARCH = new Color(142, 68, 173); 
    private final Color COLOR_BTN_DISPLAY = new Color(192, 57, 43); 

    public VehicleRegistrationApp() {
        manager = new VehicleManager();
        initUI();
    }

    private void initUI() {
        setTitle("Vehicle Registration System");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(COLOR_BACKGROUND);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(COLOR_PANEL);
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BACKGROUND, 1), 
                " Vehicle Specifications ", TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("Segoe UI", Font.BOLD, 14), COLOR_TEXT_MAIN));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);

        // Row 0
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblID = new JLabel("Vehicle ID:"); lblID.setFont(labelFont); lblID.setForeground(COLOR_TEXT_MAIN);
        formPanel.add(lblID, gbc);
        gbc.gridx = 1; txtVehicleID = new JTextField(12); txtVehicleID.setFont(fieldFont);
        formPanel.add(txtVehicleID, gbc);

        gbc.gridx = 2;
        JLabel lblBrand = new JLabel("Brand:"); lblBrand.setFont(labelFont); lblBrand.setForeground(COLOR_TEXT_MAIN);
        formPanel.add(lblBrand, gbc);
        gbc.gridx = 3; txtBrand = new JTextField(12); txtBrand.setFont(fieldFont);
        formPanel.add(txtBrand, gbc);

        // Row 1
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblModel = new JLabel("Model:"); lblModel.setFont(labelFont); lblModel.setForeground(COLOR_TEXT_MAIN);
        formPanel.add(lblModel, gbc);
        gbc.gridx = 1; txtModel = new JTextField(12); txtModel.setFont(fieldFont);
        formPanel.add(txtModel, gbc);

        gbc.gridx = 2;
        JLabel lblEngine = new JLabel("Engine Capacity:"); lblEngine.setFont(labelFont); lblEngine.setForeground(COLOR_TEXT_MAIN);
        formPanel.add(lblEngine, gbc);
        gbc.gridx = 3; txtEngineCapacity = new JTextField(12); txtEngineCapacity.setFont(fieldFont);
        formPanel.add(txtEngineCapacity, gbc);

        // Row 2
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblType = new JLabel("Type:"); lblType.setFont(labelFont); lblType.setForeground(COLOR_TEXT_MAIN);
        formPanel.add(lblType, gbc);
        gbc.gridx = 1; 
        cmbType = new JComboBox<>(new String[]{"Car", "Motorcycle", "Van"});
        cmbType.setFont(fieldFont);
        formPanel.add(cmbType, gbc);

        gbc.gridx = 2; 
        lblSpecificAttribute = new JLabel("Number of Doors:"); lblSpecificAttribute.setFont(labelFont); lblSpecificAttribute.setForeground(COLOR_TEXT_MAIN);
        formPanel.add(lblSpecificAttribute, gbc);
        gbc.gridx = 3; txtSpecificAttribute = new JTextField(12); txtSpecificAttribute.setFont(fieldFont);
        formPanel.add(txtSpecificAttribute, gbc);

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        actionPanel.setBackground(COLOR_PANEL);

        JButton btnAdd = createStyledButton("Add Vehicle", COLOR_BTN_ADD);
        JButton btnSearch = createStyledButton("Search Car", COLOR_BTN_SEARCH);
        JButton btnDisplay = createStyledButton("Display All", COLOR_BTN_DISPLAY);

        actionPanel.add(btnAdd);
        actionPanel.add(btnSearch);
        actionPanel.add(btnDisplay);

        JPanel inputWrapper = new JPanel(new BorderLayout(5, 5));
        inputWrapper.add(formPanel, BorderLayout.CENTER);
        inputWrapper.add(actionPanel, BorderLayout.SOUTH);
        mainPanel.add(inputWrapper, BorderLayout.NORTH);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBackground(COLOR_PANEL);
        outputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BACKGROUND, 1), 
                " Console Activity Output ", TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("Segoe UI", Font.BOLD, 14), COLOR_TEXT_MAIN));

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Consolas", Font.PLAIN, 13));
        
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.CENTER);

        add(mainPanel);

        // ComboBox Switch Handler
        cmbType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) cmbType.getSelectedItem();
                if ("Car".equals(selected)) {
                    lblSpecificAttribute.setText("Number of Doors:");
                } else if ("Motorcycle".equals(selected)) {
                    lblSpecificAttribute.setText("Has Carrier (true/false):");
                } else if ("Van".equals(selected)) {
                    lblSpecificAttribute.setText("Load Capacity:");
                }
            }
        });

        // Add Vehicle
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateInputs();

                    String id = txtVehicleID.getText().trim();
                    String model = txtModel.getText().trim();
                    String brand = txtBrand.getText().trim();
                    double capacity = Double.parseDouble(txtEngineCapacity.getText().trim());
                    String type = (String) cmbType.getSelectedItem();
                    String specificVal = txtSpecificAttribute.getText().trim();

                    Vehicle newVehicle = null;

                    if ("Car".equals(type)) {
                        int doors = Integer.parseInt(specificVal);
                        newVehicle = new Car(id, model, brand, capacity, doors);
                    } else if ("Motorcycle".equals(type)) {
                        if (!specificVal.equalsIgnoreCase("true") && !specificVal.equalsIgnoreCase("false")) {
                            throw new IllegalArgumentException("Carrier value must be 'true' or 'false'.");
                        }
                        boolean carrier = Boolean.parseBoolean(specificVal);
                        newVehicle = new Motorcycle(id, model, brand, capacity, carrier);
                    } else if ("Van".equals(type)) {
                        double load = Double.parseDouble(specificVal);
                        newVehicle = new Van(id, model, brand, capacity, load);
                    }

                    manager.addVehicle(newVehicle);
                    txtOutput.append("Successfully Registered: " + newVehicle.getModel() + " [" + type + "]\n");
                    clearFormFields();

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(VehicleRegistrationApp.this, 
                        "Data Parsing Error: Please verify that numbers use clean numerical formats.", 
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(VehicleRegistrationApp.this, 
                        iae.getMessage(), "Validation Error", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(VehicleRegistrationApp.this, 
                        ex.getMessage(), "Duplicate Detected", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Search Car Handler
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criteria = txtModel.getText().trim();
                if (criteria.isEmpty()) {
                    JOptionPane.showMessageDialog(VehicleRegistrationApp.this, 
                        "Please provide a target name inside the 'Model' text field box to run a search.", 
                        "Notice", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String lookupResult = manager.searchCar(criteria);
                txtOutput.setText("--- Car Model Search Execution Summary ---\n" + lookupResult);
            }
        });

        // Display All Handler
        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtOutput.setText("--- System Registration Records Listing ---\n" + manager.displayAllVehicles());
            }
        });
    }

    private JButton createStyledButton(String text, Color background) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(background);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        return btn;
    }

    private void validateInputs() {
        if (txtVehicleID.getText().trim().isEmpty() || 
            txtModel.getText().trim().isEmpty() || 
            txtBrand.getText().trim().isEmpty() || 
            txtEngineCapacity.getText().trim().isEmpty() || 
            txtSpecificAttribute.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Missing Values: All inputs must be filled out before registering.");
        }
    }

    private void clearFormFields() {
        txtVehicleID.setText("");
        txtModel.setText("");
        txtBrand.setText("");
        txtEngineCapacity.setText("");
        txtSpecificAttribute.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VehicleRegistrationApp().setVisible(true);
        });
    }
}