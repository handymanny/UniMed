package DataAccess;

import Models.*;

import java.util.ArrayList;

public class LocalDataAccess {


    public static ArrayList<Patient> PATIENTS = populatePatients();
    public static ArrayList<CheckIn> CHECK_INS = populateCheckIns();


    // Populating
    private static ArrayList<Patient> populatePatients () {
        ArrayList<Patient> temp = new ArrayList<>();

        return temp;
    }

    private static ArrayList<CheckIn> populateCheckIns () {
        ArrayList<CheckIn> temp = new ArrayList<>();

        return temp;
    }

    // Helpers
    private static ArrayList<Procedure> createProcedures () {
        ArrayList<Procedure> temp = new ArrayList<>();

        return temp;
    }

    private static ArrayList<PatientHistory> createPatientHistory () {
        ArrayList<PatientHistory> temp = new ArrayList<>();

        return temp;
    }

    private static ArrayList<LabResults> createLabResults () {
        ArrayList<LabResults> temp = new ArrayList<>();

        return temp;
    }

    private static ArrayList<RecentHistory> createRecentHistory () {
        ArrayList<RecentHistory> temp = new ArrayList<>();

        return temp;
    }

}
