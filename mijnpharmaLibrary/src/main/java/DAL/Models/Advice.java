package DAL.Models;

import java.time.LocalDateTime;

public class Advice {
    private LocalDateTime date;
    private String description;

    public Advice(LocalDateTime date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
