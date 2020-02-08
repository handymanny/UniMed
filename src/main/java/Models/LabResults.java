package Models;

import java.util.Date;

public class LabResults {

    private String labName;
    private Date labStartDate;
    private String labDetails;
    private Date labEndDate;

    public LabResults(String labName, Date labStartDate, String labDetails, Date labEndDate) {
        this.labName = labName;
        this.labStartDate = labStartDate;
        this.labDetails = labDetails;
        this.labEndDate = labEndDate;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public Date getLabStartDate() {
        return labStartDate;
    }

    public void setLabStartDate(Date labStartDate) {
        this.labStartDate = labStartDate;
    }

    public String getLabDetails() {
        return labDetails;
    }

    public void setLabDetails(String labDetails) {
        this.labDetails = labDetails;
    }

    public Date getLabEndDate() {
        return labEndDate;
    }

    public void setLabEndDate(Date labEndDate) {
        this.labEndDate = labEndDate;
    }
}
