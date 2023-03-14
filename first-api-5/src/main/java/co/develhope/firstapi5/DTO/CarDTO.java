package co.develhope.firstapi5.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;



public class CarDTO {

    @NotBlank(message = "mandatory")
    private String id;
    @NotBlank(message = "mandatory")
    private String modelName;
    private double price;


    public  CarDTO(){}

    public CarDTO(String id, String modelName, double price) {
        this.id = id;
        this.modelName = modelName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id='" + id + '\'' +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    //@Data
//@AllArgsConstructor
//@NoArgsConstructor
//    @NotBlank (message="Mandatory!")
//    private String id;
//    @NotBlank (message="Mandatory!")
//    private String modelName;
//    private double price;
}
