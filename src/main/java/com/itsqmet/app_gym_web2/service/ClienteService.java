package com.itsqmet.app_gym_web2.service;

import com.itsqmet.app_gym_web2.entity.Cliente;
import com.itsqmet.app_gym_web2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    //instancio para encriptar constraseña
    /* @Autowired
    private PassworEncoder passworEncoder;*/
    //Lista de clientes
    public List<Cliente> allClientes(){
        return clienteRepository.findAll();
    }
    //Mostrar por cedula para filtrar en una busqueda
    public List<Cliente> buscarPorCedula(String cedula){
        if (cedula==null||cedula.isEmpty()){
            return clienteRepository.findAll();
        }else{
            return clienteRepository.findByCedula(cedula);
        }
    }
    //buscar por id(para actualizar y eliminar)
    public Optional<Cliente> buscarClienteId(Long id){
        return clienteRepository.findById(id);
    }
    //Guardar Cliente
    public Cliente guardarCliente(Cliente cliente){
        //encripto
        //añado encriptado al objeto
        return clienteRepository.save(cliente);
    }
    //Eliminar Cliente
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
