package com.gestor.demo.controller;

import com.gestor.demo.model.Viaje;
import com.gestor.demo.service.ViajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ViajeController {
    //crear metodo get para obtener todo el listado de viajes

    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping("/viajes")
    public List<Viaje> obtenerViajes() {
        return viajeService.obtenerViajes();

    }

    @PostMapping("/viaje")
    public ResponseEntity<Viaje> crearViaje(@RequestBody Viaje viaje) {
        Viaje viajeCreado = viajeService.crearViaje(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeCreado);
    }

    @PutMapping("/viaje")
    public ResponseEntity<Viaje> actualizarViaje(@RequestBody Viaje viaje) {
        Viaje viajeActualizado = viajeService.actualizarViaje(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeActualizado);
    }

    @PatchMapping("/viaje")
    public ResponseEntity<Viaje> actualizarPrecio(@RequestBody Viaje viaje) {
        Viaje viajeActualizado = viajeService.actualizarPrecio(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeActualizado);
    }

    @DeleteMapping("/viaje")
    public ResponseEntity<Viaje> eliminarViaje(@RequestParam Long Id) {
        Viaje viajeEliminado = viajeService.eliminarViaje(Id);
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeEliminado);
    }
}
