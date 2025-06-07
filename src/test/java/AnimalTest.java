import com.example.Animal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    @DisplayName("getFood(String) бросает Exception для неизвестного вида")
    void getFoodThrowsOnUnknownKindTest() {
        String invalidKind = "НеизвестнаяКатегория";
        Exception ex = assertThrows(Exception.class,
                () -> animal.getFood(invalidKind),
                "Ожидали, что для невалидного вида будет брошено Exception");
        assertTrue(ex.getMessage().contains("Неизвестный вид животного"),
                "Сообщение об ошибке должно упоминать «Неизвестный вид животного»");
    }

    @Test
    @DisplayName("getFamily() возвращает строку, начинающуюся с «Существует несколько семейств»")
    void getFamilyReturnsStaticStringTest() {
        String family = animal.getFamily();
        assertNotNull(family, "getFamily() не должен возвращать null");
        assertTrue(family.startsWith("Существует несколько семейств"),
                "getFamily() должен возвращать корректную описательную строку");
    }
}
