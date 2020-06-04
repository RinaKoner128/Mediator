package sample.Metods;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Worker extends Colleague {
    public Worker(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notifyColleague(Qweston message) {
        VBox qwpane = new VBox();
        TextField qwfield = new TextField();
        qwfield.textProperty().bindBidirectional(message.questionProperty());
        qwpane.getChildren().add(qwfield);
        Label ques = new Label();
        ques.setText("Антоим к слову горький");
        qwpane.getChildren().add(ques);
        for (int i = 0; i < message.getAnswergood().size(); i++) {
            CheckBox checkBox = new CheckBox();
            checkBox.textProperty().bindBidirectional(message.getAnswergood().get(i));
            qwpane.getChildren().add(checkBox);
        }
        for (int i = 0; i < message.getBadanswer().size(); i++) {
            CheckBox checkBox = new CheckBox();
            checkBox.textProperty().bindBidirectional(message.getBadanswer().get(i));
            qwpane.getChildren().add(checkBox);
        }
        mediator.setView(qwpane);
    }
}