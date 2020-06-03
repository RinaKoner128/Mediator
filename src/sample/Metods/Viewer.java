package sample.Metods;

import javafx.scene.control.Separator;
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
        Separator separator = new Separator();
        separator.setMaxWidth(20);
        qwpane.getChildren().add(separator);
        for (int i = 0; i < message.getAnswergood().size(); i++) {
            TextField qwfieldi = new TextField();
            qwfieldi.textProperty().bindBidirectional(message.getAnswergood().get(i));
            qwpane.getChildren().add(qwfieldi);
        }
        for (int i = 0; i < message.getBadanswer().size(); i++) {
            TextField qwfieldi = new TextField();
            qwfieldi.textProperty().bindBidirectional(message.getBadanswer().get(i));
            qwpane.getChildren().add(qwfieldi);
        }
        mediator.setView(qwpane);
    }
}