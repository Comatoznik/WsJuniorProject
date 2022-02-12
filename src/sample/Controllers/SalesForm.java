package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import sample.Entitys.ClientEntity;
import sample.Entitys.HouseEntity;
import sample.Entitys.ObjectEntity;
import sample.Entitys.ReeltorEntity;
import sample.HibernateStart;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SalesForm {
    public int idreeltor;
    @FXML
    public ChoiceBox choicerel;
    @FXML
    public TextField earthsize;
    @FXML
    public ChoiceBox choicetype;
    @FXML
    public TextField height;
    @FXML
    public TextField city;
    @FXML
    public TextField street;
    @FXML
    public TextField numhouse;
    @FXML
    public TextField coordinate;
    @FXML
    public TextField numap;
    @FXML
    public TextField size;
    @FXML
    public TextField roomcount;
    @FXML
    public Button sale;
    @FXML
    public ComboBox comr;
    @FXML
    public ComboBox type;
    @FXML
    public Button sale1;

    @FXML
    public void salepress() {
        List<String> strings = new ArrayList<>();
        ArrayList<ReeltorEntity> rel = open();
        for (ReeltorEntity temp : rel){
            strings.add("Id: "+ temp.getId() + " " + temp.getName() +" " +  temp.getSurname() +" " + temp.getOthername() + " Комиссия: " + temp.getPer());

        }
        List<String> types = new ArrayList<>();
        types.add("Дом");
        types.add("Квартира");
        type.setItems(FXCollections.observableArrayList(types));
        comr.setItems(FXCollections.observableArrayList(strings));



    }
    public ArrayList<ReeltorEntity> open(){
        Session session = HibernateStart.getSession();
        Query query = session.createQuery("from ReeltorEntity ");
        return (ArrayList<ReeltorEntity>) query.getResultList();

}

@FXML
    public void sale1press(){
        if (type.getValue() == "Дом"){
            Session session = HibernateStart.getSession();
            session.beginTransaction();
            ClientEntity clientEntity = new ClientEntity();
            ReeltorEntity reeltorEntity = new ReeltorEntity();
            HouseEntity house = new HouseEntity();
            ObjectEntity obj = new ObjectEntity();
            obj.setCity(city.getText());
            obj.setStreet(street.getText());
            obj.setIdreeltor(reeltorEntity.getId());
            obj.setIdclient(clientEntity.getId());
            obj.setNumhouse(Integer.parseInt(numhouse.getText()));
            obj.setCoordinate(Integer.parseInt(coordinate.getText()));
            house.setHeight(Integer.parseInt(height.getText()));
            house.setRoomCount(Integer.parseInt(roomcount.getText()));
            house.setSize(Integer.parseInt(size.getText()));
            house.setSizeEarth(Integer.parseInt(roomcount.getText()));


            session.save(obj);
            session.save(house);
            session.getTransaction().commit();
            session.close();
        }

}



}
