import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class ClickHandler implements EventHandler<ActionEvent> {

    private int counter = 0;
    private String name;

    public ClickHandler(String name) {
        this.name = name;
    }

    public void handle(ActionEvent event) {



    }

}