import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Main extends Application {

    private Pane rootPane = new Pane();
    private Tile[][] board = new Tile[3][3];

    private Parent createContent() {

        rootPane.setPrefSize(600, 600);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                rootPane.getChildren().add(tile);

                board[j][i] = tile;
            }
        }

        return rootPane;
    }


    private static class Tile extends StackPane {

        private Text text = new Text();

        Tile(){

            Rectangle border = new Rectangle(200,200);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            setAlignment(Pos.CENTER);
            setAlignment(Pos.CENTER);

            text.setFont(Font.font((72)));
            getChildren().addAll(border, text);

            setOnMouseClicked(event -> {

                if (event.getButton() == MouseButton.PRIMARY) {

                    drawX();

                }
                else if (event.getButton() == MouseButton.SECONDARY) {

                    drawO();

                }
            });

        }

        private void drawX() {
            text.setText("X");
        }

        private void drawO() {
            text.setText("O");
        }

        public void start(Stage primaryStage) throws Exception {

            primaryStage.setTitle("0&X");

        }

    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(createContent());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launch GUI
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }



}
