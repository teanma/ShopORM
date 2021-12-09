package org.iesfm.shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Item")
public class OrderLine implements Serializable {
    @Id
    @Column(name = "order_id")
    private int orderId;
    @Id
    @Column(name = "article_id")
    private int articleId;
    private int amount;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return orderId == orderLine.orderId && articleId == orderLine.articleId && amount == orderLine.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, articleId, amount);
    }
}
