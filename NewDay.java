package com.example.newday;

public class NewDay {

    private final String[] weekList = new String[]{
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday",
            "Saturday", "Sunday"
    };
    private String weekDayOld;
    private final int dayAdd;
    private int dayCount;
    private int dayNewAdd;
    private String weekDayNew;

    //constructor
    public NewDay(String dayOld, int dayAdded){

        weekDayOld = dayOld;
        dayAdd = dayAdded;

    }

    //get dayCount
    public String getDayCount(){
        switch(weekDayOld) {
            case "Monday":
                dayCount = 0;
                break;
            case "Tuesday":
                dayCount = 1;
                break;
            case "Wednesday":
                dayCount = 2;
                break;
            case "Thursday":
                dayCount = 3;
                break;
            case "Friday":
                dayCount = 4;
                break;
            case "Saturday":
                dayCount = 5;
                break;
            case "Sunday":
                dayCount = 6;
                break;
            default:
                break;
        }

        boolean swZeroDayAdd = false;
        boolean swPosDayAdd = false;
        boolean swNegDayAdd = false;
        if (dayAdd < 0) {
            swNegDayAdd = true;
        } else {
            if (dayAdd == 0) {
                swZeroDayAdd = true;
            } else {
                swPosDayAdd = true;
            }
        }

        boolean swDivisibleBy7 = false;
        boolean swNotDivBy7 = false;
        if (dayAdd % 7 == 0) {
            swDivisibleBy7 = true;
        } else {
            swNotDivBy7 = true;
        }

        System.out.println("*** INSIDER ***");
        System.out.println("Week Day Old: "+weekDayOld);
        System.out.println("Day Added: "+dayAdd);
        System.out.println("Old Day Counter: "+dayCount);

        if (swDivisibleBy7 == true || swZeroDayAdd == true) {
            dayNewAdd = dayCount;
            weekDayNew = weekDayOld;
        }
        else {
            if (swNotDivBy7 && swNegDayAdd) {
                dayNewAdd = (dayCount + dayAdd) % 7 + 7;
                if (dayNewAdd == 7) {
                    dayNewAdd = 0;
                }
            }
            if (swNotDivBy7 && swPosDayAdd) {
                dayNewAdd = (dayCount + dayAdd) % 7;
            }
        }

        weekDayNew = weekList[dayNewAdd];

        System.out.println("Number " + (dayAdd + dayCount) + " divided by 7 yields remainder " + dayNewAdd + ".");
        System.out.println("New Day Counter: "+dayNewAdd);
        System.out.println("Week Day New: "+weekList[dayNewAdd]);
        System.out.println("Must be the same as: "+weekDayNew);
        System.out.println("*** INSIDER ***");

        return weekDayNew;

    }

}