package mario.models.dto;


import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDto {

    private String title;
    private String country;
    private String partnerCode;
    private String rate;
    private AddressDto address;
    private List<RoomDto> rooms;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("country", country)
                .append("partnerCode", partnerCode)
                .append("rate", rate)
                .append("address", address)
                .append("rooms", rooms)
                .toString();
    }
}
