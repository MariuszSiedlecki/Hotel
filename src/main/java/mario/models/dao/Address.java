package mario.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String streetNumber;

    @Email
    private String email;
    private String phone;
    private String url;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("city", city)
                .append("street", street)
                .append("streetNumber", streetNumber)
                .append("email", email)
                .append("phone", phone)
                .append("url", url)
                .append("hotel", hotel)
                .toString();
    }

    //------to jest już nie potrzebne
//    @Override
//    public String toString() {
//        return new StringJoiner(", ",  "", "")
//
//                .add("city='" + city + "'")
//                .add("street='" + street + "'")
//                .add("streetNumber='" + streetNumber + "'")
//                .add("email='" + email + "'")
//                .add("phone='" + phone + "'")
//                .add("url='" + url + "'")
//
//                .toString();
//    }
}
