package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Patient {

    @Expose
    private String patientId;
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String preferredName;

    @Expose
    private Date date;
    @Expose
    private Date dateOfBirth;

    @Expose
    private String address;
    @Expose
    private String city;
    @Expose
    private String country;
    @Expose
    private String zip;

    @Expose
    private String homePhone;
    @Expose
    private String cellPhone;

    @Expose
    private PatientHistory patientHistory;
    @Expose
    private LabResults labResults;
    @Expose
    private Procedure procedure;
    @Expose
    private RecentHistory recentHistory;


    public Patient () {
        // De serialize
    }

    public Patient(String patientId, String firstName, String lastName, String preferredName, Date date, Date dateOfBirth, String address, String city, String country, String zip, String homePhone, String cellPhone, PatientHistory patientHistory, LabResults labResults, Procedure procedure, RecentHistory recentHistory) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferredName = preferredName;
        this.date = date;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.patientHistory = patientHistory;
        this.labResults = labResults;
        this.procedure = procedure;
        this.recentHistory = recentHistory;
    }

    public Patient(String patientId, String firstName, String lastName, String preferredName, Date date, Date dateOfBirth, String address, String city, String country, String zip, String homePhone, String cellPhone) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferredName = preferredName;
        this.date = date;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
    }

    // Getter and Setter
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public LabResults getLabResults() {
        return labResults;
    }

    public void setLabResults(LabResults labResults) {
        this.labResults = labResults;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public RecentHistory getRecentHistory() {
        return recentHistory;
    }

    public void setRecentHistory(RecentHistory recentHistory) {
        this.recentHistory = recentHistory;
    }
}
