/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-30.
 */
package ca.bcit.comp2526.assignment1;

import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class DisplayerFrame extends Application
{
	static Shape shape;
	public void start(Stage stage){
		GridPane root = new GridPane();
		for(int row = 0; row < shape.getHeight(); row++)
        {
            
            for(int col = 0; col < shape.getWidth(); col++)
            {
                root.add(new Button(shape.getCharAt(row, col).toString()), col,row);
            }
        }
		root.setMinSize(10,10);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("My Shape");
		stage.show();
	}

}
