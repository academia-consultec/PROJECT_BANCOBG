package com.consultec.org.banktest.services.interfaces;

import com.consultec.org.banktest.modelo.ClienteDTO;

import java.util.List;

public interface IClienteService {

    // Recuperar toda la lista de clientes
    List<ClienteDTO> fetchClienteList();

}
