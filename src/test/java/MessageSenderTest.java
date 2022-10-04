import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;
import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

@DisplayName("Tasting: MessageSender")
@ExtendWith(MockitoExtension.class)
public class MessageSenderTest {

    public static final String MOSCOW_IP = "172.123.12.19";
    public static final String NEW_YORK_IP = "96.44.183.149";

    @Mock
    private GeoService geoService;
    @Mock
    private LocalizationService localizationService;
    private MessageSenderImpl messageSender;

    @Test
    void sendRussia() {
        Mockito.when(geoService.byIp(Mockito.eq(MOSCOW_IP))).thenReturn(new Location("Moscow", RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Mockito.eq(RUSSIA))).thenReturn("Добро пожаловать");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, "172.123.12.19");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationService);
        String actualResult = messageSender.send(headers);
        String expectedResult = "Добро пожаловать";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void sendUSA() {
        Mockito.when(geoService.byIp(Mockito.eq(NEW_YORK_IP))).thenReturn(new Location("New York", USA, null,  0));
        Mockito.when(localizationService.locale(Mockito.eq(USA))).thenReturn("Welcome");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, "96.44.183.149");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationService);
        String actualResult = messageSender.send(headers);
        String expectedResult = "Welcome";
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
