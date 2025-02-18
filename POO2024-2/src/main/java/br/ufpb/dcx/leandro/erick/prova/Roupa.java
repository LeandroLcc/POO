package br.ufpb.dcx.leandro.erick.prova;

import java.util.Objects;

public class Roupa {
    private String codigo;
    private String descricao;
    private int quantidade;
    private Tamanho tamanho;

    public Roupa(String codigo, String descricao, Tamanho tamanho, int quantidade){
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
    }

    //GET's
    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    //SET
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //______

    public String toString(){
        return "A roupa de código " + this.codigo +
                ", com a descrição: " + this.descricao + ". Quantidade: " +
                this.quantidade + ". Tamanho: " + this.tamanho + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roupa roupa = (Roupa) o;
        return Objects.equals(codigo, roupa.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
