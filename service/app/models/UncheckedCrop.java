package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class UncheckedCrop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float area;

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Long price;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date starttime;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date endtime;

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date bidendtime;

    public Date getBidendtime() {
        return bidendtime;
    }

    public void setBidendtime(Date bidendtime) {
        this.bidendtime = bidendtime;
    }

    public String transport;

    public String getTransport() { return transport;}

    public void setTransport(String transport) { this.transport = transport; }

    public String description;

    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description; }

    public Float quantitymin;

    public Float getQuantitymin() {
        return quantitymin;
    }

    public void setQuantitymin(Float quantitymin) {
        this.quantitymin = quantitymin;
    }

    public Float quantitymax;

    public Float getQuantitymax() {
        return quantitymax;
    }

    public void setQuantitymax(Float quantitymax) {
        this.quantitymax = quantitymax;
    }
    
    public Long fid;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long advPayment;

    public Long getAdvPayment() {
        return advPayment;
    }

    public void setAdvPayment(Long advPayment) {
        this.advPayment = advPayment;
    }

    public Float harvestedQuantity;

    public Float getHarvestedQuantity() {
        return harvestedQuantity;
    }

    public void setHarvestedQuantity(Float harvestedQuantity) {
        this.harvestedQuantity = harvestedQuantity;
    }

    public Long totalPayable;

    public Long getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(Long totalPayable) {
        this.totalPayable = totalPayable;
    }

}





















