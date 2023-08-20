package com.example.backend.repository;

import com.example.backend.model.PacienteECG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteECGRepository extends JpaRepository<PacienteECG, Integer> {

    List<PacienteECG> findByFrequenciaCardiaca(int frequenciaCardiaca);

    PacienteECG findByEstado(String estado);

    PacienteECG findByCidade(String cidade);
}
