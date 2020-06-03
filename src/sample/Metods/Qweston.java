package sample.Metods;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public class Qweston {
    StringProperty question;
    ArrayList<StringProperty> answergood;
    ArrayList<StringProperty> badanswer;
    Integer type;
    Collection aw = new HashSet();

    public Qweston(String qw) {
        question = new SimpleStringProperty(qw);
        answergood = new ArrayList<>();
        badanswer = new ArrayList<>();
        aw.add("5654549");
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
       answergood.addAll(aw);
        return answergood;
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }


}