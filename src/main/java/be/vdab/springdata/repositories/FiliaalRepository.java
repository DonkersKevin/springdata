package be.vdab.springdata.repositories;

import be.vdab.springdata.entities.Filiaal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface FiliaalRepository extends JpaRepository<Filiaal, Long> {

    //JpaRepo geeft al een hoop queries, waarop verder gebouwd kan worden.
    //In dit geval:
/*    (1) Je gebruik List<Filiaal> als return type als de query meerdere filialen terug geeft.
                Je gebruikt Optional<Filiaal> als de query maximaal één filiaal teruggeeft.
            (2) Je begint de method altijd met findBy.
            (3) Je typt het filiaal attribuut waarop je een where onderdeel wil in de query: Gemeente.
            (4) Je geeft de method een parameter. Als je straks de method oproept, vermeld je hier
                de gemeente waarvan je filialen wil. Voorbeeld: findByGemeente("Brussel").*/

    List<Filiaal> findByGemeente(String gemeente);

    //sorteren
    List<Filiaal> findByGemeenteOrderByNaam(String gemeente);

    //Count
    int countByGemeente(String gemeente);

    //Sql query
    @Query("select avg(f.omzet) from Filiaal f")
    BigDecimal findGemiddeldeOmzet();

    //via Xml (in META-INF)
    List<Filiaal> findMetHoogsteOmzet();

}
