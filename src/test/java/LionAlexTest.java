import com.example.Feline;
import com.example.LionAlex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LionAlexTest {
    @Test
    @DisplayName("Конструктор Alex не бросает исключений и корректно вызывает родительский конструктор")
    void constructorDoesNotThrowTest() {
        assertDoesNotThrow(() -> new LionAlex(new Feline()),
                "Создание объекта Alex должно проходить без ошибок");
    }

    @Test
    @DisplayName("getKittens() у Alex всегда возвращает 0")
    void getKittensReturnsZeroTest() throws Exception {
        LionAlex lionAlex = new LionAlex(new Feline());
        assertEquals(0, lionAlex.getKittens(),
                "У Алекса нет львят, метод getKittens() должен вернуть 0");
    }

    @Test
    @DisplayName("Alex.is Male: doesHaveMane() наследуется от Lion и должно вернуть true")
    void doesHaveManeIsTrueTest() throws Exception {
        LionAlex lionAlex = new LionAlex(new Feline());
        assertTrue(lionAlex.doesHaveMane(), "У льва-самца должна быть грива, doesHaveMane() == true");
    }

    @Test
    @DisplayName("getFood() у Alex делегирует Feline.eatMeat() (проверка basic)")
    void getFoodDelegatesToFelineTest() throws Exception {
        LionAlex lionAlex = new LionAlex(new Feline());
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lionAlex.getFood();
        assertEquals(expected, actual,
                "Alex.getFood() должен вернуть тот же список, что и feline.eatMeat()");
    }

    @Test
    @DisplayName("getFriends() возвращает список друзей Alex-а")
    void getFriendsReturnsCorrectListTest() throws Exception {
        LionAlex lionAlex = new LionAlex(new Feline());
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, lionAlex.getFriends(),
                "Список друзей Алекса должен быть [\"Марти\", \"Глория\", \"Мелман\"]");
    }

    @Test
    @DisplayName("getPlaceOfLiving() возвращает «Нью-Йоркский зоопарк»")
    void getPlaceOfLivingReturnsZooTest() throws Exception {
        LionAlex lionAlex = new LionAlex(new Feline());
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving(),
                "Место жительства Алекса должно быть \"Нью-Йоркский зоопарк\"");
    }

}
