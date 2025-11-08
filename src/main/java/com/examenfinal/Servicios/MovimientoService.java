package com.examenfinal.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class MovimientoService {


private final MovimientoRepository movimientoRepository;
private final ProductoRepository productoRepository;


public MovimientoService(MovimientoRepository movimientoRepository, ProductoRepository productoRepository) {
this.movimientoRepository = movimientoRepository;
this.productoRepository = productoRepository;
}


public List<Movimiento> findAll() { return movimientoRepository.findAll(); }


@Transactional
public Movimiento createMovimiento(Movimiento movimiento) {
// validar producto
Producto prod = productoRepository.findById(movimiento.getProducto().getId())
.orElseThrow(() -> new RuntimeException("Producto no encontrado"));


int cantidadActual = prod.getCantidadActual() == null ? 0 : prod.getCantidadActual();
int delta = movimiento.getCantidad();


switch (movimiento.getTipo()) {
case "entrada":
cantidadActual += delta;
break;
case "salida":
cantidadActual -= delta;
if (cantidadActual < 0) throw new RuntimeException("Stock insuficiente");
break;
case "ajuste":
// para ajuste, se interpreta que cantidad es el nuevo valor absoluto
cantidadActual = delta;
break;
default:
throw new RuntimeException("Tipo de movimiento inválido");
}


prod.setCantidadActual(cantidadActual);
productoRepository.save(prod);


movimiento.setProducto(prod);
return movimientoRepository.save(movimiento);
}
}
