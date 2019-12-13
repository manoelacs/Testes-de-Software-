package br.ic.ufal;

import java.util.Objects;

public class Entidade {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidade entidade = (Entidade) o;
        return Objects.equals(nome, entidade.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    String nome;

    public Entidade(String nome) {
        this.nome = nome;
    }
}
