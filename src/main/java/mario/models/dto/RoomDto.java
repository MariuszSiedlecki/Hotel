package mario.models.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {

    private String type;
    private String bad;
    private String capacity;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("bad", bad)
                .append("capacity", capacity)
                .toString();
    }
}
