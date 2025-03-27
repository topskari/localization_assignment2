import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    Label lblDistance, lblFuel;

    @FXML
    Text lblResultText;

    @FXML
    TextField txtDistance, txtFuel;

    @FXML
    Button btnCalculate, btnEN, btnFR, btnJP, btnIR;

    @FXML
    GridPane rootPane;

    Locale localeEN;
    Locale localeFR;
    Locale localeJP;
    Locale localeIR;

    ResourceBundle rb;

    public HelloController() {
        this.localeEN = new Locale("en", "US");
        this.localeFR = new Locale("fr", "FR");
        this.localeJP = new Locale("ja", "JP");
        this.localeIR = new Locale("fa", "IR");
    }

    public void initialize(){

        rb = ResourceBundle.getBundle("messages", localeEN);
        setLanguage();

        btnCalculate.setOnAction(event -> {

            String distance = txtDistance.getText();
            String fuel = txtFuel.getText();

            if (distance.isEmpty() || fuel.isEmpty() || distance.equals("0") || fuel.equals("0")) {
                lblResultText.setText(rb.getString("invalid"));
                return;
            }

            try {
                double distanceValue = Double.parseDouble(distance);
                double fuelValue = Double.parseDouble(fuel);
                double result = (fuelValue / distanceValue) * 100;
                String formattedResult = MessageFormat.format(rb.getString("result"), result);
                lblResultText.setText(formattedResult);

            } catch (Exception e) {
                lblResultText.setText(rb.getString("invalid"));
            }
        });

        btnEN.setOnAction(event -> {
            rb = ResourceBundle.getBundle("messages", localeEN);
            setLanguage();
            rootPane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        });

        btnFR.setOnAction(event -> {
            rb = ResourceBundle.getBundle("messages", localeFR);
            setLanguage();
            rootPane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        });

        btnJP.setOnAction(event -> {
            rb = ResourceBundle.getBundle("messages", localeJP);
            setLanguage();
            rootPane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        });

        btnIR.setOnAction(event -> {
            rb = ResourceBundle.getBundle("messages", localeIR);
            setLanguage();
            rootPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        });
    }

    public void setLanguage() {

        lblResultText.setText("");
        lblDistance.setText(rb.getString("distance"));
        lblFuel.setText(rb.getString("fuel"));
        btnCalculate.setText(rb.getString("calculate"));
    }
}
