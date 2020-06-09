package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Metods.*;

import java.io.*;
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
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void init() throws IOException {
            BufferedReader reader = new BufferedReader( new FileReader ("questions.txt"));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while( ( line = reader.readLine() ) != null ) {
                stringBuilder.append( line );
                stringBuilder.append( ls );
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.toString();
        badanswer.add(new SimpleStringProperty(stringBuilder.substring(
                0,stringBuilder.indexOf(",", stringBuilder.indexOf(",") + 0))));
        badanswer.add(new SimpleStringProperty(stringBuilder.substring(
                stringBuilder.indexOf(",")+1,
                stringBuilder.indexOf(",", stringBuilder.indexOf(",") + 1))));
        badanswer.add(new SimpleStringProperty(stringBuilder.substring(
                stringBuilder.indexOf(",", stringBuilder.indexOf(",") + 1)+1,
                stringBuilder.lastIndexOf(","))));

        answergood.add(new SimpleStringProperty("сладкий"));
        basetest.setAnswergood(answergood);
        basetest.setBadanswer(badanswer);
        return;
    }
}