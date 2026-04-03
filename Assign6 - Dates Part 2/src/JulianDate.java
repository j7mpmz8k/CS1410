public class JulianDate extends Date {
    JulianDate(int year, int month, int day) {
        super(year, month, day);
    }
    JulianDate() {
        super(1, 1, 1);
        addDays(719164);
        addDaysSinceEpoch();
    }
    @Override
    public boolean isLeapYear(int year) {
        return ((year % 4) == 0); 
    }
}
