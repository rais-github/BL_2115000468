import java.util.ArrayList;
import java.util.List;



abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;

    public Patient(int patientId, String name, int age, String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int patientId, String name, int age, String diagnosis, String medicalHistory, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
}

class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, String diagnosis, String medicalHistory, double consultationFee) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class PatientMedicalRecord implements MedicalRecord {
    private List<String> records;

    public PatientMedicalRecord() {
        this.records = new ArrayList<>();
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient inPatient = new InPatient(1, "John Doe", 30, "Flu", "No history", 5, 2000);
        Patient outPatient = new OutPatient(2, "Jane Smith", 25, "Cold", "No history", 500);

        System.out.println(inPatient.getPatientDetails());
        System.out.println("Bill: " + inPatient.calculateBill());

        System.out.println(outPatient.getPatientDetails());
        System.out.println("Bill: " + outPatient.calculateBill());

        MedicalRecord record = new PatientMedicalRecord();
        record.addRecord("Patient admitted with flu.");
        record.addRecord("Patient discharged after 5 days.");

        System.out.println("Medical Records: " + record.viewRecords());
    }
}