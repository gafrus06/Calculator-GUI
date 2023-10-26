package com.example.calculator;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class CalculatorController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField TextField;
    @FXML
    private Circle buttonCleat;
    @FXML
    private Circle buttonDel;
    @FXML
    private Circle buttonEquls;
    @FXML
    private Circle buttonFloat;
    @FXML
    private Circle buttonMinus;
    @FXML
    private Circle buttonPlus;
    @FXML
    private Circle buttonX;
    @FXML
    private Circle digit0;
    @FXML
    private Circle digit1;

    @FXML
    private Circle digit2;
    @FXML
    private Circle digit3;
    @FXML
    private Circle digit4;
    @FXML
    private Circle digit5;
    @FXML
    private Circle digit6;
    @FXML
    private Circle digit7;
    @FXML
    private Circle digit8;
    @FXML
    private Circle digit9;
    private Map<Circle, String> digits = new LinkedHashMap<>();
    private Map<Circle, String> operations = new HashMap<>();
    @FXML
    void initialize() {
        TextField.setText("0");
        TextField.setEditable(false);
        TextField.setStyle("-fx-text-fill: Black;-fx-highlight-fill: null;\n" +
                "-fx-highlight-text-fill: null;");
        TextField.setFont(new Font("Lucida Sans", 40));
        printListAndPressedReleased();
        clearTextField(buttonCleat);
        for(Map.Entry<Circle, String> entry : digits.entrySet()){
            printDigitsOnTextField(entry.getKey());
        }
        for(Map.Entry<Circle, String> entry : operations.entrySet()){
            printOperationsOnTextField(entry.getKey());
        }
        equls();

    }
    private void equls(){
        buttonEquls.setOnMouseClicked(mouseEvent -> {
            OperationPlus();
            OperationX();
            OperationDel();
            OperationMinus();

        });
    }
    private void OperationPlus(){
        if(TextField.getText().contains(operations.get(buttonPlus))){
            String[] parts = TextField.getText().split("[+]");
            String part1 = parts[0];
            String part2 = parts[1];
            if(TextField.getText().contains(".")) {
                TextField.setText(String.valueOf((Double.valueOf(part1)) + (Double.valueOf(part2))));
            }else
                TextField.setText(String.valueOf((Integer.parseInt(part1)) + (Integer.parseInt(part2))));
        }
    }
    private void OperationX(){
        if(TextField.getText().contains(operations.get(buttonX))){
            String[] parts = TextField.getText().split("x");
            String part1 = parts[0];
            String part2 = parts[1];
            if(TextField.getText().contains(".")) {
                TextField.setText(String.valueOf((Double.valueOf(part1)) * (Double.valueOf(part2))));
            }else
                TextField.setText(String.valueOf((Integer.parseInt(part1)) * (Integer.parseInt(part2))));

        }
    }
    private void OperationMinus(){
        if(TextField.getText().contains(operations.get(buttonMinus))){
            String[] parts = TextField.getText().split("-");
            String part1 = parts[0];
            String part2 = parts[1];
            if(TextField.getText().contains(".")) {
                TextField.setText(String.valueOf((Double.valueOf(part1)) - (Double.valueOf(part2))));
            }else
                TextField.setText(String.valueOf((Integer.parseInt(part1)) - (Integer.parseInt(part2))));

        }
    }
    private void OperationDel(){
        if(TextField.getText().contains(operations.get(buttonDel))){
            String[] parts = TextField.getText().split("/");
            String part1 = parts[0];
            String part2 = parts[1];
            if((Integer.valueOf(part2)) != 0) {
                if ((Integer.valueOf(part1)) % (Integer.valueOf(part2)) != 0) {
                    TextField.setText(String.valueOf((Double.valueOf(part1)) / (Double.valueOf(part2))));
                } else
                    TextField.setText(String.valueOf((Integer.parseInt(part1)) / (Integer.parseInt(part2))));

            }else TextField.setText("0");

        }
    }

    private void clearTextField(Circle operation){
        operation.setOnMouseClicked(mouseEvent -> {
            TextField.setText("0");
        });

    }
    private void printOperationsOnTextField(Circle operation){
        operation.setOnMouseClicked(mouseEvent -> {
            TextField.setText(TextField.getText() + operations.get(operation));

        });
    }

    private void printDigitsOnTextField(Circle digit1){
        digit1.setOnMouseClicked(mouseEvent -> {
            if(TextField.getText().equals("0"))
                TextField.setText(digits.get(digit1));
            else
                TextField.setText(TextField.getText() + digits.get(digit1));
        });
    }

    private void setOnMousePressedAndReleased(Circle digit){

        digit.setOnMousePressed(mouseEvent -> {
            digit.setFill(Color.valueOf("#1e262e"));
        });
        digit.setOnMouseReleased(mouseEvent -> {
            digit.setFill(Color.valueOf("#23394e"));
        });

    }
    private void printListAndPressedReleased(){

        digits.put(digit0, "0");
        digits.put(digit1, "1");
        digits.put(digit2, "2");
        digits.put(digit3, "3");
        digits.put(digit4, "4");
        digits.put(digit5, "5");
        digits.put(digit6, "6");
        digits.put(digit7, "7");
        digits.put(digit8, "8");
        digits.put(digit9, "9");
        for(Map.Entry<Circle, String> entry : digits.entrySet()){
            setOnMousePressedAndReleased(entry.getKey());
        }
        operations.put(buttonX, "x");
        operations.put(buttonMinus, "-");
        operations.put(buttonPlus, "+");
        operations.put(buttonDel, "/");
        operations.put(buttonFloat, ".");
        operations.put(buttonEquls, "");
        for(Map.Entry<Circle, String> entry : operations.entrySet()){
            setOnMousePressedAndReleased(entry.getKey());
        }
    }

}
