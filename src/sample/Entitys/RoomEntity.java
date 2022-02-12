package sample.Entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "wsjunior", catalog = "")
public class RoomEntity {
    private int idRoom;
    private Integer countRooms;
    private Integer height;
    private Integer size;
    private Integer idObject;

    @Id
    @Column(name = "IdRoom", nullable = false)
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "CountRooms", nullable = true)
    public Integer getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(Integer countRooms) {
        this.countRooms = countRooms;
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
    @Column(name = "size", nullable = true)
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
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
        RoomEntity that = (RoomEntity) o;
        return idRoom == that.idRoom &&
                Objects.equals(countRooms, that.countRooms) &&
                Objects.equals(height, that.height) &&
                Objects.equals(size, that.size) &&
                Objects.equals(idObject, that.idObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, countRooms, height, size, idObject);
    }
}
