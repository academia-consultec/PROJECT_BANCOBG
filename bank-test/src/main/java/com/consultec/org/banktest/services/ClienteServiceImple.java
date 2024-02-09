package com.consultec.org.banktest.services;

import com.consultec.org.banktest.exceptions.HTTPErrorCodeException;
import com.consultec.org.banktest.exceptions.NotFoundErrorException;
import com.consultec.org.banktest.modelo.ClienteDTO;
import com.consultec.org.banktest.repository.IClienteRepository;
import com.consultec.org.banktest.repository.entity.ClienteEntity;
import com.consultec.org.banktest.services.interfaces.IClienteService;
import com.consultec.org.banktest.services.mapping.ClienteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImple implements IClienteService {

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public List<ClienteDTO> fetchClienteList() {
        List<ClienteDTO> clienteDTO = new ArrayList<>();
        iClienteRepository.findAll().forEach(clienteEntity -> clienteDTO.add(ClienteMap.mapCliente(clienteEntity)));
        return clienteDTO;
    }

    @Override
    public ClienteDTO fetchClientebyId(Long idCliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        Optional<ClienteEntity>  clienteEntity = iClienteRepository.findById(idCliente);
        if(!clienteEntity.isEmpty()){
            return ClienteMap.mapCliente(clienteEntity.get());
        }else{
            throw new NotFoundErrorException(NotFoundErrorException.ListErrorCode.NOTFOUND, "Cliente No encontrado");
        }

    }
}
