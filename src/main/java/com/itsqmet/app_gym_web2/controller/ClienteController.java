package com.itsqmet.app_gym_web2.controller;

import com.itsqmet.app_gym_web2.entity.Cliente;
import com.itsqmet.app_gym_web2.entity.Servicios;
import com.itsqmet.app_gym_web2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    //leer todos los clientes
    @GetMapping("/leer")
    public List<Cliente> mostrarClientes() {
        return clienteService.allClientes();
    }

    //guardar nuevo cliente
    @PostMapping("/guardar")
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        cliente.setRol("CLIENTE");
        return clienteService.guardarCliente(cliente);
    }

    //buscar cliente por id
    @GetMapping("/buscar/{id}")
    public Optional<Cliente> buscarClienteId(@PathVariable Long id) {
        return clienteService.buscarClienteId(id);
    }

    //actualizar cliente
    @PutMapping("/actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteService.buscarClienteId(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteExistente = clienteOptional.get();
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setCedula(cliente.getCedula());
            clienteExistente.setAltura(cliente.getAltura());
            clienteExistente.setPeso(cliente.getPeso());
            clienteExistente.setGenero(cliente.getGenero());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setImc(cliente.getImc());
            clienteExistente.setFechaNacimiento(cliente.getFechaNacimiento());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setPassword(cliente.getPassword());
            return clienteService.guardarCliente(clienteExistente);
        }
        return null;
    }

    //eliminar cliente
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }

}
