package br.ufpb.dcx.leandro.erick.amigosecreto;

public class MensagemParaAlguem extends Mensagem{

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima){
         super(texto, emailRemetente, anonima);
         this.emailDestinatario = emailDestinatario;

    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        if(ehAnonima()){
            return "Mensagem  para " + this.emailDestinatario+ ". Texto: "+ this.getTexto();
        }else {
            return "Mensagem de: " + this.getEmailRemetente() + " para " + this.emailDestinatario + ". Texto: "+ this.getTexto();
        }
    }

}
