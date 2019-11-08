package pkg3layermvc.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg3layermvc.be.Movie;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pkg3layermvc.dal.MovieDAL;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class AppController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private ListView<Movie> firststView;

    private AppModel model = new AppModel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try
        {
            MovieDAL movieDAL = new MovieDAL();
            List<Movie> allMovies = movieDAL.getAllMovies();
            ObservableList<Movie> obsAllMovies = FXCollections.observableArrayList(allMovies);
            firststView.setItems(obsAllMovies);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        model.fetchData();
    }
    
}
