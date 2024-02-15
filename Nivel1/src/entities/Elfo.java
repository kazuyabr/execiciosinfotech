package entities;
import java.util.Objects;

public class Elfo {

    
    private String nome;
    private Integer vida;
    private Integer forca;
    private String magia;
    private Integer agilidade;
    private Integer inteligencia;
    private Integer level;
    

    public Elfo(){


    }

    public Elfo(String nome) {
        this.nome = nome;
        this.vida = 2000;
        this.forca = 15;
        this.magia = "Pouca";
        this.agilidade = 20;
        this.inteligencia = 40;
        this.level = 1;
    }
    
    public Elfo(String nome, Integer vida, Integer forca, String magia, Integer agilidade, Integer inteligencia, Integer level) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.magia = magia;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.level = level;
    }


    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Integer return the vida
     */
    public Integer getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(Integer vida) {
        this.vida = vida;
    }

    /**
     * @return Integer return the forca
     */
    public Integer getForca() {
        return forca;
    }

    /**
     * @param forca the forca to set
     */
    public void setForca(Integer forca) {
        this.forca = forca;
    }

    /**
     * @return String return the magia
     */
    public String getMagia() {
        return magia;
    }

    /**
     * @param magia the magia to set
     */
    public void setMagia(String magia) {
        this.magia = magia;
    }

    /**
     * @return Integer return the agilidade
     */
    public Integer getAgilidade() {
        return agilidade;
    }

    /**
     * @param agilidade the agilidade to set
     */
    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    /**
     * @return Integer return the inteligencia
     */
    public Integer getInteligencia() {
        return inteligencia;
    }

    /**
     * @param inteligencia the inteligencia to set
     */
    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
     * @return Integer return the level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
    }


    public Elfo nome(String nome) {
        setNome(nome);
        return this;
    }

    public Elfo vida(Integer vida) {
        setVida(vida);
        return this;
    }

    public Elfo forca(Integer forca) {
        setForca(forca);
        return this;
    }

    public Elfo magia(String magia) {
        setMagia(magia);
        return this;
    }

    public Elfo agilidade(Integer agilidade) {
        setAgilidade(agilidade);
        return this;
    }

    public Elfo inteligencia(Integer inteligencia) {
        setInteligencia(inteligencia);
        return this;
    }

    public Elfo level(Integer level) {
        setLevel(level);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Elfo)) {
            return false;
        }
        Elfo Elfo = (Elfo) o;
        return Objects.equals(nome, Elfo.nome) && Objects.equals(vida, Elfo.vida) && Objects.equals(forca, Elfo.forca) && Objects.equals(magia, Elfo.magia) && Objects.equals(agilidade, Elfo.agilidade) && Objects.equals(inteligencia, Elfo.inteligencia) && Objects.equals(level, Elfo.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, vida, forca, magia, agilidade, inteligencia, level);
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
