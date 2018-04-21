package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue
    private String id;

    private String vinNumber;
    private String make;
    private String model;
    private String year;

    @JsonCreator
    public Vehicle(@JsonProperty("vinNumber")String vinNumber,
                   @JsonProperty("make")String make,
                   @JsonProperty("model")String model,
                   @JsonProperty("year")String year){
        this.vinNumber = vinNumber;
        this.make      = make;
        this.model     = model;
        this.year      = year;
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
