package com.consultec.org.banktest.controllers;

import com.consultec.org.banktest.exceptions.HTTPErrorCodeException;
import com.consultec.org.banktest.modelo.ClienteDTO;
import com.consultec.org.banktest.modelo.ErrorDTO;
import com.consultec.org.banktest.modelo.ResponseDTO;
import com.consultec.org.banktest.services.ClienteServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banco")
public class ClienteController {

    @Autowired
    ClienteServiceImple serviceCliente;

    @GetMapping("/healthCheck")
    private String healthCheck() {
        return "Saludable";
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> findCliente() {
        List<ClienteDTO> clientes = serviceCliente.fetchClienteList();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ResponseDTO> findClientebyID(@PathVariable Long id) {
        ClienteDTO clientes = serviceCliente.fetchClientebyId(id);
        return ResponseEntity.ok(clientes);
    }


}
