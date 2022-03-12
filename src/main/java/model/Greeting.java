package model;

import java.time.LocalDateTime;

public class Greeting {
    private String name;
    private LocalDateTime date;

    public Greeting() {
    }

    public Greeting(
        String name,
        LocalDateTime date
    ) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}