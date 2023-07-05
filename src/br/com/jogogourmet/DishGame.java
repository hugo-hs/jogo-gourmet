package br.com.jogogourmet;

import javax.swing.*;

public class DishGame {

    public static void main(String[] args) {
        Question question = new Question("massa");
        question.setPositiveQuestion(new FinalQuestion("Lasanha"));
        question.setNegativeQuestion(new FinalQuestion( "Bolo de Chocolate"));

        while (startPane(question));
    }
    private static boolean startPane(Question question) {
        boolean confirmed = JOptionPane.showOptionDialog(null,
                "Pense em um prato que gosta",
                "Jogo Gourmet",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, null, null) == 0;

        if(confirmed) {
            question.ask();
        }

        return confirmed;
    }
}
