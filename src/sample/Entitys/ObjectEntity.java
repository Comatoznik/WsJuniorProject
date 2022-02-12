package sample.Entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "object", schema = "wsjunior", catalog = "")
public class ObjectEntity {
    private int id;
    private String city;
    private String street;
    private Integer numhouse;
    private Integer numap;
    private Integer coordinate;
    private Integer idreeltor;
    private int idclient;

    @Id
    @OneToOne
    @JoinColumn(table = "house", name = "idObject")
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city", nullable = true, length = -1)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street", nullable = true, length = -1)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "numhouse", nullable = true)
    public Integer getNumhouse() {
        return numhouse;
    }

    public void setNumhouse(Integer numhouse) {
        this.numhouse = numhouse;
    }

    @Basic
    @Column(name = "Coordinate", nullable = true)
    public Integer getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }

    @Basic
    @Column(name = "idreeltor", nullable = true)
    public Integer getIdreeltor() {
        return idreeltor;
    }

    public void setIdreeltor(Integer idreeltor) {
        this.idreeltor = idreeltor;
    }

    @Basic
    @Column(name = "idclient", nullable = false)
    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectEntity that = (ObjectEntity) o;
        return id == that.id &&
                idclient == that.idclient &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(numhouse, that.numhouse) &&
                Objects.equals(numap, that.numap) &&
                Objects.equals(coordinate, that.coordinate) &&
                Objects.equals(idreeltor, that.idreeltor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, numhouse, numap, coordinate, idreeltor, idclient);
    }
}
