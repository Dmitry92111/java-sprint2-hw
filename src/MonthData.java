public class MonthData {
    public int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i] + " шагов");
        }
    }

    int sumStepsFromMonth() { // получение суммы шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int getAverageStepsFromMonth(int sumSteps) {
        return sumSteps / days.length;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (finalSeries < currentSeries) {
                finalSeries = currentSeries;
            }
        }
        return finalSeries;
    }
}