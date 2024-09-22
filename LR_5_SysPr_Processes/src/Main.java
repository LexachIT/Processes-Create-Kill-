import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Количество раз, которое мы хотим открыть и закрыть
        int number = 3;
        for (int i = 0; i < number; i++) {
            Process process = null; // Переменная для хранения процесса

            try {
                // Создаем новый экземпляр ProcessBuilder
                ProcessBuilder builder = new ProcessBuilder();

                // Устанавливаем команду, которую хотим выполнить
                builder.command("notepad.exe");

                // Запускаем процесс Notepad
                process = builder.start();

                // Задержка, чтобы окно успело открыться
                // Задержка установлена в 100 миллисекунд
                Thread.sleep(1000);
            } catch (IOException e) {
                // Обработка ошибок ввода-вывода
                System.err.println("Ошибка при запуске : " + e.getMessage());
            } catch (InterruptedException e) {
                // Обработка ошибок прерывания потока
                System.err.println("Ошибка во время ожидания: " + e.getMessage());
            } finally {
                // Убедитесь, что процесс закрывается, если он был успешно запущен
                if (process != null) {
                    process.destroy(); // Завершаем процесс Notepad
                    try {
                        // Ждем, пока процесс завершится
                        process.waitFor();
                    } catch (InterruptedException e) {
                        System.err.println("Ошибка при ожидании завершения процесса: " + e.getMessage());
                    }
                }
            }
        }
        System.out.println("Все процессы были запущены и закрыты");
    }
}

