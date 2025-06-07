import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FelineTest {
    private final Feline feline = new Feline();

    @Test
    void eatMeatShouldReturnCarnivoreFoodTest() throws Exception{
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();

        assertNotNull(actual, "Список еды не должен быть null");
        assertEquals(expected, actual, "Feline.eatMeat() должен возвращать именно [Животные, Птицы, Рыба]");
    }

    @Test
    void getFamilyShouldReturnCatFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily(),
                "getFamily() у Feline должен вернуть строку \"Кошачьи\"");
    }

    @Test
    void getKittensNoArgsShouldReturnOneTest() {
        assertEquals(1, feline.getKittens(),
                "getKittens() без параметров должен возвращать 1");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 42})
    void getKittensWithArgShouldReturnThatNumberTest(int count) {
        assertEquals(count, feline.getKittens(count),
                "getKittens(count) должен возвращать count");
    }

    @Test
    void getKittensNegativeShouldReturnNegativeTest() {
        int negative = -3;
        assertEquals(negative, feline.getKittens(negative),
                "Если передать отрицательное, то getKittens(count) вернёт count (реализация не валидирует)");
    }

    @Test
    void eatMeatNoExceptionTestTest() {
        assertDoesNotThrow(feline::eatMeat,
                "Feline.eatMeat() не должен выбрасывать Exception при корректном аргументе");
    }


}
