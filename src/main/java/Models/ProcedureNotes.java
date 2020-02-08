package Models;

public class ProcedureNotes {

    private String submittedBy;
    private String notes;

    public ProcedureNotes(String submittedBy, String notes) {
        this.submittedBy = submittedBy;
        this.notes = notes;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
