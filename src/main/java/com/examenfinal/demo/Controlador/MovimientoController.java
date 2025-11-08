package com.examenfinal.demo.Controlador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {


private final MovimientoService movimientoService;


public MovimientoController(MovimientoService movimientoService) {
this.movimientoService = movimientoService;
}


@GetMapping
public List<Movimiento> all() { return movimientoService.findAll(); }


@PostMapping
public ResponseEntity<?> create(@RequestBody MovimientoRequest req) {
try {
Movimiento m = new Movimiento();
Producto p = new Producto();
p.setId(req.getProductoId());
m.setProducto(p);
m.setTipo(req.getTipo());
m.setCantidad(req.getCantidad());
m.setObservacion(req.getObservacion());
// proveedor y bodega opcionales (puedes resolver por id si envías objetos completos)
Movimiento saved = movimientoService.createMovimiento(m);
return ResponseEntity.ok(saved);
} catch (RuntimeException ex) {
return ResponseEntity.badRequest().body(ex.getMessage());
}
}
}
