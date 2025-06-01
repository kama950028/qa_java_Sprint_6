import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CatTest {

    private Feline felineMock;
    private Cat cat;

    @BeforeEach
    void SetUp(){
        felineMock = Mockito.mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    void getSoundShouldReturnMeow() {
        assertEquals("Мяу", cat.getSound(), "getSound() должен возвращать \"Мяу\"");
    }

    @Test
    void getFoodShouldDelegateToFelineEatMeat() throws Exception {
        // Подготавливаем мок: пусть eatMeat() вернёт этот список
        List<String> expected = List.of("Животные", "Птицы");
        Mockito.when(felineMock.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();

        // Проверяем, что метод был действительно вызван
        Mockito.verify(felineMock).eatMeat();
        assertEquals(expected, actual, "Cat.getFood() должен вернуть тот же список, что и feline.eatMeat()");
    }

    @Test
    void getFoodShouldThrowIfFelineThrows() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));
        Exception ex = assertThrows(Exception.class, () -> cat.getFood(),
                "Если feline.eatMeat() бросает Exception, Cat.getFood() тоже должен бросить");
        assertEquals("Ошибка", ex.getMessage());
    }
}
