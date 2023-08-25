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

    public PacienteECG find(int id){
        if(id < 1){
            return null;
        }
        Optional<PacienteECG> pacienteECG = pacienteECGRepository.findById(id);

        if(pacienteECG.isPresent()){
            return pacienteECG.get();
        }
        return null;
    }

    public List<PacienteECG> findAll(){
        return pacienteECGRepository.findAll();
    }

    public void delete(int id){
        PacienteECG pacienteECG = find(id);
        pacienteECGRepository.delete(pacienteECG);
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
