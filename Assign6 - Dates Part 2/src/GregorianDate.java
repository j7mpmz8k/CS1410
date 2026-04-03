public class GregorianDate extends Date {
    GregorianDate(int year, int month, int day) {
        super(year, month, day);
    }
    GregorianDate() {
        super(1970, 1, 1);
        addDaysSinceEpoch();
    }
    @Override
    public boolean isLeapYear(int year) {
        return (((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0))); 
    }
}
