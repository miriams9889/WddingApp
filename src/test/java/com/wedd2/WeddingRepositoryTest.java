package com.wedd2;


import com.wedd2.event.Wedding;
import com.wedd2.repository.WeddingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class WeddingRepositoryTest {
    @Autowired private WeddingRepository repo;

    @Test
    public void testAddNew(){
        Wedding wedding = new Wedding();
        wedding.setLocation("ImperialInn");
        wedding.setDesign("Blue");
        wedding.setReservationName("Maria Vlad");
        wedding.setContactName("Andrei Vlad");
        wedding.setPhoneNr("0765324589");

        Wedding savedWedding = repo.save(wedding);


        Assertions.assertThat(savedWedding).isNotNull();
        Assertions.assertThat(savedWedding.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Wedding> events = repo.findAll();
        Assertions.assertThat(events).hasSizeGreaterThan(0);

        for (Wedding wedding : events){
            System.out.println(wedding);
        }
    }

    @Test
    public void testUpdateEvent(){
        Integer eventId = 1;
        Optional<Wedding> optionalEvent = repo.findById(eventId);
        Wedding wedding = optionalEvent.get();
        wedding.setDesign("Green");
        repo.save(wedding);

        Wedding updatedWedding = repo.findById(eventId).get();
        Assertions.assertThat(updatedWedding.getDesign()).isEqualTo("Green");

    }

    @Test
    public void testGet(){
        Integer eventId = 2;
        Optional<Wedding> optionalEvent = repo.findById(eventId);
        Assertions.assertThat(optionalEvent).isPresent();
        System.out.println(optionalEvent.get());


    }

    @Test
    public void testDelete(){
        Integer eventId = 2;
        repo.deleteById(eventId);
        Optional<Wedding> optionalEvent = repo.findById(eventId);
        Assertions.assertThat(optionalEvent).isNotPresent();


    }
}
