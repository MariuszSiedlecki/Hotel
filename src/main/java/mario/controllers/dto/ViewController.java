package mario.controllers.dto;

import mario.models.dto.HotelDto;
import mario.services.Dto.HotelServiceDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private HotelServiceDto hotelServiceDto;

    public ViewController(HotelServiceDto hotelServiceDto) {
        this.hotelServiceDto = hotelServiceDto;
    }

    @GetMapping("/home")
    public String getHomePage(Model model, @RequestParam(value = "info", required = false) String info) {
        model.addAttribute("info", info);
        model.addAttribute("hotels", hotelServiceDto.getHotels());
        return "index";
    }

    @GetMapping("/edit-page")
    public String getEditPage(@RequestParam(value = "uuid") String uuid, Model model) {
        HotelDto hotelDto = hotelServiceDto.getHotelByPartnerCode(uuid);
        model.addAttribute("hotel", hotelDto);
        return "editHotel";
    }

    @PostMapping("/edit")
    public String getEdit(@ModelAttribute HotelDto hotelDto, @RequestParam(name = "email") String email) {
        System.out.println(hotelDto);
        HotelDto before = hotelServiceDto.getHotelByPartnerCode(hotelDto.getPartnerCode());
        before.setTitle(hotelDto.getTitle());
        before.setCountry(hotelDto.getCountry());
        before.setRate(hotelDto.getRate());
        before.getAddress().setEmail(email);
        hotelServiceDto.updateHotel(before);
        String info = "Update is Success: " + before.getTitle();
        return "redirect:/home?info=" + info;
    }
}
