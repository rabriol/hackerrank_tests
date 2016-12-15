import java.util.*;

/**
 * Created by peo_rboliveira on 27/01/16.
 */
public class Fraud {
    public static void main(String[] args) {
        String[] strings = get(new String[]{
                "Shilpa|500|California|63",
                "Tom|25|New York|615",
                "Krasi|9000|California|1230",
                "Tom|25|New York|1235",
                "Tom|25|New York|1238",
                "Shilpa|50|Michigan|1300",
                "Matt|90000|Georgia|1305",
                "Jay|100000|Virginia|1310",
                "Krasi|49|Florida|1320",
                "Krasi|83|California|1325",
                "Shilpa|50|California|1350"});

        for (String n : strings) {
            System.out.println(n);
        }
    }

    public static String[] get(String[] transactions) {
        Map<String, Record> persons = new HashMap<>();

        LinkedHashSet<String> byLocationAndTime = new LinkedHashSet<>();
        LinkedHashSet<String> byAmount = new LinkedHashSet<>();

        for (int i = 0 ; i < transactions.length ; i++) {
            String[] line = transactions[i].split("\\|");

            Record record = new Record(line[0],
                    Integer.valueOf(line[1]),
                    line[2],
                    Integer.valueOf(line[3]));

            if (!persons.containsKey(record.getName())) {
                persons.put(record.getName(), record);

                if (record.getAmount() > 3000) {
                    byAmount.add(record.getName());
                }
            } else {
                if (!byAmount.contains(record.getName())) {
                    Record firstRecord = persons.get(record.getName());

                    if (!record.getLocation().equals(firstRecord.getLocation())
                            && getMinutesInterval(firstRecord.getTime(), record.getTime())) {
                        if (!byAmount.contains(record.getName())) {
                            byLocationAndTime.add(firstRecord.getName());
                        }
                    } else {
                        persons.put(record.getName(), record);
                    }
                }
            }
        }

        byAmount.addAll(byLocationAndTime);

        return byAmount.toArray(new  String[]{});
    }

    private static boolean getMinutesInterval(int timeOne, int timeTwo) {
        return timeTwo - timeOne < 60;
    }

    static class Record {
        private String name;
        private int amount;
        private String location;
        private int time;

        public Record(String name, int amount, String location, int time) {
            this.name = name;
            this.amount = amount;
            this.location = location;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
