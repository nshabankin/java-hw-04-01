import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
    /*
      Тест-кейс: пользователь зарегистрирован и сумма меньше лимита.
      Зарегистрированные пользователи получают бонус в размере 3% от суммы.
      Лимит бонусных балов: 500.
     */
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
    /*
      Тест-кейс: пользователь зарегистрирован и сумма выше лимита.
      Зарегистрированные пользователи получают бонус в размере 3% от суммы.
      Лимит бонусных баллов: 500.
     */
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
    /*
      Тест-кейс: пользователь незарегистрирован и сумма меньше лимита.
      Незарегистрированные пользователи получают бонус в размере 1% от суммы.
      Лимит бонусных баллов: 500.
     */
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
    /*
      Тест-кейс: пользователь незарегистрирован и сумма выше лимита.
      Зарегистрированные пользователи получают бонус в размере 1% от суммы.
      Лимит бонусных баллов: 500.
     */
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }
}
