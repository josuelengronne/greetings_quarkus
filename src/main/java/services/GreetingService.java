package services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

import repos.GreetingRepo;
import model.Greeting;

@ApplicationScoped
public class GreetingService {

    @Inject
    private GreetingRepo greetingRepo;

    public List<Greeting> getLatest(int limit) {
        return greetingRepo.getLatest(limit);
    }

    public void addGreeting(Greeting greeting) {
        greetingRepo.addGreeting(greeting);
    }
}