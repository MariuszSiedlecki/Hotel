package mario.mappers;

import mario.UtilsMapper.Mapper;
import mario.models.dao.Room;
import mario.models.dto.RoomDto;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<Room, RoomDto> {
    @Override
    public RoomDto map(Room from) {
        return RoomDto
                .builder()
                .capacity(from.getCapacity())
                .bad(from.getBad())
                .type(from.getType())
                .build();
    }

    @Override
    public Room revers(RoomDto to) {
        return null;
    }
}
