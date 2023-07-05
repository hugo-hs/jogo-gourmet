package br.com.jogogourmet;


import javax.swing.JOptionPane;
import java.text.MessageFormat;

public class Question {

    private Question parentQuestion;
    private Question positiveQuestion;
    private Question negativeQuestion;

    private String questionDescription = "O prato que você pensou é {0}?";
    private String dish;
    private boolean isPositiveQuestion;

    public Question(String dish) {
        this.dish = dish;
        this.questionDescription = MessageFormat.format(this.questionDescription, dish);
    }

    public void ask() {
        boolean response = confirmDish();
        if (response) {
            this.positiveQuestion.ask();
        } else {
            this.negativeQuestion.ask();
        }

    }

    protected boolean confirmDish() {
        return JOptionPane.showConfirmDialog(null, this.questionDescription, "Confirm", 0) == 0;
    }

    public void setChildQuestion(Question question, boolean isPositiveQuestion) {
    	if(isPositiveQuestion) {
    		this.setPositiveQuestion(question);
    	} else {
    		this.setNegativeQuestion(question);
    	}
    }
    
    public void setPositiveQuestion(Question positiveQuestion) {
        this.positiveQuestion = positiveQuestion;
        this.positiveQuestion.setParentQuestion(this);
        this.positiveQuestion.setPositiveQuestion(true);
    }

    public void setNegativeQuestion(Question negativeQuestion) {
        this.negativeQuestion = negativeQuestion;
        this.negativeQuestion.setParentQuestion(this);
        this.negativeQuestion.setPositiveQuestion(false);
    }

    public Question getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(Question parentQuestion) {
        this.parentQuestion = parentQuestion;
    }

    public boolean isPositiveQuestion() {
        return isPositiveQuestion;
    }

    public void setPositiveQuestion(boolean isPositiveQuestion) {
        this.isPositiveQuestion = isPositiveQuestion;
    }

    public Question getPositiveQuestion() {
        return positiveQuestion;
    }

    public Question getNegativeQuestion() {
        return negativeQuestion;
    }

	public String getDish() {
		return dish;
	}
}
