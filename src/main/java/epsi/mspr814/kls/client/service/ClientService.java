package epsi.mspr814.kls.client.service;

import epsi.mspr814.kls.client.model.Client;
import epsi.mspr814.kls.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
}