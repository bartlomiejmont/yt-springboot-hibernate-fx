package com.example.demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Controller;

@Controller
public class SampleController {

    @FXML
    private Button button1;

    @FXML
    private Label label1;

    public void buttonClick(ActionEvent actionEvent) {
        int i = Integer.parseInt(label1.getText());
        i++;
        label1.setText(String.valueOf(i));
    }
}
