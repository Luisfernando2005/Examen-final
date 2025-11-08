package com.examenfinal.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.Movimiento;


public interface MovimientoRepository extends JpaRepository<Movimiento, Long> { }