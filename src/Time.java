public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }

    public void add(String timeString) {
        // Assuming timeString is in the format HH:MM:SS
        String[] parts = timeString.split(":");
        int addHours = Integer.parseInt(parts[0]);
        int addMinutes = Integer.parseInt(parts[1]);
        int addSeconds = Integer.parseInt(parts[2]);

        this.seconds += addSeconds;
        this.minutes += addMinutes + this.seconds / 60;
        this.hours += addHours + this.minutes / 60;

        this.seconds %= 60;
        this.minutes %= 60;
        this.hours %= 24;
    }

    public String info() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void add(Time otherTime) {
        this.hours += otherTime.hours;
        this.minutes += otherTime.minutes;
        this.seconds += otherTime.seconds;

        if (this.seconds >= 60) {
            this.seconds -= 60;
            this.minutes++;
        }
        if (this.minutes >= 60) {
            this.minutes -= 60;
            this.hours++;
        }
        if (this.hours >= 24) {
            this.hours = this.hours - 24;

        }
    }
}