package Animals;


import java.time.LocalDate;
import java.util.UUID;

public class Animal {
    private String Name;
    private Gender Gender;
    private Reservor ReservedBy;

    public Animal(String name, Gender gender) {
        this.Name = name;
        this.Gender = gender;
    }

    private void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    private void setGender(Gender gender) {
        Gender = gender;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setReserver(Reservor reservor) {
        ReservedBy = reservor;
    }

    public Reservor getReserver() {
        return ReservedBy;
    }

    public boolean Reserve(String reservedBy) {
        if (this.ReservedBy == (null)) {
            this.ReservedBy = new Reservor(reservedBy, LocalDate.now());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if (this.ReservedBy != (null)) {
            reserved = String.format("reserved by %s", ReservedBy.getName());
        }
        return String.format("%s, %s, %s", this.Name, this.Gender, reserved);
    }
}
