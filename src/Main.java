import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();

            int cmd = scanner.nextInt();
            switch (cmd) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    System.out.println("Работа приложения завершена, до свидания!");
                    return;
                default:
                    System.out.println("Введена неизвестная команда");
            }
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("Пожалуйста, выберите команду: ");
        System.out.println("1. Ввести количество шагов за определённый день.");
        System.out.println("2. Изменить цель по количеству шагов в день.");
        System.out.println("3. Напечатать статистику за определённый месяц.");
        System.out.println("4. Выйти из приложения.");
    }
}