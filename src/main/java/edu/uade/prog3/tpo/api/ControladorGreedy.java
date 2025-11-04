package edu.uade.prog3.tpo.api;

import edu.uade.prog3.tpo.servicio.ServicioGreedy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greedy")
public class ControladorGreedy {

    private final ServicioGreedy ServicioGreedy;

    public ControladorGreedy(ServicioGreedy ServicioGreedy) {
        this.ServicioGreedy = ServicioGreedy;
    }

    @GetMapping("/cargar")
    public ResponseEntity<Map<String, Object>> ejecutar(
            @RequestParam String depositoId,
            @RequestParam(required = false) String vehiculoId,
            @RequestParam(required = false) String destino
    ) {
        Map<String, Object> resultado = ServicioGreedy.ejecutarGreedy(depositoId, vehiculoId, destino);
        return ResponseEntity.ok(resultado);
    }
}
