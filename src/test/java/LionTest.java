import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LionTest {

    private Feline felineMock;

    @BeforeEach
    void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    void constructorShouldSetHasManeCorrectlyTest() throws Exception {
        Lion maleLion = new Lion("Самец", felineMock);
        assertTrue(maleLion.doesHaveMane(), "Для 'Самец' у льва должна быть грива (true)");

        Lion femaleLion = new Lion("Самка", felineMock);
        assertFalse(femaleLion.doesHaveMane(), "Для 'Самка' грива отсутствует (false)");
    }

    @Test
    void constructorShouldThrowOnInvalidSexTest() {
        Exception ex = assertThrows(Exception.class,
                () -> new Lion("Неизвестно", felineMock),
                "Если передать не 'Самец' и не 'Самка', должен бросаться Exception");
        assertTrue(ex.getMessage().contains("Используйте допустимые значения пола"),
                "Сообщение об ошибке должно содержать инструкцию по правильному полу");
    }

    @Test
    void getKittensReturnsValueFromFelineTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int kittensCount = lion.getKittens();
        assertEquals(1, kittensCount, "Lion.getKittens() должен вернуть то же, что и feline.getKittens()");
    }

    @Test
    void getKittensCallsFelineGetKittensTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        lion.getKittens();
        Mockito.verify(felineMock).getKittens();
    }


    @Test
    void getFoodReturnsEatMeatResultTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood, "Lion.getFood() должен вернуть список от feline.eatMeat()");
    }

    @Test
    void getFoodCallsEatMeatOnFelineTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lion.getFood();
        Mockito.verify(felineMock).eatMeat();
    }

    @Test
    void getFoodThrowsExceptionIfFelineThrowsTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Кошка голодна"));

        assertThrows(Exception.class, lion::getFood,
                "Lion.getFood() должен выбросить Exception, если feline.eatMeat() кидает исключение");
    }

    @Test
    void getFoodThrowsExceptionWithCorrectMessageTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Кошка голодна"));

        Exception ex = assertThrows(Exception.class, lion::getFood);
        assertEquals("Кошка голодна", ex.getMessage(),
                "Lion.getFood() должен выбрасывать Exception с сообщением 'Кошка голодна'");
    }


}
