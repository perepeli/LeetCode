package problems;

public class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daY = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int[] daysOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if( leapYear(year) ){
            daysOfMonth[2] = 29;
        }
        int daysOfYear = 4;

        for( int i = 1971 ; i < year ; i++){
            if( leapYear(i)){
                daysOfYear += 366;
            }else{
                daysOfYear += 365;
            }
        }

        for( int i = 1 ; i < month ; i++){
            daysOfYear += daysOfMonth[i];
        }
        daysOfYear += day;
        return daY[daysOfYear % 7];
    }
    private boolean leapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            return true;
        return false;
    }
}
