package com.example.backend.controller;

import com.example.backend.model.PacienteECG;
import com.example.backend.service.PacienteECGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteECGController {
    
    @Autowired
    PacienteECGService service;
    
    @GetMapping
    public ResponseEntity<List<PacienteECG>> find(@PathVariable("id") int id){
        return new ResponseEntity<List<PacienteECG>>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/estado")
    public ResponseEntity<PacienteECG> findByEstado(@PathVariable("estado") String estado){
        PacienteECG pacienteECG = service.findByEstado(estado);

        if(pacienteECG != null){
            return new ResponseEntity<PacienteECG>(pacienteECG, HttpStatus.OK);
        }else{
            return new ResponseEntity<PacienteECG>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/cidade")
    public ResponseEntity<PacienteECG> findByCidade(@PathVariable("cidade") String cidade){
        PacienteECG pacienteECG = service.findByCidade(cidade);

        if(pacienteECG != null){
            return new ResponseEntity<PacienteECG>(pacienteECG, HttpStatus.OK);
        }else{
            return new ResponseEntity<PacienteECG>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/frequencia")
    public ResponseEntity<List<PacienteECG>> findByFrequenciaCardiaca(@PathVariable("frequencia") int frequenciaCardiaca){
        return new ResponseEntity<List<PacienteECG>>(service.findByFrequenciaCardiaca(frequenciaCardiaca), HttpStatus.OK);
    }

    @PostMapping()
    public void save(@RequestBody PacienteECG pacienteECG){
        service.save(0, pacienteECG);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id") int id, @RequestBody PacienteECG pacienteECG){
        service.save(id, pacienteECG);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
