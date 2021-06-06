package com.farmou.farmaciaCO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmou.farmaciaCO.model.Medicamentos;

public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {
	public List<Medicamentos> findAllByNomeContainingIgnoreCase (String nome);

}
