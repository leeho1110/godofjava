package part12.beforejava5;

interface DAY {
    int MONDAY = 1;
    int TUESDAY = 2;
    int WEDNESDAY = 3;
    int THURSDAY = 4;
    int FRIDAY = 5;
    int SATURDAY = 6;
    int SUNDAY = 7;
}

interface MONTH{
    int JANUARY = 1;
    int FEBRUARY = 2;
    int MARCH = 3;
    int APRIL = 4;
    int MAY =5;
    int JUNE = 6;
    int JULY = 7;
    int AUGUST = 8;
    int SEPTEMBER = 9;
    int OCTOBER = 10;
    int NOVEMBER = 11;
    int DECEMBER = 12;
}

class Day{
    public final static Day MONDAY = new Day();
    public final static Day TUESDAY = new Day();
    public final static Day WEDNESDAY = new Day();
}

class Month{
    public final static Month JANUARY = new Month();
    public final static Month FEBRUARY = new Month();
    public final static Month MARCH = new Month();
}

public class EnumExample {

    public static void main(String[] args) {
        interfaceCompare();
        classCompare();
    }

    private static void classCompare() {
//        if(Day.MONDAY == Month.JANUARY){ // java: incomparable types: part12.beforejava5.Day and part12.beforejava5.Month
//            System.out.println("두 상수는 같습니다.");
//        }

        Day day = Day.MONDAY;

//        switch (day) { // java: incompatible types: part12.beforejava5.Day cannot be converted to int
//            case DAY.MONDAY:
//                System.out.println("월요일 입니다.");
//                break;
//            case DAY.TUESDAY:
//                System.out.println("화요일 입니다.");
//                break;
//            case DAY.WEDNESDAY:
//                System.out.println("수요일 입니다.");
//                break;
//        }
    }

    private static void interfaceCompare() {
        if(DAY.MONDAY == MONTH.JANUARY){ // 서로 다른 상수 집합은 비교되면 안됩니다. 컴파일 타임, 런타임에서 정상적이라는 것이 문제입니다.
            System.out.println("두 상수는 같습니다.");
        }

        int day = DAY.MONDAY;

        switch (day) {
            case DAY.MONDAY:
                System.out.println("월요일 입니다.");
                break;
            case DAY.TUESDAY:
                System.out.println("화요일 입니다.");
                break;
            case DAY.WEDNESDAY:
                System.out.println("수요일 입니다.");
                break;
        }
    }
}