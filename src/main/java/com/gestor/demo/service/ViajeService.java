package com.gestor.demo.service;

import com.gestor.demo.model.Viaje;
import com.gestor.demo.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ViajeService {
    //inyección de dependencias - inyectar el repositorio para poder utilizar sus métodos
    private final ViajeRepository viajeRepository;

    public ViajeService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    public List<Viaje> obtenerViajes() {
        return viajeRepository.findAll();
    }

    public Viaje crearViaje(Viaje viaje){
        return viajeRepository.save(viaje);
    }

    public Viaje actualizarViaje(Viaje viaje){
        return viajeRepository.save(viaje);
    }

    public Viaje actualizarPrecio(Viaje viaje) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(viaje.getId());
        if (optionalViaje.isPresent()) {
            Viaje viajeActualizado = optionalViaje.get();
            viajeActualizado.setPrecioUSD(viaje.getPrecioUSD());
            viajeRepository.save(viajeActualizado);
            return viajeActualizado;
        }
        return null;
    }

    public Viaje eliminarViaje(Long id) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(id);
        if (optionalViaje.isPresent()) {
            Viaje viajeEliminado = optionalViaje.get();
            viajeRepository.delete(viajeEliminado);
            return viajeEliminado;
        }
        return null;
    }
}