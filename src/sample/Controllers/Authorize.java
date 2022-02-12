package sample.Controllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import sample.Entitys.ClientEntity;
import sample.Entitys.ReeltorEntity;
import sample.HibernateStart;

import javax.persistence.Query;
import java.util.List;


public class Authorize {
    @FXML
    TextField surname;

    @FXML
    TextField name;

    @FXML
    Button auth;

    @FXML
    Button auth1;

    @FXML
    public void authclick() throws Exception {

        boolean a = getUser(surname.getText()) ;
        if (a) {
            name.setText("passed");
            Stage stage = (Stage) auth.getScene().getWindow();
            // do what you have to do
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/SalesForm.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Форма авторизации");
            stage.setScene(new Scene(root1));
            SalesForm salesForm = new SalesForm();

            stage.show();
        } else {
            name.setText(("no"));
        }
    }

    @FXML
    public void auth1click() {
        boolean a = getReeltor(surname.getText());
        if (a) {
            name.setText("passed1");
        } else {
            name.setText(("no1"));
        }
    }
//    public int saveid(ClientEntity clientEntity){
//        return clientEntity.getId();
//    }

    public boolean getUser(String login) {

        Session session = HibernateStart.getSession();
        Criteria userCriteria = session.createCriteria(ClientEntity.class);
        userCriteria.add(Restrictions.eq("login", login));
        ClientEntity clientEntity = (ClientEntity) userCriteria.uniqueResult();
       // saveid(clientEntity);
        if (clientEntity.getLogin().equals(surname.getText()) && clientEntity.getPassword().equals(name.getText())) {
            return true;

        } else {
            return false;
        }


    }

    public boolean getReeltor(String login) {

        Session session = HibernateStart.getSession();
        Criteria userCriteria = session.createCriteria(ReeltorEntity.class);
        userCriteria.add(Restrictions.eq("login", login));

        ReeltorEntity reeltorEntity = (ReeltorEntity) userCriteria.uniqueResult();

        if (reeltorEntity.getLogin().equals(surname.getText()) && reeltorEntity.getPassword().equals(name.getText())) {
            return true;

        } else {
            return false;
        }


    }
}

    

