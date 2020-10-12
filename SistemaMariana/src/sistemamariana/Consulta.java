package sistemamariana;

import java.util.*;

public class Consulta {
    private Date data;
    private String horario;
    private Double peso;
    private Double percGordura;
    private String sensacao;
    private Cliente paciente;
    private Double qtdCalorias;
    
    public Consulta() {
        this.paciente = null;
        this.data = null;
        this.horario = null;
        this.peso = null;
        this.percGordura = null;
        this.sensacao = null;
        this.qtdCalorias = null;
    }

    public Consulta(Cliente paciente, Date data, String horario, Double peso, Double percGordura, String sensacao, Double qtdCalorias) {
        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
        this.peso = peso;
        this.percGordura = percGordura;
        this.sensacao = sensacao;
        this.qtdCalorias = qtdCalorias;
    }



    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPercGordura() {
        return percGordura;
    }

    public void setPercGordura(Double percGordura) {
        this.percGordura = percGordura;
    }

    public String getSensacao() {
        return sensacao;
    }

    public void setSensacao(String sensacao) {
        this.sensacao = sensacao;
    }

    public Cliente getPaciente() {
        return paciente;
    }

    public void setPaciente(Cliente paciente) {
        this.paciente = paciente;
    }

    public Double getQtdCalorias() {
        return qtdCalorias;
    }

    public void setQtdCalorias(Double qtdCalorias) {
        this.qtdCalorias = qtdCalorias;
    }
    
}
