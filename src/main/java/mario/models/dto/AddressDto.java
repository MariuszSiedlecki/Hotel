package mario.models.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {


    private String postalAddress;
    //usprawnienie aby w jednej lini było miasto, ulica , numer ulicy
//    private String street;
//    private String streetNumber;
    private String email;
    private String phone;
    private String url;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("postalAddress", postalAddress)
                .append("email", email)
                .append("phone", phone)
                .append("url", url)
                .toString();
    }
}
