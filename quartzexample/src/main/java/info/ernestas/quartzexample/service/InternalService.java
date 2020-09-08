package info.ernestas.quartzexample.service;

import info.ernestas.quartzexample.entity.Person;
import info.ernestas.quartzexample.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class InternalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InternalService.class);

    private final PersonRepository personRepository;

    @Transactional
    public void firstService() {
        LOGGER.info("Called first service");

        Person person = new Person();
        person.setId(new Random().nextInt(1000));
        person.setName(UUID.randomUUID().toString());
        personRepository.save(person);
    }

    public void secondService() {
        LOGGER.info("Called second service");
    }

}
