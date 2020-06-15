package pract.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pract.model.Equip;

@Repository
public interface ServiceEquip extends JpaRepository<Equip, Long> {
    @Query("select e from Equip e where e.codigo = :codigo")
    Equip findByCodigo(@Param("codigo") String codigo);
}
