package Models;

import java.util.Date;

public class Procedure {

    private Date checkInDate;
    private String patientId;
    private Room room;
    private ProcedureNotes procedureNotes;

    public Procedure(Date checkInDate, String patientId, Room room, ProcedureNotes procedureNotes) {
        this.checkInDate = checkInDate;
        this.patientId = patientId;
        this.room = room;
        this.procedureNotes = procedureNotes;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public ProcedureNotes getProcedureNotes() {
        return procedureNotes;
    }

    public void setProcedureNotes(ProcedureNotes procedureNotes) {
        this.procedureNotes = procedureNotes;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
