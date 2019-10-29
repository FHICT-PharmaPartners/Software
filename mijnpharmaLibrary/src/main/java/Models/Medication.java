package Models;

public class Medication {
    private Medicine medicine;
    private int dosage;
    private int duration;

    public Medication(Medicine medicine, int dosage, int duration) {
        this.medicine = medicine;
        this.dosage = dosage;
        this.duration = duration;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
