package jim.api.personaddress.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(1)
    private int streetNumber;

    @NotBlank(message = "street cannot be left blank")
    private String street;

    @Size(min = 1, max = 10)
    @Column(columnDefinition = "varchar(255) default 'N/A'")
    private String city;

    @Pattern(regexp = "^[A-Z]{2}$")
    @Column(columnDefinition = "char(2) default 'XX'")
    private String state;

    @NotNull
    @Column(columnDefinition = "char(5) default '00000'")
    private String zip;

    public Address() {
    }

    public Address(Integer id, int streetNumber, String street, String city, String state, String zip) {
        this.id = id;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetNumber=" + streetNumber +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
