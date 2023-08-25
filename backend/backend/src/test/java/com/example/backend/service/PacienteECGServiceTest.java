package com.example.backend.service;

import com.example.backend.model.PacienteECG;
import com.example.backend.repository.PacienteECGRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class PacienteECGServiceTest {

    private static final int ID = 1;
    private static final String NOME = "Gabriel";
    private static final String CIDADE = "Canavieiras";
    private static final String ESTADO = "Bahia";
    private static final int FREQUENCIACARDIACA = 90;

    @InjectMocks
    private PacienteECGService service;

    @Mock
    private PacienteECGRepository repository;

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
    public void retornaNuloIdMenorQueZero(){
        PacienteECG response = service.find(0);

        assertNull(response);
    }

    @Test
    public void quandoSalvarVerificarSucesso() throws ParseException, IOException{
        when(repository.save(any())).thenReturn(pacienteECG);

        service.save(1, pacienteECG);

        verify(repository).save(any());
    }

    @Test
    public void quandoAtualizarVerificarSucesso() throws ParseException, IOException{
        when(repository.save(any())).thenReturn(pacienteECG);

        service.update(ID, pacienteECG);

        verify(repository).save(any());
    }

    @Test
    public void quandoProcurarPorIdEntaoRetorneNuloSeOptionalNaoForPresente(){
        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        PacienteECG response = service.find(ID);

        assertNull(response);
    }

    @Test
    public void quandoApagarVerificarSucesso(){
        when(repository.findById(anyInt())).thenReturn(Optional.of(pacienteECG));
        doNothing().when(repository).delete(pacienteECG);

        service.delete(ID);

        verify(repository).findById(anyInt());
        verify(repository).delete(any());
    }

    @Test
    public void quandoProcurarTodosRetorneUmaLista(){
        when(repository.findAll()).thenReturn(Arrays.asList(pacienteECG));

        List<PacienteECG> response = service.findAll();

        assertEquals(ID, response.get(0).getId());
        assertEquals(NOME, response.get(0).getNome());
        assertEquals(CIDADE, response.get(0).getCidade());
        assertEquals(ESTADO, response.get(0).getEstado());
        assertEquals(FREQUENCIACARDIACA, response.get(0).getFrequenciaCardiaca());
    }

    @Test
    public void quandoProcurarTodasFrequenciasEntaoRetorneLista(){
        when(repository.findAll()).thenReturn(Arrays.asList(pacienteECG));

        List<PacienteECG> response = service.findByFrequenciaCardiaca(90);

        assertNotNull(response);
    }

    @Test
    public void quandoProcurarEstadoRetornarUsuario(){
        when(repository.findByEstado(ESTADO)).thenReturn(pacienteECG);

        service.findByEstado(ESTADO);

        verify(repository).findByEstado(ESTADO);
    }

    @Test
    public void quandoProcurarCidadeRetornarUsuario(){
        when(repository.findByCidade(CIDADE)).thenReturn(pacienteECG);

        service.findByCidade(CIDADE);

        verify(repository).findByCidade(CIDADE);
    }
}
