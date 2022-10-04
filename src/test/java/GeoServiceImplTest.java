import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static ru.netology.geo.GeoServiceImpl.LOCALHOST;

@DisplayName("Tasting: GeoServiceImpl")
public class GeoServiceImplTest {

public GeoServiceImpl geoService = new GeoServiceImpl();

    @Test
    @DisplayName("Tasting LocationByIp")
    void LocationByIpLOCALHOST(){
        Location actualResult = geoService.byIp("127.0.0.1");
        Location expectedResult = new Location(null, null, null, 0);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Tasting LocationByIp")
    void LocationByIpMoscow(){
        Location actualResult = geoService.byIp("172.0.32.11");
        Location expectedResult = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Tasting LocationByIp")
    void LocationByIpNewYork(){
        Location actualResult = geoService.byIp("96.44.183.149");
        Location expectedResult = new Location("New York", Country.USA, " 10th Avenue", 32);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Tasting LocationByIp")
    void LocationByIpRussia(){
        Location actualResult = geoService.byIp("172.0.32.11");
        Location expectedResult = new Location("Moscow", Country.RUSSIA, null, 0);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Tasting LocationByIp")
    void LocationByIpUSA(){
        Location actualResult = geoService.byIp("96.44.183.149");
        Location expectedResult = new Location("New York", Country.USA, null,  0);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
