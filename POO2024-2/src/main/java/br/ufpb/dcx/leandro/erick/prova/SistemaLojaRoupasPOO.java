package br.ufpb.dcx.leandro.erick.prova;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas {
    private Map<String, Roupa> roupasMap;

    public SistemaLojaRoupasPOO() {
        this.roupasMap = new HashMap<>();
    }

    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa) {
        List<Roupa> roupasListaPorTamanho = new LinkedList<>();
        for(Roupa a : this.roupasMap.values()){
            if(a.getTamanho() == tamanhoRoupa){
                roupasListaPorTamanho.add(a);
            }
        }
        return roupasListaPorTamanho;
    }

    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao){
        List<Roupa> roupasListaDescricaoComPrefixo = new LinkedList<>();
        for(Roupa a: this.roupasMap.values()){
            if(a.getDescricao().startsWith(prefixoDescricao)){
                roupasListaDescricaoComPrefixo.add(a);
            }
        }
        return roupasListaDescricaoComPrefixo;
    }

    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa){
        Roupa r = this.roupasMap.get(codigoRoupa);
        Tamanho t = r.getTamanho();
        return t;
    }

    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {
        if (this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaJaExisteException("Roupa já cadastrada: " + codigoRoupa);
        } else {
            Roupa roupa = new Roupa(codigoRoupa, descricao, tamanho, quantidade);
            this.roupasMap.put(codigoRoupa, roupa);
        }
    }

    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException{
        if(this.roupasMap.containsKey(codigoRoupa)) {
            Roupa r = this.roupasMap.get(codigoRoupa);
            r.setQuantidade(novaQuantidade);
        }else{
            throw new RoupaInexistenteException("A roupa de código: " + codigoRoupa + ". Não existe.");
        }
    }

    public int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException{
        if(this.roupasMap.containsKey(codigoRoupa)) {
            Roupa r = this.roupasMap.get(codigoRoupa);
            return r.getQuantidade();
        }else{
            throw new RoupaInexistenteException("A roupa de código: " + codigoRoupa + ". Não existe.");
        }
    }

    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException{
        if(this.roupasMap.containsKey(codigoRoupa)) {
            Roupa r = this.roupasMap.get(codigoRoupa);
            return r;
        }else{
            throw new RoupaInexistenteException("A roupa de código: " + codigoRoupa + ". Não existe.");
        }
    }

}
