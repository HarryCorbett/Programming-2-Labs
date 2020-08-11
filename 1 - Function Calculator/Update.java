import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Update {

    /**
     * Update the result
     * @param input the value currently in the input box
     * @param textOutput the output box to update
     */
    static void UpdateOutput(String input, ChoiceBox<String> cb, TextField textOutput){

        if(!(input.equals(""))) {
            String function = cb.getValue();
            int x = Integer.parseInt(input);
            switch (function) {
                case "x*x":
                    textOutput.setText(String.valueOf(x * x));
                    break;
                case "Sin(x)":
                    textOutput.setText(String.valueOf(Math.sin(x)));break;
                case "Cos(x)":
                    textOutput.setText(String.valueOf(Math.cos(x)));
                    break;
            }
        }
    }

}
