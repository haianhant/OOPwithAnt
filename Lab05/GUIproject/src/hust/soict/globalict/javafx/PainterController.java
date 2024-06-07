package hust.soict.globalict.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private CheckBox penCheckBox;
    
    @FXML
    private CheckBox eraserCheckBox;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (penCheckBox.isSelected()) 
    	{
    		Circle newCircle = new Circle(event.getX(), 
        			event.getY(), 4, Color.BLACK);
    		drawingAreaPane.getChildren().add(newCircle);
    	} 
    	
    	else if (eraserCheckBox.isSelected()) 
    	{
    		Circle newCircle = new Circle(event.getX(), 
        			event.getY(), 4, Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
    	}
    }
    
    @FXML
    void penSelected(ActionEvent event) {
    	if (penCheckBox.isSelected()) {
    		eraserCheckBox.setSelected(false);
    	}
    }

    @FXML
    void eraserSelected(ActionEvent event) {
    	if (eraserCheckBox.isSelected()) {
    		penCheckBox.setSelected(false);
    	}
    }

}


