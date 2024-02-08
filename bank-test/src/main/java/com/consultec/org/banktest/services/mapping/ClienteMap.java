package com.consultec.org.banktest.services.mapping;

import com.consultec.org.banktest.modelo.ClienteDTO;
import com.consultec.org.banktest.repository.entity.ClienteEntity;

public class ClienteMap {

    public static ClienteDTO mapCliente(ClienteEntity clienteEntity) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setApellido(clienteEntity.getApellido());
        clienteDTO.setDireccion(clienteEntity.getDireccion());
        clienteDTO.setEdad(clienteEntity.getEdad());
        clienteDTO.setId(clienteEntity.getId());
        clienteDTO.setEmail(clienteEntity.getEmail());
        clienteDTO.setEstado(clienteEntity.getEstado());
        clienteDTO.setNombre(clienteEntity.getNombre());
        clienteDTO.setTelefono(clienteEntity.getTelefono());
        clienteDTO.setSexo(clienteEntity.getSexo());
        clienteDTO.setId_documento(clienteEntity.getId_documento());
        clienteDTO.setTipo_documento(clienteEntity.getTipo_documento());
        return clienteDTO;
    }
}
