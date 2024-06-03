package aihs;

public class Patient 
{
    private String name;
    private int age;
    private String medicalHistory;
    private String currentCondition;

    public Patient(String name, int age, String medicalHistory, String currentCondition) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.currentCondition = currentCondition;
    }

    // Getters and setters for each field
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
    public String getCurrentCondition() { return currentCondition; }
    public void setCurrentCondition(String currentCondition) { this.currentCondition = currentCondition; }
}
