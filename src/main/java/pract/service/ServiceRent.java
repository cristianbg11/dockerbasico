package pract.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pract.model.Rent;

import java.util.List;

@Repository
public interface ServiceRent extends JpaRepository<Rent, Long> {
    @Query(nativeQuery = true, value = "SELECT E.CODIGO, COUNT(AE.ALQUILER_ID) AS TOTAL FROM equipo E, alquiler_equipos AE WHERE AE.EQUIPO_ID = E.ID GROUP BY E.CODIGO")
    List<Object[]> getPromedioAlquileresPorDia();
}
