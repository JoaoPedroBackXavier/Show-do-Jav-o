package com.mycompany.show_do_javao;

public class Pergunta {

    String pergunta;
    String respostaA;
    String respostaB;
    String respostaC;
    String respostaD;
    char respostaCerta;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getRespostaA() {
        return respostaA;
    }

    public void setRespostaA(String respostaA) {
        this.respostaA = respostaA;
    }

    public String getRespostaB() {
        return respostaB;
    }

    public void setRespostaB(String respostaB) {
        this.respostaB = respostaB;
    }

    public String getRespostaC() {
        return respostaC;
    }

    public void setRespostaC(String respostaC) {
        this.respostaC = respostaC;
    }

    public String getRespostaD() {
        return respostaD;
    }

    public void setRespostaD(String respostaD) {
        this.respostaD = respostaD;
    }

    public char getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(char respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public Pergunta(String pergunta, String respostaA, String respostaB, String respostaC, String respostaD, char respostaCerta) {
        this.pergunta = pergunta;
        this.respostaA = respostaA;
        this.respostaB = respostaB;
        this.respostaC = respostaC;
        this.respostaD = respostaD;
        this.respostaCerta = respostaCerta;
    }

}
