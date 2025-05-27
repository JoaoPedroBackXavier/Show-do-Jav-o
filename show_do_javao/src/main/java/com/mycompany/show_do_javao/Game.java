package com.mycompany.show_do_javao;

import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;

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
            } else {
                System.out.println("resposta errada!");
                i = 10;
            }
        }
    }
}
