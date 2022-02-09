package co.incubyte;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 to 100 characters")
    private String name;

    @Column(name = "rate")
    @NotBlank(message = "Rate cannot be blank")
    @Min(value = 1, message = "Rate should not be less than 1")
    @Max(value = 10000, message = "Age should not be greater than 10000")
    private double rate;

    @Column(name = "description")
    @Size(min = 2, max = 255, message = "Name must be between 2 to 255 characters")
    private String description;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", description='" + description + '\'' +
                '}';
    }
}