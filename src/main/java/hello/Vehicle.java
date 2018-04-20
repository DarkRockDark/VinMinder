package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vinNumber;
    private String make;
    private String model;
    private String year;


    public Vehicle(Long id, String vin, String mk, String mo, String yr){
        this.id        = id;
        this.vinNumber = vin;
        this.make      = mk;
        this.model     = mo;
        this.year      = yr;
    }

    @Override
    public String toString() {
        return String.format(
                "Vehicle[id = %d, vin = '%s', make = '%s', model = '%s', year = '%s']",
                id, vinNumber, make, model, year);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
