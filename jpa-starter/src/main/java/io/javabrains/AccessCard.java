package io.javabrains;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isActive;
    private Date issuedDate;

    @OneToOne
    private Employee owner;
//(mappedBy = "accessCard")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", issuedDate=" + issuedDate +
                '}';
    }
}
