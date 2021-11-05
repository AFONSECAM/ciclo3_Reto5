package co.masterclass.ciclo3.ciclo3.service;

import co.masterclass.ciclo3.ciclo3.model.Reservation;
import co.masterclass.ciclo3.ciclo3.model.custom.CountClient;
import co.masterclass.ciclo3.ciclo3.model.custom.StatusAmount;
import co.masterclass.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()) {
                return reservationRepository.save(r);
            } else {
                return r;
            }
        }
    }

    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()) {
                if (r.getStartDate() != null) {
                    raux.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    raux.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    raux.get().setStatus(r.getStatus());
                }
                if (r.getScore() != null) {
                    raux.get().setScore(r.getScore());
                }
                if (r.getQuadbike() != null) {
                    raux.get().setQuadbike(r.getQuadbike());
                }
                if (r.getClient() != null) {
                    raux.get().setClient(r.getClient());
                }
                reservationRepository.save(raux.get());
                return raux.get();
            } else {
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean delete(int id){
        Boolean rBoolean = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return rBoolean;
    }

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public StatusAmount getStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        StatusAmount stsAmount = new StatusAmount(completed.size(), cancelled.size());
        return stsAmount;
    }

    public List<Reservation> getReservationPeriod(String date1, String date2){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try{
            dateOne = parser.parse(date1);
            dateTwo = parser.parse(date2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationsPeriod(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
}
