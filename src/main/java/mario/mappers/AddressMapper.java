package mario.mappers;

import mario.UtilsMapper.Mapper;
import mario.models.dao.Address;
import mario.models.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<Address, AddressDto> {
    @Override
    public AddressDto map(Address from) {
        return AddressDto
                .builder()
                .email(from.getEmail())
                .phone(from.getPhone())
                .url(from.getUrl())
                .postalAddress(from.getCity() + "," + from.getStreet() + "," + from.getStreetNumber())
                .build();
    }

    @Override
    public Address revers(AddressDto to) {
        return null;
    }
}
