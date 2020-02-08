package DataSource;

import DataAccess.LocalDataAccess;
import Models.Patient;

import java.util.ArrayList;

public class PatientDao {

    public Patient getPatient (String id) {
        for (Patient temp : LocalDataAccess.PATIENTS) {
            if (temp.getPatientId().equals(id)) {
                return temp;
            }
        }

        // No Value found
        return null;
    }

    public ArrayList<Patient> getAllPatients () {
        return LocalDataAccess.PATIENTS;
    }

    public Patient createPatient (Patient patient) {
        LocalDataAccess.PATIENTS.add(patient);
        return patient;
    }
}
