package org.iesfm.shop;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Shop_Order")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "order_date")
    private Date date;

    @OneToMany
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderLine> lines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && clientId == order.clientId && Objects.equals(date, order.date) && Objects.equals(lines, order.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, date, lines);
    }
}
