package sample.Entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house", schema = "wsjunior", catalog = "")
public class HouseEntity {
    private int idHouse;
    private Integer height;
    private Integer roomCount;
    private Integer size;
    private Integer sizeEarth;
    private Integer idObject;

    @Id
    @Column(name = "IdHouse", nullable = false)
    public int getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(int idHouse) {
        this.idHouse = idHouse;
    }

    @Basic
    @Column(name = "Height", nullable = true)
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "RoomCount", nullable = true)
    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    @Basic
    @Column(name = "Size", nullable = true)
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
    @Column(name = "SizeEarth", nullable = true)
    public Integer getSizeEarth() {
        return sizeEarth;
    }

    public void setSizeEarth(Integer sizeEarth) {
        this.sizeEarth = sizeEarth;
    }

    @OneToOne
    @JoinColumn(table = "object", name = "Id")
    @Column(name = "idObject", nullable = true)
    public Integer getIdObject() {
        return idObject;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseEntity that = (HouseEntity) o;
        return idHouse == that.idHouse &&
                Objects.equals(height, that.height) &&
                Objects.equals(roomCount, that.roomCount) &&
                Objects.equals(size, that.size) &&
                Objects.equals(sizeEarth, that.sizeEarth) &&
                Objects.equals(idObject, that.idObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHouse, height, roomCount, size, sizeEarth, idObject);
    }
}
