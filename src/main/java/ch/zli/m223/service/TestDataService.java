package ch.zli.m223.service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Category;
import ch.zli.m223.model.Entry;
import ch.zli.m223.model.Tag;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {
    @Inject
    EntityManager entityManager;

    @Transactional
    void generateTestData(@Observes StartupEvent startupEvent) {
    //categories
    var projecACategory = new Category();
    projecACategory.setTitle("Project A");
    entityManager.persist(projecACategory);

    var projecBCategory = new Category();
    projecBCategory.setTitle("Project B");
    entityManager.persist(projecBCategory);


    var projecCCategory = new Category();
    projecCCategory.setTitle("Project C");
    entityManager.persist(projecCCategory);

    // Tags
    var programmingTag = new Tag();
    programmingTag.setTitle("Programming");
    entityManager.persist(programmingTag);

    var debuggingTag = new Tag();
    debuggingTag.setTitle("Debugging");
    entityManager.persist(debuggingTag);

    var meetingTag = new Tag();
    meetingTag.setTitle("Meeting");
    entityManager.persist(meetingTag);

    //entries
    var firstEntry = new Entry();
    firstEntry.setCategory(projecACategory);
    firstEntry.setTags(new HashSet<>(Arrays.asList(programmingTag, debuggingTag)));
    firstEntry.setCheckIn(LocalDateTime.now().minusHours(3));
    firstEntry.setCheckOut(LocalDateTime.now().plusHours(1));
    entityManager.persist(firstEntry);

    var secondEntry = new Entry();
    secondEntry.setCategory(projecBCategory);
    secondEntry.setTags(Set.of(meetingTag));
    secondEntry.setCheckIn(LocalDateTime.now().minusHours(2));
    secondEntry.setCheckOut(LocalDateTime.now());
    entityManager.persist(secondEntry);
    



    }
}
