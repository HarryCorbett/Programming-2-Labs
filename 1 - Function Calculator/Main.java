import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("My Function Calculator");

        HBox hbox = new HBox();

        // text label
        Label xlabel = new Label("x = ");

        // Create text input
        TextField textBox = new TextField();
        textBox.setMaxWidth(400);
        textBox.setText("0");

        // Button layout
        FlowPane buttonPane = new FlowPane(Orientation.VERTICAL);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setVgap(2);

        // Buttons
        Button plusOne = new Button("+1");
        Button minusOne = new Button("-1");
        plusOne.setPrefWidth(40);
        minusOne.setPrefWidth(40);
        buttonPane.getChildren().addAll(plusOne,minusOne);

        // text label
        Label functionText = new Label(" Function: ");

        // choicebox
        ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.observableArrayList("x*x", "Sin(x)", "Cos(x)", "Fibonacci(x)"));
        cb.setValue("x*x");
        FlowPane radioButtonPane = new FlowPane(Orientation.VERTICAL);
        radioButtonPane.getChildren().addAll(cb);
        radioButtonPane.setAlignment(Pos.CENTER);

        // text label
        Label equalsText = new Label(" = ");

        // Output text box
        TextField textOutput = new TextField();
        textOutput.setEditable(false);

        // +1/-1 Button event handler
        class ButtonClickHandler implements EventHandler<ActionEvent>{
            public void handle(ActionEvent e){
                String text = textBox.getText();
                int x = Integer.parseInt(text);
                Button button = ((Button)e.getSource());
                if(button == plusOne){
                    textBox.setText(String.valueOf(x+1));
                }else if(button == minusOne){
                    textBox.setText(String.valueOf(x-1));
                }
            }
        }

        // Button event on click
        plusOne.setOnAction(new ButtonClickHandler());
        minusOne.setOnAction(new ButtonClickHandler());

        //Update when x changes
        textBox.textProperty().addListener((observable) -> {
            Update update = new Update();
            Update.UpdateOutput(textBox.getText(),cb,textOutput);
        });

        //update when cb changes
        cb.setOnAction(event -> {
            Update update = new Update();
            Update.UpdateOutput(textBox.getText(),cb,textOutput);
        });

        // Add pane to Vbox
        hbox.getChildren().addAll(xlabel, textBox, buttonPane,functionText, radioButtonPane, equalsText, textOutput);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20,20,20,20));

        // display gui
        Scene scene = new Scene(hbox, 700, 125);
        primaryStage.setScene(scene);

        primaryStage.show();
        Update update = new Update();
        Update.UpdateOutput(textBox.getText(),cb,textOutput);
    }

    /**
     * Launch GUI
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }



}
