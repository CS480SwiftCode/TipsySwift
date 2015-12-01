package controllers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZenasMeng on 11/19/15.
 */
public class TextAnalyzer
{
    public static String analyze(ArrayList<String> reviews)
    {
//        String days = null;
        ArrayList<String> days = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();

        for (String r : reviews)
        {
            String[] sentences = r.split("[.!?]");
            for (String s : sentences)
            {
                if (s.contains("happy hour"))
                {
                    // Gets all possible times and puts in ArrayList.
                    times.add(checkNumbers(s));
                    days.add(checkDays(s));
                }
            }
        }
        return determineMostFrequent(days) + ": " + determineMostFrequent(times);
    }

    // In an ArrayList of Strings, returns most frequent String.
    private static String determineMostFrequent(ArrayList<String> originalList)
    {
        String mostFrequent = "Undetermined";

        // Gets all unique Strings.
        ArrayList<String> duplicates = new ArrayList<>();
        for (String s : originalList)
        {
            if (s.equals(""))
                continue;
            if (duplicates.contains(s))
                continue;
            else
                duplicates.add(s);
        }

        // Checks frequency of all Strings and sets mostFrequent to highest frequency.
        // Returns undetermined on ambiguity.
        int highest = 0;
        boolean ambiguity = false;
        for (String s : duplicates)
        {
            if (Collections.frequency(originalList, s) == highest)
                ambiguity = true;

            if (Collections.frequency(originalList, s) > highest)
            {
                highest = Collections.frequency(originalList, s);
                mostFrequent = s;
                ambiguity = false;
            }
        }

        if (ambiguity == true)
            mostFrequent = "Undetermined";
        return mostFrequent;
    }

    private static String checkDays(String sentence)
    {
        String days = "";
        String regex =
                "(" +
                        "(" +
                        "(Monday|Mon)|" +
                        "(Tuesday|Tue|Tues|Tu)|" +
                        "(Wednesday|Wed)|" +
                        "(Thursday|Thurs|Thur|Thu)|" +
                        "(Friday|Fri)|" +
                        "(Saturday|Sat)|" +
                        "(Sunday|Sun)|" +
                        "(M|T|W|T|F|S|S)" +
                        ")" +
                        "\\s?" +
                        "(through|-|to)" +
                        "\\s?" +
                        "(" +
                        "(Monday|Mon)|" +
                        "(Tuesday|Tue|Tues)|" +
                        "(Wednesday|Wed)|" +
                        "(Thursday|Thurs|Thur|Thu)|" +
                        "(Friday|Fri)|" +
                        "(Saturday|Sat)|" +
                        "(Sunday|Sun|Su)|" +
                        "(M|T|W|T|F|S|S)" +
                        ")" +
//                      ")|" +
//                      "(" +
//                      "(All\\s?day\\s?)" +
//                      "(" +
//                      "(Monday|Mon)|" +
//                      "(Tuesday|Tue|Tues)|" +
//                      "(Wednesday|Wed)|" +
//                      "(Thursday|Thurs|Thur|Thu)|" +
//                      "(Friday|Fri)|" +
//                      "(Saturday|Sat)|" +
//                      "(Sunday|Sun|Su)" +
//                      ")" +
                        ")|" +
                        "(Every\\s?day|Daily|Weekend|Weekday)";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        if (matcher.find())
        {
            // Convert to common format.
            String temp = sentence.substring(matcher.start(), matcher.end()).replace(" ", "").toLowerCase();
//         System.out.println(temp);

            int index = temp.indexOf("through") * temp.indexOf("-") * temp.indexOf("to");

            // Every day, weekdays, or weekends.
            if (index == -1)
            {
                if (temp.charAt(0) == 'e' || temp.charAt(0) == 'd')
                    days += "Mon - Sun";
                else if (temp.matches("weekend"))
                    days += "Sat - Sun";
                else
                    days += "Mon - Fri";
//            System.out.println("Days: " + days);
                return days;
            }

            String first = temp.substring(0, index); // Contains first day.
            String last = temp.substring(index + 1, temp.length()); // Contains last day.

            // If single letter and S or T. Ambiguous.
            if (first.length() < 2 && (first.charAt(0) == 's' || first.charAt(0) == 't'))
                return days;

            days += findCorrectDay(first) + " - " + findCorrectDay(last);
        }
//      if (!days.equals(""))
//         System.out.println("Days: " + days);
        return days;
    }

    private static String findCorrectDay(String day)
    {
        if (day.charAt(0) == 'm')
            return "Mon";
        if (day.contains("tu"))
            return "Tue";
        if (day.charAt(0) == 'w')
            return "Wed";
        if (day.contains("th"))
            return "Thu";
        if (day.charAt(0) == 'f')
            return "Fri";
        if (day.contains("sa"))
            return "Sat";
        return "Sun";
    }

    private static String checkNumbers(String sentence)
    {
        String numbers = "";
        String regex = "(\\d+:?\\d*((AM)?|(PM)?))(\\s?-\\s?|\\s?through\\s?|\\s?to\\s?)(\\d+:?\\d*((AM)?|(PM)?))";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        if (matcher.find())
        {
            // Convert to common format.
            String temp = sentence.substring(matcher.start(), matcher.end());
            boolean hyphenCheck = false;

            for (char c : temp.toCharArray())
            {
                if (Character.isDigit(c))
                    numbers += c;
                if (c == '-' && hyphenCheck == false)
                {
                    numbers += " - ";
                    hyphenCheck = true;
                }
                if (!Character.isDigit(c) && c != '-' && hyphenCheck == false)
                {
                    numbers += " - ";
                    hyphenCheck = true;
                }
            }
        }
        return numbers;
    }
}
