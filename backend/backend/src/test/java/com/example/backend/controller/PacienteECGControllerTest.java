package com.example.backend.controller;

import com.example.backend.model.PacienteECG;
import com.example.backend.service.PacienteECGService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PacienteECGControllerTest {

    private static final int ID = 1;
    private static final String NOME = "Gabriel";
    private static final String CIDADE = "Canavieiras";
    private static final String ESTADO = "Bahia";
    private static final int FREQUENCIACARDIACA = 90;

    @InjectMocks
    private PacienteECGController controller;

    @Mock
    private PacienteECGService service;

    private PacienteECG pacienteECG;

    public void start(){

        pacienteECG = new PacienteECG(ID, NOME, CIDADE, ESTADO, FREQUENCIACARDIACA);
    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        start();
    }

    @Test
    public void quandoProcurarIdRetorneSucesso(){
        when(service.find(anyInt())).thenReturn(pacienteECG);

        ResponseEntity<PacienteECG> response = controller.find(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PacienteECG.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(CIDADE, response.getBody().getCidade());
        assertEquals(ESTADO, response.getBody().getEstado());
        assertEquals(FREQUENCIACARDIACA, response.getBody().getFrequenciaCardiaca());
    }

    @Test
    public void quandoProcurarIdRetorneNaoEncontrado(){
        when(service.find(anyInt())).thenReturn(null);

        ResponseEntity<PacienteECG> response = controller.find(ID);

        assertNotNull(response);
        assertNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void quandoProcurarCidadeRetorneSucesso(){
        when(service.findByCidade(anyString())).thenReturn(pacienteECG);

        ResponseEntity<PacienteECG> response = controller.findByCidade(CIDADE);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PacienteECG.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(CIDADE, response.getBody().getCidade());
        assertEquals(ESTADO, response.getBody().getEstado());
        assertEquals(FREQUENCIACARDIACA, response.getBody().getFrequenciaCardiaca());
    }

    @Test
    public void quandoProcurarCidadeRetorneNaoEncontrado(){
        when(service.findByCidade(null)).thenReturn(null);

        ResponseEntity<PacienteECG> response = controller.findByCidade(CIDADE);

        assertNotNull(response);
        assertNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void quandoProcurarEstadoRetorneSucesso(){
        when(service.findByEstado(anyString())).thenReturn(pacienteECG);

        ResponseEntity<PacienteECG> response = controller.findByEstado(ESTADO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PacienteECG.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(CIDADE, response.getBody().getCidade());
        assertEquals(ESTADO, response.getBody().getEstado());
        assertEquals(FREQUENCIACARDIACA, response.getBody().getFrequenciaCardiaca());
    }

    @Test
    public void quandoProcurarEstadoRetorneNaoEncontrado(){
        when(service.findByEstado(null)).thenReturn(null);

        ResponseEntity<PacienteECG> response = controller.findByEstado(ESTADO);

        assertNotNull(response);
        assertNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void quandoProcurarFrequenciaRetorneSucesso(){
        when(service.findByFrequenciaCardiaca(90)).thenReturn(null);

        ResponseEntity<List<PacienteECG>> response = controller.findByFrequenciaCardiaca(FREQUENCIACARDIACA);

        assertNotNull(response);
    }

    @Test
    public void quandoCriarRetorneSucesso(){
        controller.save(pacienteECG);

        verify(service).save(0, pacienteECG);
    }

    @Test
    public void quandoProcurarTodosRetorneSucesso(){
        when(service.findAll()).thenReturn(Arrays.asList(pacienteECG));

        ResponseEntity<List<PacienteECG>> response = controller.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(NOME, response.getBody().get(0).getNome());
        assertEquals(CIDADE, response.getBody().get(0).getCidade());
        assertEquals(ESTADO, response.getBody().get(0).getEstado());
        assertEquals(FREQUENCIACARDIACA, response.getBody().get(0).getFrequenciaCardiaca());
    }

    @Test
    public void quandoAtualizarRetorneSucesso(){
        doNothing().when(service).update(ID, pacienteECG);

        controller.update(ID, pacienteECG);

        verify(service).save(ID, pacienteECG);
    }

    @Test
    public void quandoApagarRetorneSucesso(){
        doNothing().when(service).delete(ID);

        controller.delete(ID);

        verify(service).delete(ID);
    }
}
