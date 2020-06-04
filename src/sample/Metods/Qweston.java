package sample.Metods;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Qweston {
    StringProperty question;
    ArrayList<StringProperty> answergood;
    ArrayList<StringProperty> badanswer;
    Integer type;


    public Qweston(String qw) {
        question = new SimpleStringProperty(qw);
        answergood = new ArrayList<>();
        badanswer = new ArrayList<>();
    }


    public String getQuestion() {
        return question.get();
    }

    public StringProperty questionProperty() {
        return question;
    }

    public void setAnswergood(ArrayList<StringProperty> answergood) {
        this.answergood = answergood;
    }

    public ArrayList<StringProperty> getBadanswer() {
        return badanswer;
    }

    public void setBadanswer(ArrayList<StringProperty> badanswer) {
        this.badanswer = badanswer;
    }

    public int addTrue(String s) {
        answergood.add(new SimpleStringProperty(s));
        return answergood.size();
    }

    public int addFalse(String s) {
        badanswer.add(new SimpleStringProperty(s));
        return badanswer.size();
    }

    public ArrayList<StringProperty> getAnswergood() {
        return answergood;
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }


}