import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

@DisplayName("Tasting: LocalizationServiceImpl")
public class LocalizationServiceImplTest {

    public LocalizationServiceImpl LocalizationService = new LocalizationServiceImpl();

    @Test
    @DisplayName("Tasting LocalizationRUSSIA")
    void LocationRUSSIA(){
        String actualResult = LocalizationService.locale(RUSSIA);
        String expectedResult = "Добро пожаловать";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Tasting LocalizationUSA")
    void LocationUSA(){
        String actualResult = LocalizationService.locale(USA);
        String expectedResult = "Welcome";
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
