package DataSource;

import DataAccess.LocalDataAccess;
import Models.Patient;

import java.util.ArrayList;

public class PatientDao {

    private LocalDataAccess json = new LocalDataAccess();

    public Patient getPatient (String id) {
        for (Patient temp : json.populatePatients()) {
            if (temp.getPatientId().equals(id)) {
                return temp;
            }
        }

        // No Value found
        return null;
    }

    public ArrayList<Patient> getAllPatients () {
        return json.populatePatients();
    }

    public Patient createPatient (Patient patient) {
        json.PATIENTS.add(patient);
        return patient;
    }
}
