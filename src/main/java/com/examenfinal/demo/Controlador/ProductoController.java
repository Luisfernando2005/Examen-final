package com.examenfinal.demo.Controlador;

import com.example.inventario.entity.Producto;
import com.example.inventario.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {


private final ProductoService productoService;


public ProductoController(ProductoService productoService) {
this.productoService = productoService;
}


@GetMapping
public List<Producto> all() { return productoService.findAll(); }


@GetMapping("/{id}")
public ResponseEntity<Producto> get(@PathVariable Long id) {
return productoService.findById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}


@PostMapping
public Producto create(@RequestBody Producto p) { return productoService.save(p); }


@PutMapping("/{id}")
public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto p) {
return productoService.findById(id).map(existing -> {
existing.setNombre(p.getNombre());
existing.setDescripcion(p.getDescripcion());
existing.setProveedor(p.getProveedor());
existing.setVieneDeBodega(p.getVieneDeBodega());
existing.setCantidadActual(p.getCantidadActual());
productoService.save(existing);
return ResponseEntity.ok(existing);
}).orElse(ResponseEntity.notFound().build());
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
productoService.delete(id);
return ResponseEntity.noContent().build();
}
}
