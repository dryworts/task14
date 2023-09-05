import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(300, "книга", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        //сравниваем массивы
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveWhenProductNotExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(300, "книга", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        //repo.remove(777);

        //Product[] actual = repo.findAll();
        //Product[] expected = {product1, product2, product3};
        //сравниваем массивы
        //Assertions.assertArrayEquals(expected, actual);

        //применяем супер фантастический труднодогоняемый метод Хогвардса и тест не обрушится
        //делаем так, чтобы метод Assertions.assertArrayEquals(expected, actual); не упал в тестах
        //в качестве второго параметра передаем метод удаления продукта с айди 777
        //первый аргумент название класса исключения.
        // вторым аргументом () -> код который должен вызвать ошибку
        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(777));

    }


}
