package br.com.jogogourmet;

import javax.swing.JOptionPane;

public class FinalQuestion extends Question {

    public FinalQuestion(String dish) {
        super(dish);
    }

    @Override
    public void ask() {
        boolean response = confirmDish();

        if(response) {
            JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet", 1);
        } else {

            String newDish = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
            String newTip = JOptionPane.showInputDialog(null, newDish + " é _______ mas " + this.getDish() + " não.", "Complete", 3);

            Question newQuestion = new Question(newTip);

            FinalQuestion newFinalQuestion = new FinalQuestion(newDish);

            this.getParentQuestion().setChildQuestion(newQuestion, this.isPositiveQuestion());
            
            newQuestion.setPositiveQuestion(newFinalQuestion);
            newQuestion.setNegativeQuestion(this);
            
        }
    }
}
