package com.balaji.vehicles.demo.model;//#endregion;
import javax.persistence.*;
@Entity
@Table(name = "vehicles")
public class vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;
    @Column(name = "year")
    public int year;
    @Column(name = "make")
    public String make;
    @Column(name="model")
    public String model;
    public vehicle(long id,int year, String make, String model){
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
    }
    public long getId() {
		return id;
	}
    public void setId(long id){
        this.id = id;
    }
    public int getyear() {
		return year;
	}
    public void setyear(int year){
        this.year = year;
    }
    public String getmake() {
		return make;
	}
    public void setmake(String make){
        this.make = make;
    }
    public String getmodel() {
		return model;
	}
    public void setmodel(String model){
        this.model = model;
    }
    public String toveh() {
		return "Vehicle [id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + "]";
	}
}
