package co.masterclass.ciclo3.ciclo3.repository.crud;

import co.masterclass.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStatus(String status);
    @Query("SELECT r.client, COUNT(r.client) FROM Reservation AS r GROUP BY r.client ORDER BY COUNT(r.client) DESC")
    public List<Object[]> countTotalReservationByClient();
}
