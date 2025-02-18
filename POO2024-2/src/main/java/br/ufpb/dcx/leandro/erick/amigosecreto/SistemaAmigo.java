package br.ufpb.dcx.leandro.erick.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Amigo> amigos = new ArrayList<>();

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        new Amigo(nomeAmigo, emailAmigo);
    }

    public Amigo pesquisaAmigo(String nomeAmigo){
        for(Amigo a : this.amigos){
            if(a.getNome().equalsIgnoreCase(nomeAmigo)){
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente,boolean ehAnonima){
        new MensagemParaTodos(texto, emailRemetente, ehAnonima);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente,String emailDestinatario, boolean ehAnonima){
        new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
    }

    public List<Mensagem> pesquisarMensagensAnonimas() {
        List<Mensagem> mensagemLista = new ArrayList<>();
        for (Mensagem mens : this.mensagens) {
            if (mens.ehAnonima()) {
                mensagemLista.add(mens);
            }
        }
        return mensagemLista;
    }

    public List<Mensagem> pesquisarTodasAsMensagens(){
        if(this.mensagens.size()>0){
            return mensagens;
        }
        return null;
    }

    public void configuraAmigoSecretoDaPessoa(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        boolean emailAmigoSorteadoExiste = false;
        boolean emailDaPessoaExiste = false;
        for(Amigo e : this.amigos){
            if(e.getEmail().equalsIgnoreCase(emailAmigoSorteado)){
                emailAmigoSorteadoExiste = true;
            }
        }
        for(Amigo a : this.amigos){

            if(a.getEmail().equalsIgnoreCase(emailDaPessoa) && emailAmigoSorteadoExiste){
                emailDaPessoaExiste = true;
                a.setEmailAmigoSorteado(emailAmigoSorteado);
            }
        }
        if(!emailAmigoSorteadoExiste || !emailDaPessoaExiste){
            throw new AmigoInexistenteException("Este email não existe!");
        }
    }

    public String pesquisaAmigoSecretoDeEmail(String emailDaPessoa){
        for(Amigo am : this.amigos){
            if(am.getNome().equalsIgnoreCase(emailDaPessoa)){
                return am.getEmailAmigoSorteado();
            }
        }
        return null;
    }

}
