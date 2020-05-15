package mario.services.Dto;

import mario.models.dto.HotelDto;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

//@RunWith(MockitoJUnitRunner.class)
class HotelServiceDtoTest {
//
//    @Mock
//    HotelRepository hotelRepository;
//
//    @InjectMocks
//    HotelServiceDto hotelServiceDto;


//
//    @Before
//    public void init(){
//        given(hotelServiceDto.getHotels()).willReturn(prepareMockData());
//        given(hotelServiceDto.getHotelsByCountry()).willReturn(prepareHotelDtosCountry());
//    }

    @Test
    void should_get_hotels_by_city() {
        //given
        HotelServiceDto hotelServiceDto = mock(HotelServiceDto.class);
        given(hotelServiceDto.getHotelsByCity(Mockito.any())).willReturn(prepareMockData());
        //when
        List<HotelDto> hotelDtoList = hotelServiceDto.getHotelsByCity("Krakow");
        //then
        Assert.assertThat(hotelServiceDto.getHotelsByCity("Krakow"), Matchers.hasSize(2));
    }


    private List<HotelDto> prepareMockData() {
        List<HotelDto> hotelList = new ArrayList<>();
        hotelList.add(new HotelDto("Krakow"));
        hotelList.add(new HotelDto("Warszawa"));
        return hotelList;
    }


    @Test
     void should_get_hotels_by_country(){
     HotelServiceDto hotelServiceDto = mock(HotelServiceDto.class);
     given(hotelServiceDto.getHotelsByCountry("")).willReturn(prepareHotelDtosCountry());

     List<HotelDto>hdt = hotelServiceDto.getHotelsByCountry("Polska");
     Assert.assertEquals(hdt,hotelServiceDto.getHotelsByCountry("USA"));

    }
    private List<HotelDto> prepareHotelDtosCountry () {
        List<HotelDto> listPrepare = new ArrayList<>();
        listPrepare.add(new HotelDto("Polska"));
        listPrepare.add(new HotelDto("USA"));
        return listPrepare;
    }
}
