package commons;

public class Prato {

    private String descricao;
    private Prato proximoPrato;
    private Prato pratoDiferente;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prato getProximoPrato() {
        return proximoPrato;
    }

    public void setProximoPrato(Prato proximoPrato) {
        this.proximoPrato = proximoPrato;
    }

    public Prato getPratoDiferente() {
        return pratoDiferente;
    }

    public void setPratoDiferente(Prato pratoDiferente) {
        this.pratoDiferente = pratoDiferente;
    }
}
