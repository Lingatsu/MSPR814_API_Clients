package epsi.mspr814.kls.client;

import epsi.mspr814.kls.client.model.Person;
import epsi.mspr814.kls.client.repository.PersonRepository;
import epsi.mspr814.kls.client.service.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private ClientService clientService;

    private AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void testCreateClient() {
        Person person = new Person(null, "John Doe", "john.doe@example.com", "1234567890", "123 Main St");

        when(personRepository.save(person)).thenReturn(new Person(new UUID(12,15), "John Doe", "john.doe@example.com", "1234567890", "123 Main St"));


        Person savedPerson = clientService.createClient(person);
        assertNotNull(savedPerson.getUuid());
        assertEquals("John Doe", savedPerson.getName());
    }
}
