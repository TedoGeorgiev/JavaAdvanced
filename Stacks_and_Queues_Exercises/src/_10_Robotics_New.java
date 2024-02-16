import java.util.*;

public class _10_Robotics_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> robotsMap = new LinkedHashMap<>();
        String [] arrayRobots = scanner.nextLine().split(";");
        fillMap(arrayRobots, robotsMap);

        String [] setTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(setTime[0]);
        int minutes = Integer.parseInt(setTime[1]);
        int seconds = Integer.parseInt(setTime[2]);

        int timeInSeconds = hours * 3600 + minutes * 60 + seconds;

        Deque<String> productQueue = new ArrayDeque<>();
        int [] workTime = new int[robotsMap.size()];

        String product = scanner.nextLine();
        while (!"End".equals(product)) {
            productQueue.offer(product);
            product = scanner.nextLine();
        }

        while (!productQueue.isEmpty()) {
            String currentProduct = productQueue.poll();
            timeInSeconds++;
            boolean isAssigned = false;

            for (int i = 0; i < workTime.length; i++) {
                if (workTime[i] > 0) {
                    --workTime[i];
                }
            }

            for (int i = 0; i < workTime.length; i++) {
                if (workTime[i] == 0) {
                    int count = 0;

                    for (Map.Entry<String, Integer> robot : robotsMap.entrySet()) {
                        if (count == i) {
                            workTime[i] = robot.getValue();

                            int takenHour = timeInSeconds / 3600 % 24;
                            int takenMinute = timeInSeconds % 3600 / 60;
                            int takenSeconds = timeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct,
                                    takenHour, takenMinute, takenSeconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!isAssigned) {
                productQueue.offer(currentProduct);
            }

        }
    }

    private static void fillMap(String[] arrayRobots, LinkedHashMap<String, Integer> robotsMap) {
        for (String robot : arrayRobots) {
            String name = robot.split("-")[0];
            int time = Integer.parseInt(robot.split("-")[1]);
            robotsMap.put(name, time);
        }
    }
}
