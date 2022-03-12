package repos.memory;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.ArrayList;

import repos.GreetingRepo;
import model.Greeting;

@ApplicationScoped
public class GreetingRepoMemory implements GreetingRepo {

    private List<Greeting> memory = new ArrayList();

    public void addGreeting(Greeting greeting) {
        this.memory.add(greeting);
    }

    public List<Greeting> getLatest(int limit) {
        int size = this.memory.size();
        if (limit >= size) {
            return new ArrayList(memory);
        }
        return this.memory.subList(size - limit, size );
    }
}