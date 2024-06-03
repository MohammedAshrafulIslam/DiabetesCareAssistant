package aihs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;




public class PatientForm extends JFrame {
	
	
	private List<String[]> patientInfoList;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea medicalHistoryArea;
    private JTextArea currentConditionArea;
    private JButton submitButton;
    private JTextArea prescriptionArea;

    public PatientForm() throws IOException {
        setTitle("Patient Information Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2));

        formPanel.add(new JLabel("Enter patient name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Enter patient age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Enter patient's medical history:"));
        medicalHistoryArea = new JTextArea();
        formPanel.add(new JScrollPane(medicalHistoryArea));

        formPanel.add(new JLabel("Enter patient's current condition:"));
        currentConditionArea = new JTextArea();
        formPanel.add(new JScrollPane(currentConditionArea));

        submitButton = new JButton("Submit");
        formPanel.add(submitButton);
        
        
        prescriptionArea = new JTextArea(5, 20);
        prescriptionArea.setEditable(false);
        add(new JScrollPane(prescriptionArea), BorderLayout.SOUTH);

        add(formPanel, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitPatientInfo();
            }
        });
        
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePrescription();
            }
        });
        
        loadPatientInfo("Perscriptions.txt");

    }

    private void submitPatientInfo() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String medicalHistory = medicalHistoryArea.getText();
        String currentCondition = currentConditionArea.getText();

        Patient patient = new Patient(name, age, medicalHistory, currentCondition);

        
        JOptionPane.showMessageDialog(this, "Patient Name: " + patient.getName() +
                "\nPatient Age: " + patient.getAge() +
                "\nMedical History: " + patient.getMedicalHistory() +
                "\nCurrent Condition: " + patient.getCurrentCondition());
    }
    
    
    private void generatePrescription() {
        String name = nameField.getText().trim();

        String[] patientData = patientInfoList.stream()
                .filter(info -> info[0].trim().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (patientData != null && patientData.length > 5) { 
            String prescriptionText = "Prescription for " + patientData[0] // Name
                    + "\nAge: " + patientData[1] // Age
                    + "\nMedical History: " + patientData[2] // Medical History
                    + "\nCurrent Condition: " + patientData[3] // Current Condition
                    + "\n\nMedication: " + patientData[4] // Medication
                    + "\nDosage: " + patientData[5]; // Dosage
            
            prescriptionArea.setText(prescriptionText);
        } else {
            prescriptionArea.setText("No patient found with the name: " + name);
        }
    }
    
    
    private void loadPatientInfo(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        patientInfoList = lines.stream()
            .skip(1) // Skip headers
            .map(line -> line.split("\t")) // Assuming the fields are separated by tabs.
            .collect(Collectors.toList());
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PatientForm frame;
			try {
				frame = new PatientForm();
				frame.setVisible(true);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
           
        });
    }
}
