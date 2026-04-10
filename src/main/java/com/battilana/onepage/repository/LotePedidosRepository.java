package com.battilana.onepage.repository;

import com.battilana.onepage.entity.LotePedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LotePedidosRepository extends JpaRepository<LotePedidos, Integer> {

    List<LotePedidos> findByEstadoTrue();
}
