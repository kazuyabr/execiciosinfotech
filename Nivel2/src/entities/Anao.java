package entities;
import java.util.Objects;

public class Anao {

    
    private String nome;
    private Integer vida;
    private Integer forca;
    private Integer magia;
    private Integer agilidade;
    private Integer inteligencia;
    private Integer level;
    

    public Anao(){

    }
    
    public Anao(String nome) {
        this.nome = nome;
        this.vida = 2000;
        this.forca = 15;
        this.magia = 20;
        this.agilidade = 20;
        this.inteligencia = 40;
        this.level = 1;
    }
        
    public Anao(String nome, Integer vida, Integer forca, Integer magia, Integer agilidade, Integer inteligencia, Integer level) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.magia = magia;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.level = level;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }


    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getMagia() {
        return magia;
    }


    public void setMagia(Integer magia) {
        this.magia = magia;
    }

 
    public Integer getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

 
    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getLevel() {
        return level;
    }


    public void setLevel(Integer level) {
        this.level = level;
    }


    public Anao nome(String nome) {
        setNome(nome);
        return this;
    }

    public Anao vida(Integer vida) {
        setVida(vida);
        return this;
    }

    public Anao forca(Integer forca) {
        setForca(forca);
        return this;
    }

    public Anao magia(Integer magia) {
        setMagia(magia);
        return this;
    }

    public Anao agilidade(Integer agilidade) {
        setAgilidade(agilidade);
        return this;
    }

    public Anao inteligencia(Integer inteligencia) {
        setInteligencia(inteligencia);
        return this;
    }

    public Anao level(Integer level) {
        setLevel(level);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Anao)) {
            return false;
        }
        Anao anao = (Anao) o;
        return Objects.equals(nome, anao.nome) && Objects.equals(vida, anao.vida) && Objects.equals(forca, anao.forca) && Objects.equals(magia, anao.magia) && Objects.equals(agilidade, anao.agilidade) && Objects.equals(inteligencia, anao.inteligencia) && Objects.equals(level, anao.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, vida, forca, magia, agilidade, inteligencia, level);
    }

     
     public int atacar() {
        
        return this.forca * 2;
    }

    public int usarMagia() {
        
        if (this.magia.equals("Pouca")) {
            return this.inteligencia * 2;
        } else if (this.magia.equals("Media")) {
            return this.inteligencia * 3;
        } else {
            return this.inteligencia * 4;
        }
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", vida='" + getVida() + "'" +
            ", forca='" + getForca() + "'" +
            ", magia='" + getMagia() + "'" +
            ", agilidade='" + getAgilidade() + "'" +
            ", inteligencia='" + getInteligencia() + "'" +
            ", level='" + getLevel() + "'" +
            "}";
    }

 

}
