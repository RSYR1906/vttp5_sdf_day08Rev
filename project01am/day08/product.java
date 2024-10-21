package project01am.day08;

import java.util.*;

public class product {

    long id;
    String prodName;
    String prodDesc;
    String prodCategory;
    Float price;
    Date createdDate;

    public product(long id, String prodName, String prodDesc, String prodCategory, Date createdDate, float price) {
        this.id = id;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodCategory = prodCategory;
        this.price = price;
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "product [id=" + id + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodCategory="
                + prodCategory + ", createdDate=" + createdDate + "]";
    }

}
