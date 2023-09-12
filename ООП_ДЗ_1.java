import java.util.*;

class Product {
  private String name;
  private double price;
  private int rating;

  public Product(String name, double price, int rating) {
    this.name = name;
    this.price = price;
    this.rating = rating;
  }

  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}

class Category {
  private String name;
  private Product[] products;

  public Category(String name, Product[] products) {
    this.name = name;
    this.products = products;
  }

  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }
}

class Basket {
  private Product[] products;

  public Basket() {
    // При создании корзины инициализируем пустым массивом
    this.products = new Product[0];
  }

  // Геттеры и сеттеры для переменной products
  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  // Метод для добавления товара в корзину
  public void addProduct(Product product) {
    // Создаем новый массив, в котором увеличиваем его размер на 1
    Product[] newProducts = new Product[products.length + 1];
    // Копируем все элементы из старого массива в новый
    for (int i = 0; i < products.length; i++) {
      newProducts[i] = products[i];
    }
    // Добавляем новый товар в последнюю позицию
    newProducts[products.length] = product;
    // Обновляем массив товаров в корзине
    products = newProducts;
  }

  // Метод для удаления товара из корзины
  public void removeProduct(Product product) {
    // Создаем новый массив, в котором уменьшаем его размер на 1
    Product[] newProducts = new Product[products.length - 1];
    int index = -1;
    // Находим индекс товара, который нужно удалить
    for (int i = 0; i < products.length; i++) {
      if (products[i].equals(product)) {
        index = i;
        break;
      }
    }
    // Копируем все элементы из старого массива в новый, кроме удаляемого товара
    for (int i = 0, j = 0; i < products.length; i++) {
      if (i != index) {
        newProducts[j] = products[i];
        j++;
      }
    }
    // Обновляем массив товаров в корзине
    products = newProducts;
  }
}

class User {
  private String login;
  private String password;
  private Basket basket;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
    this.basket = new Basket();
  }

  
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Basket getBasket() {
    return basket;
  }

  public void setBasket(Basket basket) {
    this.basket = basket;
  }
}

public class MyClass {
  public static void main(String[] args) {
    // Создаем несколько объектов класса Товар
    Product product1 = new Product("Товар 1", 10.0, 4);
    Product product2 = new Product("Товар 2", 20.0, 3);

    // Создаем массив товаров для первой категории
    Product[] category1Products = {
      product1,
      product2
    };

    // Создаем объекты класса Категория
    Category category1 = new Category("Категория 1", category1Products);

    // Выводим на консоль каталог продуктов
    System.out.println("Каталог продуктов:");
    System.out.println("Категория: " + category1.getName());
    for (Product product: category1.getProducts()) {
      System.out.println("Товар: " + product.getName() + ", Цена: " + product.getPrice() + ", Рейтинг: " + product.getRating());
    }

    // Создаем объекты класса User
    User user1 = new User("user1", "password1");
    User user2 = new User("user2", "password2");

    // Добавляем товары в корзину пользователей
    user1.getBasket().addProduct(product1);
    user2.getBasket().addProduct(product2);

    // Выводим на консоль покупки посетителей магазина
    System.out.println("\nПокупки посетителей магазина:");
    System.out.println("Пользователь " + user1.getLogin() + " купил:");
    for (Product product: user1.getBasket().getProducts()) {
      System.out.println("Товар: " + product.getName() + ", Цена: " + product.getPrice() + ", Рейтинг: " + product.getRating());
    }
    System.out.println("Пользователь " + user2.getLogin() + " купил:");
    for (Product product: user2.getBasket().getProducts()) {
      System.out.println("Товар: " + product.getName() + ", Цена: " + product.getPrice() + ", Рейтинг: " + product.getRating());
    }
  }
}