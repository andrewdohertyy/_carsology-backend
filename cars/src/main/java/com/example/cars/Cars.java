package com.example.cars;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table (name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = new Random().nextLong();
    private String image;
    private String image2;
    private String image3;
    private String make;
    private String model;
    private String type;
    private long price;
    private long year;
    private long milage;
    private String fuelType;
    private String gearbox;
    private String description;
    private String shortDescription;



    public Cars(Long id, String image, String image2, String image3, String make, String model, String type, long price, long year, long milage, String fuelType, String gearbox, String description, String shortDescription) {

        this.id = id;
        this.image = image;
        this.image2 = image2;
        this.image3 = image3;
        this.make = make;
        this.model = model;
        this.type = type;
        this.price = price;
        this.year = year;
        this.milage = milage;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.description = description;
        this.shortDescription = shortDescription;

    }

    public long getMilage() {
        return milage;
    }

    public void setMilage(long milage) {
        this.milage = milage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Cars (){

    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String img) {
        this.image = img;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
