package DataSource;

import DataAccess.LocalDataAccess;
import Models.CheckIn;

import java.util.ArrayList;

public class CheckInDao {

    private LocalDataAccess json = new LocalDataAccess();

    public CheckIn getCheckIn (String id) {
        for (CheckIn temp : json.populateCheckIns()) {
            if (temp.getId().equals(id)) {
                return temp;
            }
        }

        // No Value found
        return null;
    }

    public ArrayList<CheckIn> getAllCheckIn () {
        return json.CHECK_INS;
    }

    public CheckIn createCheckIn (CheckIn checkIn) {
        json.CHECK_INS.add(checkIn);
        return checkIn;
    }
}
