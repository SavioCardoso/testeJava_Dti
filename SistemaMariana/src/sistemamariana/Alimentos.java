package sistemamariana;

public class Alimentos {
    private String nome;
    private Double calorias;
    
    public Alimentos() {
    	this.nome = null;
    	this.calorias = null;
    }
    
    public Alimentos(String nome, Double calorias) {
        this.nome = nome;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }
}
