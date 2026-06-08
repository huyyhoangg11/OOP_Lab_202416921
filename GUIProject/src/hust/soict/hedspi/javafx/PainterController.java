package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    private boolean eraserMode = false;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double radius = eraserMode ? 8 : 3;
        Color color = eraserMode ? Color.WHITE : Color.BLACK;

        Circle newCircle = new Circle(event.getX(), event.getY(), radius, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void penSelected(ActionEvent event) {
        eraserMode = false;
    }

    @FXML
    void eraserSelected(ActionEvent event) {
        eraserMode = true;
    }
}