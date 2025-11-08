package com.examenfinal.demo.Repositorio;

import com.example.inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Long> { }