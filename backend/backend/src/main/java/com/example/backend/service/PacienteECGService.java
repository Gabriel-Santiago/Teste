package com.example.backend.service;

import com.example.backend.model.PacienteECG;
import com.example.backend.repository.PacienteECGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteECGService {

    @Autowired
    PacienteECGRepository pacienteECGRepository;

    public Object save(int id, PacienteECG entity){
        if(id != 0){
            entity.setId(id);
        }
        return pacienteECGRepository.save(entity);
    }

    public Optional<PacienteECG> find(int id){
        if(id < 1){
            return null;
        }
        Optional<PacienteECG> pacienteECG = pacienteECGRepository.findById(id);

        return Optional.ofNullable(pacienteECG.orElse(null));
    }

    public List<PacienteECG> findAll(){
        return pacienteECGRepository.findAll();
    }

    public void delete(int id){
        Optional<PacienteECG> pacienteECGOptional = find(id);
        pacienteECGOptional.ifPresent(pacienteECG -> pacienteECGRepository.delete(pacienteECG));
    }

    public void update(int id, PacienteECG entity){
        entity.setId(id);
        pacienteECGRepository.save(entity);
    }

    public List<PacienteECG> findByFrequenciaCardiaca(int frequenciaCardiaca){
        return pacienteECGRepository.findByFrequenciaCardiaca(frequenciaCardiaca);
    }

    public PacienteECG findByEstado(String str){
        return pacienteECGRepository.findByEstado(str);
    }

    public PacienteECG findByCidade(String str){
        return pacienteECGRepository.findByCidade(str);
    }
}
