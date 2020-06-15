package pract.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pract.model.Photo;

@Repository
public interface ServicePhoto extends JpaRepository<Photo, Long> {
}
