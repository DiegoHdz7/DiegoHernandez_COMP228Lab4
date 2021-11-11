package exercise1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Application {
    private BorderPane borderPane;
    private GridPane empPanel;
    private Label lblName,lblAddress,lblProvince, lblCity,lblPostalCode, lblPhoneNumber,lblEmail;
    private TextField txtName, txtAddress,txtProvince,txtCity,txtPostalCode,txtPhoneNumber,txtEmail;
    private Button btnDisplay, btnChangeStyle;
    private VBox lngBox;
    private VBox coursesBox;
    private HBox east;
    private String[] courses1 = {"Java","C#","Python","JavaScript"};
    private String[] courses2 = {"Project Management","Economics","Global Logistics", "Entrepreneurship "};
    private ComboBox<String> cbo;
    private TextArea tArea;
    private CheckBox chkStudentCouncil;
    private CheckBox chkVolunteer;
    //
    private ToggleGroup group;
    private RadioButton rb1, rb2, rb3;
    private ListView<String> lv;
    ArrayList<String> coursesIT = new ArrayList<>();
    ArrayList<String> coursesIB = new ArrayList<>();

    private ObservableList data = FXCollections.observableArrayList();

    public Main() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        borderPane = new BorderPane();
        //create the grid pane for entries
        empPanel = new GridPane();
        empPanel.setHgap(5);
        empPanel.setVgap(5);
        //create labels
        lblName=new Label("Name:");
        lblAddress=new Label("Address:");
        lblProvince = new Label("Province:");
        lblCity = new Label("City:");
        lblPostalCode = new Label("Postal Code:");
        lblPhoneNumber = new Label("Phone Number");
        lblEmail=new Label("Email:");

        //create text fields
        txtName =new TextField();
        txtAddress =new TextField();
        txtProvince = new TextField();
        txtCity= new TextField();
        txtPostalCode = new TextField();
        txtPhoneNumber=new TextField();
        txtEmail=new TextField();

        VBox panelChkBox = new VBox(20);
        panelChkBox.setPadding(new Insets(10,10,10,10));
        chkStudentCouncil = new CheckBox("Student Council");
        chkVolunteer = new CheckBox("Volunteer Work");


        //create buttons
        btnDisplay=new Button("Display");
        btnChangeStyle=new Button("Change Style");
        //add controls to grid pane
        empPanel.add(lblName,0,0);
        empPanel.add(txtName,1,0);
        empPanel.add(lblAddress,0,1);
        empPanel.add(txtAddress,1,1);
        empPanel.add(lblProvince,0,2);
        empPanel.add(txtProvince,1,2);
        empPanel.add(lblCity,0,3);
        empPanel.add(txtCity,1,3);
        empPanel.add(lblPostalCode,0,4);
        empPanel.add(txtPostalCode,1,4);
        empPanel.add(lblPhoneNumber,0,5);
        empPanel.add(txtPhoneNumber,1,5);
        empPanel.add(lblEmail,0,6);
        empPanel.add(txtEmail,1,6);
        empPanel.add(btnDisplay,1,7);

        empPanel.add(chkStudentCouncil,3,3);
        empPanel.add(chkVolunteer,3,4);

        //align buttons in grid pane
        GridPane.setHalignment(btnDisplay, HPos.CENTER);

        //create the text area
        tArea=new TextArea();



        //create the toggle group to group radio buttons
        group = new ToggleGroup();
        //create radio buttons and add them to the toggle group
        rb1 = new RadioButton("Computer Science");
        rb1.setToggleGroup(group);
        //rb1.setSelected(true);
        rb2 = new RadioButton("Business");
        rb2.setToggleGroup(group);
        //


        // Create a scroll pane to hold the text area
        ScrollPane scrollPane = new ScrollPane(tArea);
        //handle click events
        btnDisplay.setOnAction(e -> displayEntries());


        //place grid pane in the center of border pane
        borderPane.setCenter(empPanel);
        //create the box pane and place to the right
        lngBox = new VBox();
        //set the style
        lngBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        //set the title of box pane
        Text title = new Text("Major");
        lngBox.getChildren().add(title);
        lngBox.getChildren().addAll(rb1, rb2);
        //
        coursesBox = new VBox();
        Text coursesTitle = new Text("Courses");
        coursesBox.getChildren().add(coursesTitle);
        coursesBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        cbo = new ComboBox<>();

        ObservableList<String> items1=FXCollections.observableArrayList(courses1);
        ObservableList<String> items2=FXCollections.observableArrayList(courses2);




        cbo.setPrefSize(200, 50);
        lv = new ListView<>(FXCollections.observableArrayList());
        lv.setPrefSize(200, 200);

        // Display the selected country

        coursesBox.getChildren().addAll(cbo,lv);
        //
        east = new HBox();
        east.getChildren().addAll(lngBox,coursesBox);
        borderPane.setRight(east);

        //borderPane.setRight(lngBox);

        //set the scroll pane to the bottom of border pane
        borderPane.setBottom(scrollPane);
        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 600, 300);

        primaryStage.setTitle("Student Info"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        //Events
        rb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cbo.getItems().removeAll(items1);
                cbo.getItems().removeAll(items2);
                cbo.getItems().addAll(items1);
                lv.setItems(null);
                data.removeAll(data);
                lv.setItems(data);
                for (String value : coursesIT) {
                    data.add(value);
                }

                lv.setItems(data);
            }
        });

        rb2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cbo.getItems().removeAll(items1);
                cbo.getItems().removeAll(items2);
                cbo.getItems().addAll(items2);
                lv.setItems(null);
                data.removeAll(data);
                lv.setItems(data);

                for (String value : coursesIB) {
                    data.add(value);
                }
                lv.setItems(data);
            }
        });

        cbo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lv.setItems(null);
                data.removeAll(data);

                if(rb1.isSelected()){

                    if(coursesIT.contains(cbo.getValue())){
                        JOptionPane.showMessageDialog(null,"Class already added in the course");
                        for (String value : coursesIT) {
                            data.add(value);
                        }
                    } else {
                        if(cbo.getValue()!=null){
                            coursesIT.add(cbo.getValue());
                            for (String value : coursesIT) {
                                data.add(value);
                            }
                        }

                    }
                    lv.setItems(data);
                }
                else {

                    if(coursesIB.contains(cbo.getValue())){
                        JOptionPane.showMessageDialog(null,"Class already added in the course");
                        for (String value : coursesIB) {
                            data.add(value);
                        }
                    } else {
                        if(cbo.getValue()!=null){
                            coursesIB.add(cbo.getValue());
                            for (String value : coursesIB) {
                                data.add(value);
                            }
                        }

                    }
                    lv.setItems(data);

                }




            }
        });


    }


    // display entries in text area
    public void displayEntries()
    {
        ArrayList<String> showList = new ArrayList<>();
        //
        String name = txtName.getText();
        String address= txtAddress.getText();
        String province = txtProvince.getText();
        String city = txtCity.getText();
        String postalCode=txtPostalCode.getText();
        String phoneNumber=txtPhoneNumber.getText();
        String email=txtEmail.getText();

        tArea.appendText("\n"+name +" "+
                address +" "+
                province +" "+
                city +" "+
                postalCode +" "+
                phoneNumber +" "+
                email +". ");
        if (rb1.isSelected()) {
            tArea.appendText(" "+rb1.getText());
            showList = coursesIT;
        }
        if(rb2.isSelected()){
            tArea.appendText(" "+rb2.getText());
            showList = coursesIB;
        }

        if(chkVolunteer.isSelected())tArea.appendText(" | "+chkVolunteer.getText()+" | ");
        if(chkStudentCouncil.isSelected())tArea.appendText(" | "+chkStudentCouncil.getText()+" | ");

        tArea.appendText("\n Courses:\n");

        if(showList.isEmpty()){
            tArea.appendText("There are not classes to show");
        }
        else {
            for (String value: showList) {
                tArea.appendText(value+"\n");
            }


        }

    }
    //
    public void changeAppearance(Control control)
    {

        control.setStyle(
                "-fx-font: 16px Serif;"+
                        "-fx-font-weight: bold;"+
                        "-fx-text-fill: blue;" +
                        "-fx-background-color: #CCFF99;");

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);

    }

}
