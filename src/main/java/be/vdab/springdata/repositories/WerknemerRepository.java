package be.vdab.springdata.repositories;

import be.vdab.springdata.entities.Werknemer;
import be.vdab.springdata.projections.AantalWerknemersPerFamilienaam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    List<Werknemer> findByFiliaalGemeente(String gemeente);

    //@EntityGraph?, JPA query N+1
    @EntityGraph(value = "Werknemer.metFiliaal")
    List<Werknemer> findByVoornaamStartingWith(String woord);


    /*De method naam is gelijk aan de named query die je toevoegde aan orm.xml.
    Als je de method oproept, zal Spring data dus die named query uitvoeren.
    Spring Data ziet dat het returntype een List met objecten is die de interface
    AantalWerknemersPerFamilienaam implementeren. Spring Data maakt at runtime
    een class die deze interface implementeert en vult de List met objecten van die class.*/
    List<AantalWerknemersPerFamilienaam> findAantalWerknemersPerFamilienaam();


    //Voorbeeld pagineren op eigen methode
    Page<Werknemer> findByVoornaam(String voornaam, Pageable pageable);
}
