package com.example.client;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class CustomController implements Initializable {
    @FXML
    private TextField loginGET;
    @FXML
    private TextField passwordGET;
    @FXML
    private TextField loginPOST;
    @FXML
    private TextField passwordPOST;
    @FXML
    private Button buttonPOST;
    @FXML
    private Button buttonGET;
    @FXML
    private Button buttonRegistration;
    @FXML
    private Button buttonAuthorization;
    @FXML
    private Button backButton;

    protected StringProperty loginPropertyGET() {
        return loginGET.textProperty();
    }
    public void setLoginGET(String value){
        loginPropertyGET().set(value);
    }

    public String getLoginGET() {
        return loginPropertyGET().get();
    }

    protected StringProperty passwordPropertyGET() {
        return passwordGET.textProperty();
    }
    public void setPasswordGET(String value){
        loginPropertyGET().set(value);
    }

    public String getPasswordGET() {
        return passwordPropertyGET().get();
    }

    protected StringProperty loginPropertyPOST() {
        return loginPOST.textProperty();
    }
    public void setLoginPOST(String value){
        loginPropertyPOST().set(value);
    }

    public String getLoginPOST() {
        return loginPropertyPOST().get();
    }

    protected StringProperty passwordPropertyPOST() {
        return passwordPOST.textProperty();
    }
    public void setPasswordPOST(String value){
        loginPropertyPOST().set(value);
    }

    public String getPasswordPOST() {
        return passwordPropertyPOST().get();
    }

    @FXML
    protected void testPOSTLogin() throws IOException {
        System.out.println("For the POST request");
        System.out.println("login is: " + getLoginPOST());
        System.out.println("pass is: " + getPasswordPOST());

        String string_url = "http://localhost:8080/autorization";
        URL url = new URL(string_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Java client");
        String args= "username=" + getLoginPOST() + "&password="+getPasswordPOST();
        byte[] data = args.getBytes(StandardCharsets.UTF_8);
        con.setDoOutput(true);
        try (var wr = new DataOutputStream((con.getOutputStream()))){
            wr.write(data);
        }
        catch (Exception e){
            System.out.println("Error:" + e);
        }

        StringBuffer response = new StringBuffer();
        int responsecode = con.getResponseCode();
        System.out.println("Response code: " + responsecode);
        System.out.println("\nSending GET: " + string_url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        String inputline;
        while((inputline = in.readLine()) != null){
            response.append(inputline);
        }
        in.close();
        con.disconnect();
        System.out.println(response.toString());
    }


    @FXML
    protected void testGETLogin() throws IOException {
        System.out.println("For the GET request");
        System.out.println("login is: " + getLoginGET());
        System.out.println("pass is: " + getPasswordGET());

        String string_url = "http://localhost:8080/autorization?username=" + getLoginGET() + "&password=" + getPasswordGET();
        URL url = new URL(string_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "text/html");

        StringBuffer response = new StringBuffer();
        int responsecode = con.getResponseCode();
        System.out.println("Response code: " + responsecode);
        System.out.println("\nSending GET: " + string_url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        String inputline;
        while((inputline = in.readLine()) != null){
            response.append(inputline);
        }
        in.close();
        con.disconnect();
        System.out.println(response.toString());
    }

    @FXML
    protected void testPOSTRegistration() throws IOException {
        System.out.println("For the POST request");
        System.out.println("login is: " + getLoginPOST());
        System.out.println("pass is: " + getPasswordPOST());

        String string_url = "http://localhost:8080/registration";
        URL url = new URL(string_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Java client");
        String args= "username=" + getLoginPOST() + "&password="+getPasswordPOST();
        byte[] data = args.getBytes(StandardCharsets.UTF_8);
        con.setDoOutput(true);
        try (var wr = new DataOutputStream((con.getOutputStream()))){
            wr.write(data);
        }
        catch (Exception e){
            System.out.println("Error:" + e);
        }

        StringBuffer response = new StringBuffer();
        int responsecode = con.getResponseCode();
        System.out.println("Response code: " + responsecode);
        System.out.println("\nSending GET: " + string_url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        String inputline;
        while((inputline = in.readLine()) != null){
            response.append(inputline);
        }
        in.close();
        con.disconnect();
        System.out.println(response.toString());
    }

    @FXML
    protected void testGETRegistration() throws IOException {
        System.out.println("For the POST request");
        System.out.println("login is: " + getLoginPOST());
        System.out.println("pass is: " + getPasswordPOST());

        String string_url = "http://localhost:8080/registration?username=" + getLoginGET() + "&password=" + getPasswordGET();
        URL url = new URL(string_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "text/html");

        StringBuffer response = new StringBuffer();
        int responsecode = con.getResponseCode();
        System.out.println("Response code: " + responsecode);
        System.out.println("\nSending GET: " + string_url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        String inputline;
        while((inputline = in.readLine()) != null){
            response.append(inputline);
        }
        in.close();
        con.disconnect();
        System.out.println(response.toString());
    }

    @FXML
    protected void redirect_to_authorization() throws IOException {
        Stage stage = (Stage) buttonAuthorization.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("authorization.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Authorization");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    protected void redirect_to_registration() throws IOException {
        Stage stage = (Stage) buttonRegistration.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Registration");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void redirect_to_select() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("select.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Select");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}