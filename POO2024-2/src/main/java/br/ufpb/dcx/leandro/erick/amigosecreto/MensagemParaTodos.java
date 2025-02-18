package br.ufpb.dcx.leandro.erick.amigosecreto;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima);
    }

    public String getTextoCompletoAExibir(){
        if(ehAnonima()){
            return "Mensagem para todos. Texto: " + this.getTexto();
        }else{
            return "Mensagem de " + this.getEmailRemetente() + "para todos.  Texto: " + this.getTexto() + ".";
        }
    }
}
