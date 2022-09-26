import java.io.*;
import java.net.*;

public class DailyAdviceServer
{
    String[] adviceList = {"Ешьте меньшими порциями.", "Купите облегающие джинсы. Нет, они не делают Вас полнее.",
    "Два слова: не годится", "Будьте честны хотя бы сегодня. Скажите своему начальнику всё, что вы *на самом деле* о нём думаете.",
    "Возможно Вам стоит подобрать другую причёску."}; // СПИСОК СОВЕТОВ

    public void go() // МЕТОД ЗАПУСКА ПРОГРАММЫ
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(4242); // СОКЕТ СЕРВЕРА

            while (true) // БЕСКОНЕЧНЫЙ ЦИКЛ
            {
                Socket socket = serverSocket.accept(); // БЛОКИРУЕТ ПРИЛОЖЕНИЕ ДО ЗАПРОСА

                PrintWriter writer = new PrintWriter(socket.getOutputStream()); // ПОТОК ВЫСОКОГО УРОВНЯ
                String advice = getAdvice(); // СОВЕТ
                writer.println(advice); // ОТПРАВЛЯЕМ СТРОКУ С СОВЕТОМ
                writer.close(); // ЗАКРЫТИЕ ПОТОКА
                System.out.println(advice); // ВЫВОД СОВЕТА НА КОНСОЛЬ
            } // OUT OF LOOP
        }
        catch (IOException exception) // ОБРАБОТКА ИСКЛЮЧЕНИЙ
        {
            exception.printStackTrace(); // ВЫВОДИТ ПОЛНЫЙ ПУТЬ ОШИБКИ
        } // OUT OF TRY-CATCH
    } // OUT OF EXECUTION METHOD

    private String getAdvice() // МЕТОД ВЫБОРА СОВЕТА
    {
        int random = (int) (Math.random() * adviceList.length); // РАНДОМНОЕ ЧИСЛО ОТ 0 ДО 4.5 С ШАГОМ 0.5
        return adviceList[random]; // ВОЗВРАЩАЕТ РАНДОМНЫЙ СОВЕТ
    } // OUT OF METHOD

    public static void main(String[] args) // ОСНОВНОЙ МЕТОД
    {
        DailyAdviceServer server = new DailyAdviceServer(); // ЭКЗЕМПЛЯР КЛАССА СЕРВЕРА
        server.go(); // ЗАПУСК ПРОГРАММЫ
    } // OUT OF MAIN METHOD
} // OUT OF CLASS
