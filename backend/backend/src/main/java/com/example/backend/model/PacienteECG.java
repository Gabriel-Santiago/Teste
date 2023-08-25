package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name= "paciente")
public class PacienteECG{

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", sequenceName = "paciente_id", allocationSize = 1)
    private int id;
    private String nome;
    private String cidade;
    private String estado;
    private int frequenciaCardiaca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    @Override
    public String toString() {
        return "PacienteECG{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", frequenciaCardiaca=" + frequenciaCardiaca +
                '}';
    }

    public PacienteECG(int id, String nome, String cidade, String estado, int frequenciaCardiaca) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public PacienteECG() {
        super();
    }
}
