package repos;

import java.util.List;

import model.Greeting;

public interface GreetingRepo {
    void addGreeting(Greeting greeting);
    List<Greeting> getLatest(int limit);
}