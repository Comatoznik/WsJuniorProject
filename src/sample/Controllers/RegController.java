package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import sample.Entitys.ClientEntity;
import sample.Entitys.ReeltorEntity;
import sample.HibernateStart;

import java.sql.SQLIntegrityConstraintViolationException;


public class RegController {


    @FXML
    Button reg;

    @FXML
    TextField login;

    @FXML
    TextField pass;

    @FXML
    TextField Othername;

    @FXML
    TextField Phone;

    @FXML
    TextField Email;

    @FXML
    TextField percent;

    @FXML
    RadioButton client;

    @FXML
    RadioButton reeltor;

    @FXML
    Button auth;
    @FXML
    TextField logint;

    @FXML
    TextField passt;


    public void authcl() throws Exception {
        Stage stage = (Stage) auth.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/Authorize.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Другая форма");
        stage.setScene(new Scene(root1));
        stage.show();

    }


    public void clientpress() {
        Session session = HibernateStart.getSession();
        session.beginTransaction();
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(login.getText());
        clientEntity.setSurname(pass.getText());
        clientEntity.setOthername(Othername.getText());
        clientEntity.setPhone(Phone.getText());
        clientEntity.setEmail(Email.getText());
        clientEntity.setLogin(logint.getText());
        clientEntity.setPassword(passt.getText());

        session.save(clientEntity);
        session.getTransaction().commit();
        session.close();
        percent.setDisable(true);
        Phone.setDisable(false);
        Email.setDisable(false);
    }

    public void reeltpress()  {
        try {
            Session session = HibernateStart.getSession();
            session.beginTransaction();
            ReeltorEntity reeltor = new ReeltorEntity();
            reeltor.setName(login.getText());
            reeltor.setSurname(pass.getText());
            reeltor.setOthername(Othername.getText());
            reeltor.setPer(Integer.parseInt(percent.getText()));
            reeltor.setLogin(logint.getText());
            reeltor.setPassword(passt.getText());
            session.save(reeltor);
            session.getTransaction().commit();
            session.close();
            Phone.setDisable(true);
            Email.setDisable(true);
            percent.setDisable(false);
        }
        catch (ConstraintViolationException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Fatal Error : Duplicate Login!", ButtonType.OK);
            alert.show();
        }
    }
}
