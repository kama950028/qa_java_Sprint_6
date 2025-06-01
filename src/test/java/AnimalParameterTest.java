import com.example.Animal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnimalParameterTest {

    private final Animal animal = new Animal();

    @ParameterizedTest(name = "Для вида «{0}» метод getFood возвращает {1}")
    @CsvSource({
            "Травоядное, [Трава, Различные растения]",
            "Хищник,     [Животные, Птицы, Рыба]"
    })
    @DisplayName("Animal.getFood возвращает правильный список для каждого типа")
    void getFoodValidKinds(String kind, String expectedListString) throws Exception {
        // Убираем скобки '[' и ']' по краям
        String withoutBrackets = expectedListString.replaceAll("^\\[|\\]$", "");
        // Разбиваем по запятой + возможный пробел
        String[] parts = withoutBrackets.split(",\\s*");
        List<String> expected = List.of(parts);

        List<String> actual = animal.getFood(kind);

        assertNotNull(actual, "Список пищи не должен быть null");
        assertEquals(expected, actual, () ->
                String.format("Для вида «%s» ожидали %s, но получили %s", kind, expected, actual)
        );
    }
}
