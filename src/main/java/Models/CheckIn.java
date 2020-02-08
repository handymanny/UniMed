package Models;

import java.util.Date;

public class CheckIn {

    private Date checkedIn;
    private String id;
    private Patient patient;
    private Room room;
    private Date checkedOut;

    public CheckIn(Date checkedIn, String id, Patient patient, Room room) {
        this.checkedIn = checkedIn;
        this.id = id;
        this.patient = patient;
        this.room = room;
    }

    public CheckIn(Date checkedIn, String id, Patient patient, Room room, Date checkedOut) {
        this.checkedIn = checkedIn;
        this.id = id;
        this.patient = patient;
        this.room = room;
        this.checkedOut = checkedOut;
    }

    public Date getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Date checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public Date getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Date checkedOut) {
        this.checkedOut = checkedOut;
    }
}
