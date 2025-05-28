package com.mycompany.show_do_javao;

import java.io.File;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Game {

    public static void run() {

        Scanner sc = new Scanner(System.in);

        File arquivoPerguntas = new File("./src/main/java/com/mycompany/show_do_javao/perguntas.json");

        String conteudo = "";

        try {
            Scanner leitor = new Scanner(arquivoPerguntas);
            while (leitor.hasNextLine()) {
                conteudo += leitor.nextLine();
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("erro:" + e.getMessage());
        }

        JSONArray perguntas = new JSONArray(conteudo);

        String inicio = "==============================\n"
                + "  🎮 Show do Javao 🎮\n"
                + "Venca para ganhar 1 milhao de Libras Libanesas!\n"
                + "==============================";

        System.out.println(inicio);

        int premio = 0;

        for (int i = 0; i < 10; i++) {

            JSONObject perguntax = perguntas.getJSONObject(i);

            Pergunta pergunta = new Pergunta(perguntax.getString("pergunta"),
                    perguntax.getString("respostaA"),
                    perguntax.getString("respostaB"),
                    perguntax.getString("respostaC"),
                    perguntax.getString("respostaD"),
                    perguntax.getString("respostaCorreta").charAt(0));

            System.out.println("pergunta " + (i + 1) + ":\n"
                    + pergunta.getPergunta() + "\n\n"
                    + "A) " + pergunta.getRespostaA() + "\n"
                    + "B) " + pergunta.getRespostaB() + "\n"
                    + "C) " + pergunta.getRespostaC() + "\n"
                    + "D) " + pergunta.getRespostaD() + "\n");

            String respoUsu = sc.nextLine();

            if (respoUsu.toLowerCase().charAt(0) == pergunta.getRespostaCerta()) {
                System.out.println("resposta certa!");
                if (premio == 0) {
                    premio = 2000;
                } else {
                    premio *= 2;
                }
                if (i != 9) {

                    System.out.println("atualmente o premio esta em .J.J" + premio + " se voce errar a proxima questao, voce leva pra casa .J.J" + premio / 2 + ", \"p\" para parar e \"c\" para continuar");
                    respoUsu = sc.nextLine();

                    if ("p".equals(respoUsu)) {
                        System.out.println("voce parou o jogo com .J.J"+ premio + ", essa quantia equivale a RS"+premio*0.000064);
                        break;
                    }
                } else {
                    System.out.println("parabens voce acaba de ganhar 1 milhao de libras libanesas, essa quantia equivale a RS"+premio*0.000064);
                }

            } else {
                System.out.println("resposta errada");
                if(premio > 0){System.out.println("voce errou a questao e vai levar a metade do que voce tinha que foi .J.J"+premio+ ", essa quantia equivale a RS"+premio*0.000064);}
                else{System.out.println("voce errou a questao e vai levar a metade do que voce tinha que foi nada seu miseravel");}
                
                break;
            }
        }

        sc.close();
    }
}
