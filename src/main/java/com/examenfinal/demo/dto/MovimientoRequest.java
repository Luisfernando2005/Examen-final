package com.examenfinal.demo.dto;

public class MovimientoRequest {
private Long productoId;
private String tipo; // 'entrada','salida','ajuste'
private Integer cantidad;
private String observacion;


// getters y setters
public Long getProductoId() { return productoId; }
public void setProductoId(Long productoId) { this.productoId = productoId; }
public String getTipo() { return tipo; }
public void setTipo(String tipo) { this.tipo = tipo; }
public Integer getCantidad() { return cantidad; }
public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
public String getObservacion() { return observacion; }
public void setObservacion(String observacion) { this.observacion = observacion; }
}
