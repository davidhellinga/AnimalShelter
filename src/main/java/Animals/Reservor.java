package Animals;

import java.time.LocalDate;

public class Reservor {
    private String Name;
    private LocalDate ReservedAt;

    public Reservor(String name, LocalDate reservedAt) {
        Name = name;
        ReservedAt = reservedAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getReservedAt() {
        return ReservedAt;
    }

    public void setReservedAt(LocalDate reservedAt) {
        ReservedAt = reservedAt;
    }
}
