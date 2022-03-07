/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication_jamie;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button jamie1;
    @FXML
    private Button jamie2;
    @FXML
    private TextField textName;
    @FXML
    private Button PrintData;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initializeing.....");
    }

    @FXML
    private void PrintJJamie(ActionEvent event) {

    }

    @FXML
    private void PrintJamie2(ActionEvent event) {
        System.out.println(textName.getText());
    }

    void PrintData(String Id) {
        try {
            JasperReport JR;
            JasperPrint JP;
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // String Q="%"+this.txtSearch.getText() +"%";
            // String Source="C:\\Users\\JAMIEXXX3\\Documents\\NetBeansProjects\\Phonelist\\src\\Forms\\report1.jrxml";
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\reports\\\\Jamie.jrxml");
            String Location = System.getProperty("user.dir") + "\\\\reports\\\\";

            String SQL = "SELECT * FROM dcaa_databse.student_info where id='" + Id + "'";

            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);

            JP = JasperFillManager.fillReport(JR, null, DBConnection.getConnection());

            JasperViewer.viewReport(JP, false);
        } catch (JRException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void PrintAta_Action(ActionEvent event) {
        String Id = textName.getText();

        PrintData(Id);

    }
}
