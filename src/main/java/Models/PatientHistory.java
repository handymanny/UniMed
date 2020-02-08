package Models;

public class PatientHistory {

    // 0 = Self
    // 1 = Mother
    // 2 = Father

    private int heartDisease;
    private int anemia;
    private int arthritis;
    private int asthma;

    private int diabetes;
    private int scarletFever;
    private int stroke;
    private int muscularDystrophy;
    private int polio;

    private int epilepsy;
    private int tuberculosis;
    private int headaches;
    private int rheumatism;
    private int multipleSclerosis;

    private int highBloodPressure;
    private int hepatitis;
    private int cancer;
    private int kidneyDisorder;

    public PatientHistory(int heartDisease, int anemia, int arthritis, int asthma, int diabetes, int scarletFever, int stroke, int muscularDystrophy, int polio, int epilepsy, int tuberculosis, int headaches, int rheumatism, int multipleSclerosis, int highBloodPressure, int hepatitis, int cancer, int kidneyDisorder) {
        this.heartDisease = heartDisease;
        this.anemia = anemia;
        this.arthritis = arthritis;
        this.asthma = asthma;
        this.diabetes = diabetes;
        this.scarletFever = scarletFever;
        this.stroke = stroke;
        this.muscularDystrophy = muscularDystrophy;
        this.polio = polio;
        this.epilepsy = epilepsy;
        this.tuberculosis = tuberculosis;
        this.headaches = headaches;
        this.rheumatism = rheumatism;
        this.multipleSclerosis = multipleSclerosis;
        this.highBloodPressure = highBloodPressure;
        this.hepatitis = hepatitis;
        this.cancer = cancer;
        this.kidneyDisorder = kidneyDisorder;
    }

    public int getHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(int heartDisease) {
        this.heartDisease = heartDisease;
    }

    public int getAnemia() {
        return anemia;
    }

    public void setAnemia(int anemia) {
        this.anemia = anemia;
    }

    public int getArthritis() {
        return arthritis;
    }

    public void setArthritis(int arthritis) {
        this.arthritis = arthritis;
    }

    public int getAsthma() {
        return asthma;
    }

    public void setAsthma(int asthma) {
        this.asthma = asthma;
    }

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getScarletFever() {
        return scarletFever;
    }

    public void setScarletFever(int scarletFever) {
        this.scarletFever = scarletFever;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public int getMuscularDystrophy() {
        return muscularDystrophy;
    }

    public void setMuscularDystrophy(int muscularDystrophy) {
        this.muscularDystrophy = muscularDystrophy;
    }

    public int getPolio() {
        return polio;
    }

    public void setPolio(int polio) {
        this.polio = polio;
    }

    public int getEpilepsy() {
        return epilepsy;
    }

    public void setEpilepsy(int epilepsy) {
        this.epilepsy = epilepsy;
    }

    public int getTuberculosis() {
        return tuberculosis;
    }

    public void setTuberculosis(int tuberculosis) {
        this.tuberculosis = tuberculosis;
    }

    public int getHeadaches() {
        return headaches;
    }

    public void setHeadaches(int headaches) {
        this.headaches = headaches;
    }

    public int getRheumatism() {
        return rheumatism;
    }

    public void setRheumatism(int rheumatism) {
        this.rheumatism = rheumatism;
    }

    public int getMultipleSclerosis() {
        return multipleSclerosis;
    }

    public void setMultipleSclerosis(int multipleSclerosis) {
        this.multipleSclerosis = multipleSclerosis;
    }

    public int getHighBloodPressure() {
        return highBloodPressure;
    }

    public void setHighBloodPressure(int highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public int getHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(int hepatitis) {
        this.hepatitis = hepatitis;
    }

    public int getCancer() {
        return cancer;
    }

    public void setCancer(int cancer) {
        this.cancer = cancer;
    }

    public int getKidneyDisorder() {
        return kidneyDisorder;
    }

    public void setKidneyDisorder(int kidneyDisorder) {
        this.kidneyDisorder = kidneyDisorder;
    }
}
