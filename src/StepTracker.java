
import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();


    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.print("Введите номер месяца: ");// ввод и проверка номера месяца
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.print("Некорректный номер месяца");
            return;
        }

        System.out.print("Введите день от 1 до 30 (включительно): ");// ввод и проверка дня
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.print("Некорректный номер дня");
            return;
        }

        System.out.print("Введите количество шагов: ");// ввод и проверка количества шагов
        int stepAmount = scanner.nextInt();
        if (stepAmount < 1) {
            System.out.print("Некорректное количество шагов");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];// сохранение полученных данных
        monthData.days[dayNumber - 1] = stepAmount;
        System.out.println("Информация успешно сохранена!");
    }

    public int goalByStepsPerDay = 10000;

    void changeStepGoal() {
        System.out.print("Введите новую цель по количеству шагов в день: ");
        int goalByStepsPerDayInput = scanner.nextInt();
        if (goalByStepsPerDayInput < 1) {
            System.out.print("Введено некорректное количество шагов в качестве цели");
            return;
        }
        goalByStepsPerDay = goalByStepsPerDayInput;
        System.out.println("Цель по количеству шагов успешно изменена, новая цель: " + goalByStepsPerDay + " шагов!");
    }

    void printStatistic() {
        System.out.print("Введите число месяца: ");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.print("Некорректный номер месяца");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1]; // получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth();// получение суммы шагов за месяц
        int averageStepsFromMonth = monthData.getAverageStepsFromMonth(sumSteps);// получение среднего кол-ва шагов за месяц

        System.out.println("Статистика за месяц: " + monthNumber);
        monthData.printDaysAndStepsFromMonth();// вывод общей статистики по дням
        System.out.println("Сумма шагов за месяц: " + sumSteps);// вывод суммы шагов за месяц
        System.out.println("Максимальное пройденное количество шагов в текущем месяце: " + monthData.maxSteps());// вывод максимального пройденного количества шагов за месяц
        System.out.println("Среднее количество шагов в текущем месяце: " + averageStepsFromMonth);// вывод среднего пройденного количества шагов за месяц
        System.out.println("Пройдено в километрах: " + converter.convertToKm(sumSteps));// вывод пройденной за месяц дистанции в километрах
        System.out.println("Сожжено калорий: " + converter.convertStepsToKilocalories(sumSteps));// вывод количества сожжённых килокалорий за месяц
        System.out.println("Ваша лучшая серия за месяц: " + monthData.bestSeries(goalByStepsPerDay));// вывод лучшей серии
    }
}