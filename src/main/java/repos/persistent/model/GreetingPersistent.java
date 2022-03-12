package repos.persistent.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;

import model.Greeting;

@Entity
@NamedQuery(name = "Greeting.findLatest",
      query = "SELECT g FROM GreetingPersistent g ORDER BY g.entryTimeStamp DESC")
public class GreetingPersistent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime date;
    private LocalDateTime entryTimeStamp;

    protected GreetingPersistent() {
    }

    public GreetingPersistent(Greeting greeting) {
        this.name = greeting.getName();
        this.date = greeting.getDate();
    }

    public Greeting toModel() {
        return new Greeting(name, date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getEntryTimeStamp() {
        return this.entryTimeStamp;
    }

    public void setEntryTimeStamp(LocalDateTime entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }
}