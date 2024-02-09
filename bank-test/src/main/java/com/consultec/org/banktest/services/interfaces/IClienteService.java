package com.consultec.org.banktest.services.interfaces;

import com.consultec.org.banktest.modelo.ClienteDTO;
import com.consultec.org.banktest.modelo.ResponseDTO;

import java.util.List;

public interface IClienteService<t extends ResponseDTO> {

    // Recuperar toda la lista de clientes
    List<t> fetchClienteList();
    t fetchClientebyId(Long id);

}
