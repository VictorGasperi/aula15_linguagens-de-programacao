package entities;

public class Bimester {
    
    private int number;
    private double grade;
    private int absence;

    public Bimester(int number) {
        this.number = number;
    }
    
    public Bimester(int number, double grade, int absence) {
        this.number = number;
        this.grade = grade;
        this.absence = absence;
    }

    

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public int getAbsence() {
        return absence;
    }
    public void setAbsence(int absence) {
        this.absence = absence;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
