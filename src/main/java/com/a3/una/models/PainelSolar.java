package com.a3.una.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PainelSolar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double potencia;
    private String modulo;
    private String marca;
    private String estrutura;
    private Double tensao;
    private Integer fase;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Double getPotencia() {return potencia;}

    public void setPotencia(Double potencia) {this.potencia = potencia;}

    public String getModulo() {return modulo;}

    public void setModulo(String modulo) {this.modulo = modulo;}

    public String getMarca() {return marca;}

    public void setMarca(String marca) {this.marca = marca;}

    public String getEstrutura() {return estrutura;}

    public void setEstrutura(String estrutura) {this.estrutura = estrutura;}

    public Double getTensao() {return tensao;}

    public void setTensao(Double tensao) {this.tensao = tensao;}

    public Integer getFase() {return fase;}

    public void setFase(Integer fase) {this.fase = fase;}
}
