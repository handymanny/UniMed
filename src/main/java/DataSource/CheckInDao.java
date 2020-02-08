package DataSource;

import DataAccess.LocalDataAccess;
import Models.CheckIn;

import java.util.ArrayList;

public class CheckInDao {

    public CheckIn getCheckIn (String id) {
        for (CheckIn temp : LocalDataAccess.CHECK_INS) {
            if (temp.getId().equals(id)) {
                return temp;
            }
        }

        // No Value found
        return null;
    }

    public ArrayList<CheckIn> getAllCheckIn () {
        return LocalDataAccess.CHECK_INS;
    }

    public CheckIn createCheckIn (CheckIn checkIn) {
        LocalDataAccess.CHECK_INS.add(checkIn);
        return checkIn;
    }
}
