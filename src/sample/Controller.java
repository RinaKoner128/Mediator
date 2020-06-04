package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Metods.*;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable, Mediator {
    public Pane viewpane;
    public TextField login;
    public AnchorPane ap2;
    private HashMap<String, Colleague> id = new HashMap<>();
    private Colleague currentcolleague;
    private Qweston basetest;
    ArrayList<StringProperty> answergood = new ArrayList<>();
    ArrayList<StringProperty> badanswer = new ArrayList<>();


    public void onStart(ActionEvent actionEvent) {
        viewpane.getChildren().clear();
        currentcolleague = id.get(login.getText());
        if (currentcolleague == null) currentcolleague = id.get("1");
        currentcolleague.receive(basetest);
        currentcolleague.notifyColleague(currentcolleague.getReceivedMessage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        basetest = new Qweston("Антонимы");
        init();
        id.put("student", new Worker(this));
        id.put("lector", new Editor(this));
        id.put("1", new Viewer(this));

    }

    @Override
    public void setView(Node control) {
        viewpane.getChildren().add(control);
    }

    public void Cl(ActionEvent actionEvent) {
        ap2.setVisible(true);
    }

    public void init() {
        badanswer.add(new SimpleStringProperty("темный"));
        badanswer.add(new SimpleStringProperty("мокрый"));
        badanswer.add(new SimpleStringProperty("холодный"));
        answergood.add(new SimpleStringProperty("сладкий"));
        basetest.setAnswergood(answergood);
        basetest.setBadanswer(badanswer);
        return;
    }
}