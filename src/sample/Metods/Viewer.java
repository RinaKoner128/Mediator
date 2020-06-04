package sample.Metods;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Viewer extends Colleague {
    public Viewer(Mediator mediator) {
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
            Label answe = new Label();
            answe.textProperty().bindBidirectional(message.getAnswergood().get(i));
            qwpane.getChildren().add(answe);
        }
        Label no = new Label();
        ques.setText("Не верно");
        qwpane.getChildren().add(no);
        for (int i = 0; i < message.getBadanswer().size(); i++) {
            Label bad = new Label();
            bad.textProperty().bindBidirectional(message.getBadanswer().get(i));
            qwpane.getChildren().add(bad);
        }
        mediator.setView(qwpane);
    }
}