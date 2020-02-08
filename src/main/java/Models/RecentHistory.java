package Models;

import java.util.ArrayList;

public class RecentHistory {

    private ArrayList<CheckIn> previousCheckIns;
    private String careTakerName;

    public RecentHistory(ArrayList<CheckIn> previousCheckIns, String careTakerName) {
        this.previousCheckIns = previousCheckIns;
        this.careTakerName = careTakerName;
    }

    public ArrayList<CheckIn> getPreviousCheckIns() {
        return previousCheckIns;
    }

    public void setPreviousCheckIns(ArrayList<CheckIn> previousCheckIns) {
        this.previousCheckIns = previousCheckIns;
    }

    public String getCareTakerName() {
        return careTakerName;
    }

    public void setCareTakerName(String careTakerName) {
        this.careTakerName = careTakerName;
    }
}
