package com.mycompany.show_do_javao;

import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Game {

    public static void run() {

        Scanner sc = new Scanner(System.in);

        File arquivoPerguntas = new File("perguntas.json");

        String conteudo = "";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoPerguntas))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                conteudo += linha + "\n";
            }
        } catch (Exception e) {
            System.out.println("erro:" + e.getMessage());
        }

        JSONArray perguntas = new JSONArray(conteudo);

        String inicio = "==============================\n"
                + "  🎮 Show do Javao 🎮\n"
                + "Venca para ganhar 1 milhao de Libras Libanesas!\n"
                + "==============================";

        for (int i = 0; i < 10; i++) {

            JSONObject perguntax = perguntas.getJSONObject(i);
            Pergunta pergunta = new Pergunta(perguntax.getString("pergunta"),
                    perguntax.getString("respostaA"),
                    perguntax.getString("respostaB"),
                    perguntax.getString("respostaC"),
                    perguntax.getString("respostaD"),
                    perguntax.getString("respostaCorreta").charAt(0));

            System.out.println("pergunta" + i + ":\n"
                    + pergunta.getPergunta() + "\n"
                    + pergunta.getRespostaA() + "\n"
                    + pergunta.getRespostaB() + "\n"
                    + pergunta.getRespostaC() + "\n"
                    + pergunta.getRespostaD() + "\n"
            );

            String respoUsu = sc.nextLine();

            if (respoUsu.toLowerCase().charAt(0) == pergunta.getRespostaCerta()) {
                i++;
                System.out.println("resposta certa!");
            } else {
                System.out.println("resposta errada!");
            }
        }
    }
}
