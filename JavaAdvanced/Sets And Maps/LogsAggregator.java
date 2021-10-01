package SetsAndMapsAdvancedExercises;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Login> userData = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            userData.putIfAbsent(user, new Login(0, new TreeSet<>()));
            userData.get(user).setDuration(userData.get(user).getDuration() + duration);
            userData.get(user).getIps().add(ip);
        }

        userData.forEach((key, value) -> System.out.printf("%s: %d %s%n", key, value.getDuration(), value.getIps().toString()));
    }

    static class Login {
        private int duration;
        private final Set<String> ips;

        public Login(int duration, Set<String> ips) {
            this.duration = duration;
            this.ips = ips;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public Set<String> getIps() {
            return ips;
        }
    }
}
