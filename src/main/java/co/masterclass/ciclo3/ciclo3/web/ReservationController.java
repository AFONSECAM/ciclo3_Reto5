package co.masterclass.ciclo3.ciclo3.web;

import co.masterclass.ciclo3.ciclo3.model.Reservation;
import co.masterclass.ciclo3.ciclo3.model.custom.CountClient;
import co.masterclass.ciclo3.ciclo3.model.custom.StatusAmount;
import co.masterclass.ciclo3.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservarion(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }

    //Reto 5
    @GetMapping("/report-status")
    public StatusAmount getReservationsStatus(){
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClients(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2){
        return reservationService.getReservationPeriod(d1, d2);
    }
}
