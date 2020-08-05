package resource;

import jogo.JogoGourmet;
import commons.Prato;

import javax.swing.*;

public class JogoGourmetResource {

    public void iniciarJogo(Prato prato) {
        perguntar(prato);
    }

    public Prato perguntar(Prato atual) {
        int escolha = JogoGourmet.perguntarPrato(atual.getDescricao());
        Prato novoRamo;
        switch (escolha) {
            case 0:
                if (atual.getProximoPrato() == null) {
                    JogoGourmet.acertei();
                    novoRamo = null;
                } else {
                    novoRamo = perguntar(atual.getProximoPrato());
                    if (novoRamo != null) {
                        atual.setProximoPrato(novoRamo);
                        novoRamo = null;
                    }
                }
                break;
            case 1:
                if (atual.getPratoDiferente() == null) {
                    novoRamo = criarNovoRamo(atual);
                } else {
                    novoRamo = perguntar(atual.getPratoDiferente());
                    if (novoRamo != null) {
                        atual.setPratoDiferente(novoRamo);
                        novoRamo = null;
                    }
                }
                break;
            default:
                novoRamo = null;
                break;
        }
        return novoRamo;
    }

    public Prato criarNovoRamo(Prato atual) {
        String novaDescricao = JogoGourmet.perguntarNovoRamo();

        if (novaDescricao != null) {
            novaDescricao.trim();
            if(!novaDescricao.isEmpty()){
                novaDescricao = novaDescricao.trim();
                Prato novoRamo = new Prato();
                novoRamo.setDescricao(novaDescricao);
                novoRamo.setProximoPrato(null);
                novoRamo.setPratoDiferente(null);

                String difEntreNovoEAtualDescricao = JogoGourmet.perguntarDiferencaEntrePatros(novaDescricao, atual.getDescricao());

                Prato diferencaEntrePratos = new Prato();
                diferencaEntrePratos.setDescricao(difEntreNovoEAtualDescricao);
                diferencaEntrePratos.setProximoPrato(novoRamo);
                diferencaEntrePratos.setPratoDiferente(atual);

                return diferencaEntrePratos;
            } else {
                try {
                    throw new Exception("Você deve preencher o campo.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Você deve preencher o campo.", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        return null;
    }

}
