package repos.persistent;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

import repos.GreetingRepo;
import model.Greeting;
import repos.persistent.model.GreetingPersistent;

@ApplicationScoped
public class GreetingRepoPersistent implements GreetingRepo {
    @Inject
    protected EntityManager em; 

    @Transactional
    public void addGreeting(Greeting greeting) {
        GreetingPersistent persistent = new GreetingPersistent(greeting);
        persistent.setEntryTimeStamp(LocalDateTime.now());
        em.persist(persistent);
    }

    public List<Greeting> getLatest(int limit) {
        Query query = em.createNamedQuery("Greeting.findLatest", GreetingPersistent.class);
        query.setMaxResults(limit);
        List<GreetingPersistent> persistents = query.getResultList();
        return persistents.stream()
            .map(GreetingPersistent::toModel)
            .collect(Collectors.toList());
    }
}