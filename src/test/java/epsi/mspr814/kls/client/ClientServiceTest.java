package epsi.mspr814.kls.client;

import epsi.mspr814.kls.client.model.Client;
import epsi.mspr814.kls.client.repository.ClientRepository;
import epsi.mspr814.kls.client.service.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ClientServiceTest{

    @Mock
    private ClientRepository clientRepository;

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
        Client client = new Client(null, "John Doe", "john.doe@example.com", "1234567890", "123 Main St");

        when(clientRepository.save(client)).thenReturn(new Client(new UUID(12,15), "John Doe", "john.doe@example.com", "1234567890", "123 Main St"));


        Client savedClient = clientService.createClient(client);
        assertNotNull(savedClient.getUuid());
        assertEquals("John Doe", savedClient.getName());
    }
}
