package DataAccess;

import Models.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LocalDataAccess {


    public ArrayList<Patient> PATIENTS;
    public ArrayList<CheckIn> CHECK_INS;

    public LocalDataAccess () {
        PATIENTS = populatePatients();
        CHECK_INS = populateCheckIns();
    }

    // Populating
    public ArrayList<Patient> populatePatients () {
        ArrayList<Patient> temp = new ArrayList<>();

        // Get Json file
        File jsonFile = new File("/home/emmanuel/UniMed/src/main/resources/JSON/patients.json");
        try {
            temp = new Gson().fromJson(new FileReader(jsonFile), new TypeToken<ArrayList<Patient>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public ArrayList<CheckIn> populateCheckIns () {
        ArrayList<CheckIn> temp = new ArrayList<>();

        return temp;
    }

}
