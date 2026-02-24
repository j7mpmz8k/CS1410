//import java.util.TimeZone;

import java.util.TimeZone;

public class JulianDate {
    private int year;
    private int month;
    private int day;

    public JulianDate() {
        year = 1;
        month = 1;
        day = 1;
        addDays(719164);
        addDays((int)((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86_400_000));
    }
    public JulianDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            this.day++;
            if (this.day > getNumberOfDaysInMonth(this.year, this.month)) {
                this.day = 1;
                this.month++;
            }
            if (this.month > 12) {
                this.month = 1;
                this.year++;
                if (this.year == 0) {
                    this.year = 1;
                }
            }
        }
    }
    public void subtractDays(int days) {
        for (int i = 0; i < days; i++) {
            this.day--;
            if (this.day == 0) {
                this.month--;
                if (this.month == 0) {
                    this.month = 12;
                    this.year--;
                    if (this.year == 0) {
                        this.year = -1;
                    }
                }
                this.day = getNumberOfDaysInMonth(this.year, this.month);
            }
        }
    }
    public boolean isLeapYear() {
        return isLeapYear(this.year);
    }
    public void printShortDate() {
        // mm/dd/yyyy format
        System.out.printf("%d/%d/%d",
            this.month,
            this.day,
            this.year);
    }
    public void printLongDate() {
        // Monthname dd, yyyy format
        System.out.printf("%s %d, %d",
            this.getMonthName(),
            this.day,
            this.year);
    }

    public String getMonthName() {
        return getMonthName(this.month);
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }
    public int getDayOfMonth() {
        return this.day;
    }

    private boolean isLeapYear(int year) {
        return ((year % 4) == 0); 
    }

    private int getNumberOfDaysInMonth(int year, int month) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            default -> {
                if (isLeapYear(year)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
        };
    }
    private int getNumberOfDaysInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }
    private String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid Month";
        };
    }
}
