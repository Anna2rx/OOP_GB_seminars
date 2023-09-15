import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

enum GameStatus {
    IN_PROGRESS,
    PLAYER_WON,
    COMPUTER_WON
}

interface Game {
    void start();
    void inputValue(String value);
    GameStatus getGameStatus();
    void restart();
    List<String> getHistory();
}

abstract class AbstractGame implements Game {
    protected String word;
    protected List<String> history;
    
    protected String generateWord() {
        // генерация слова компьютера
        Random random = new Random();
        List<Character> charList = generateCharList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(charList.size());
            sb.append(charList.get(index));
            charList.remove(index);
        }
        return sb.toString();
    }
    
    protected abstract List<Character> generateCharList();
    
    public List<String> getHistory() {
        return history;
    }
}

class Answer {
    private int bulls;
    private int cows;
    
    public Answer(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }
    
    public int getBulls() {
        return bulls;
    }
    
    public int getCows() {
        return cows;
    }
}

class NumbersGame extends AbstractGame {
    private int attempts;
    private GameStatus gameStatus;
    
    @Override
    public void start() {
        word = generateWord();
        attempts = 0;
        gameStatus = GameStatus.IN_PROGRESS;
        history = new ArrayList<>();
        System.out.println("Игра началась. Компьютер загадал число из 4 различных цифр.");
    }
    
    @Override
    public void inputValue(String value) {
        if (value.length() != 4) {
            System.out.println("Введите четырехзначное число.");
            return;
        }
        
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < 4; i++) {
            char c = value.charAt(i);
            if (c == word.charAt(i)) {
                bulls++;
            } else if (word.contains(String.valueOf(c))) {
                cows++;
            }
        }
        
        attempts++;
        String message = "Попытка " + attempts + ": " + value + " - быки: " + bulls + ", коровы: " + cows;
        history.add(message);
        System.out.println(message);
        
        if (bulls == 4) {
            gameStatus = GameStatus.PLAYER_WON;
            System.out.println("Вы выиграли!");
        } else if (attempts >= 10) {
            gameStatus = GameStatus.COMPUTER_WON;
            System.out.println("Компьютер выиграл. Загаданное число: " + word);
        }
    }
    
    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    
    @Override
    public void restart() {
        start();
    }
    
    @Override
    protected List<Character> generateCharList() {
        List<Character> charList = new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            charList.add(c);
        }
        return charList;
    }
}

class EnglishLettersGame extends AbstractGame {
    private int attempts;
    private GameStatus gameStatus;
    
    @Override
    public void start() {
        word = generateWord();
        attempts = 0;
        gameStatus = GameStatus.IN_PROGRESS;
        history = new ArrayList<>();
        System.out.println("Игра началась. Компьютер загадал слово из 4 различных английских букв.");
    }
    
    @Override
    public void inputValue(String value) {
        if (value.length() != 4) {
            System.out.println("Введите четырехбуквенное слово.");
            return;
        }
        
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < 4; i++) {
            char c = value.charAt(i);
            if (c == word.charAt(i)) {
                bulls++;
            } else if (word.contains(String.valueOf(c

))) {
                cows++;
            }
        }
        
        attempts++;
        String message = "Попытка " + attempts + ": " + value + " - быки: " + bulls + ", коровы: " + cows;
        history.add(message);
        System.out.println(message);
        
        if (bulls == 4) {
            gameStatus = GameStatus.PLAYER_WON;
            System.out.println("Вы выиграли!");
        } else if (attempts >= 10) {
            gameStatus = GameStatus.COMPUTER_WON;
            System.out.println("Компьютер выиграл. Загаданное слово: " + word);
        }
    }
    
    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    
    @Override
    public void restart() {
        start();
    }
    
    @Override
    protected List<Character> generateCharList() {
        List<Character> charList = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            charList.add(c);
        }
        return charList;
    }
}

class RussianLettersGame extends AbstractGame {
    private int attempts;
    private GameStatus gameStatus;
    
    @Override
    public void start() {
        word = generateWord();
        attempts = 0;
        gameStatus = GameStatus.IN_PROGRESS;
        history = new ArrayList<>();
        System.out.println("Игра началась. Компьютер загадал слово из 4 различных русских букв.");
    }
    
    @Override
    public void inputValue(String value) {
        if (value.length() != 4) {
            System.out.println("Введите четырехбуквенное слово.");
            return;
        }
        
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < 4; i++) {
            char c = value.charAt(i);
            if (c == word.charAt(i)) {
                bulls++;
            } else if (word.contains(String.valueOf(c))) {
                cows++;
            }
        }
        
        attempts++;
        String message = "Попытка " + attempts + ": " + value + " - быки: " + bulls + ", коровы: " + cows;
        history.add(message);
        System.out.println(message);
        
        if (bulls == 4) {
            gameStatus = GameStatus.PLAYER_WON;
            System.out.println("Вы выиграли!");
        } else if (attempts >= 10) {
            gameStatus = GameStatus.COMPUTER_WON;
            System.out.println("Компьютер выиграл. Загаданное слово: " + word);
        }
    }
    
    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    
    @Override
    public void restart() {
        start();
    }
    
    @Override
    protected List<Character> generateCharList() {
        List<Character> charList = new ArrayList<>();
        for (char c = 'А'; c <= 'Я'; c++) {
            charList.add(c);
        }
        return charList;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        
        System.out.println("Выберите игру:");
        System.out.println("1. Числа");
        System.out.println("2. Английские буквы");
        System.out.println("3. Русские буквы");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                game = new NumbersGame();
                break;
            case 2:
                game = new EnglishLettersGame();
                break;
            case 3:
                game = new RussianLettersGame();
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }
        
        game.start();
        
        while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
            System.out.print("Введите значение: ");
            String value = scanner.next();
            game.inputValue(value);
        }
        
        System.out.println("Игра окончена.");
        
        if (game.getGameStatus() == GameStatus.PLAYER_WON) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Вы проиграли.");
        }
        
        System.out.println("История:");
        List<String> history = game.getHistory();
        for (String message : history) {
            System.out.println(message);
        }
        
        System.out.println("Хотите сыграть еще раз? (да/нет)");
        String playAgain = scanner.next();
        
        if (playAgain.equalsIgnoreCase("да")) {
            game.restart();
        } else {
            System.out.println("Спасибо за игру!");
        }
    }
}