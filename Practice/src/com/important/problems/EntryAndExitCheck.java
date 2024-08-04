package com.important.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/4366572/Atlassian-or-PSE-or-Screening-or-Reject/
//https://leetcode.com/discuss/interview-experience/5351537/Wayfair-or-Senior-Software-Engineer-or-L4-or-Bangalore-or-Rejected

// list of entry and exit of employees ,
// check who did not tag entry or exit.
public class EntryAndExitCheck {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /*String[][] records = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"},
        };*/
        /*String[][] records =
        {
            {"Paul", "enter"},
            {"Paul", "enter"},
            {"Paul", "exit"},
            {"Paul", "exit"},
        };*/

        String[][] records =
                {
                        {"Paul", "enter"},
                        {"Pauline", "exit"},
                        {"Paul", "enter"},
                        {"Paul", "exit"},
                        {"Martha", "exit"},
                        {"Joe", "enter"},
                        {"Martha", "enter"},
                        {"Steve", "enter"},
                        {"Martha", "exit"},
                        {"Jennifer", "enter"},
                        {"Joe", "enter"},
                        {"Curtis", "exit"},
                        {"Curtis", "enter"},
                        {"Joe", "exit"},
                        {"Martha", "enter"},
                        {"Martha", "exit"},
                        {"Jennifer", "exit"},
                        {"Joe", "enter"},
                        {"Joe", "enter"},
                        {"Martha", "exit"},
                        {"Joe", "exit"},
                        {"Joe", "exit"}
                };

        checkForWrongTags(records);
        checkForWrongTags2(records);
        checkForWrongTagsFromLeetCode(records);
    }


    static void checkForWrongTags(String[][] records) {

        // make a map of  person and all their entry exits.
        Map<String, List<String>> map = getEntryMap(records);
        System.out.println(map);
        Set<String> missedEntry = new HashSet<>();
        Set<String> missedExit = new HashSet<>();

        map.forEach((person, listOfActions) -> {

            boolean isEntry = false;
            boolean isExit = true;

            for (String action : listOfActions) {

                // if person has entered , check if he has existedBefore
                // if he has not exited before then add him to missedExit List
                // or else just make entry = true , exit = false.
                if (action.equals("enter")) {
                    if (isExit) {
                        isExit = false;
                    } else {
                        missedExit.add(person);
                    }
                    isEntry = true;
                } else {
                    if (isEntry) {
                        isEntry = false;
                    } else {
                        missedEntry.add(person);
                    }
                    isExit = true;
                }
            }

            // incase person [enter] or person does not exit on "enter"
            if (isEntry) {
                missedExit.add(person);
            }

        });

        System.out.println("Missed Entry: " + missedEntry);
        System.out.println("Missed Exit: " + missedExit);
    }

    // simple and recommended solution
    static void checkForWrongTags2(String[][] records) {

        // for enter add person to the room
        // for exit remove person from the room.
        Set<String> room = new HashSet<>();
        Set<String> missedEntry = new HashSet<>();
        Set<String> missedExit = new HashSet<>();

        for (String[] record : records) {
            String person = record[0];
            String action = record[1];

            if (action.equalsIgnoreCase("enter")) {

                if (room.contains(person)) {
                    missedExit.add(person);
                } else {
                    room.add(person);
                }

            } else {
                if (!room.contains(person)) {
                    missedEntry.add(person);
                } else {
                    room.remove(person);
                }
            }
        }

        // ideally no one should be in the room , if any one is there , add them to missedExit list
        missedExit.addAll(room);

        System.out.println("Missed Entry: " + missedEntry);
        System.out.println("Missed Exit: " + missedExit);
    }

    private static Map<String, List<String>> getEntryMap(String[][] records) {
        Map<String, List<String>> map = new HashMap<>();

        for (String[] record : records) {

            String name = record[0];
            String action = record[1];

            if (map.containsKey(name)) {
                map.get(name).add(action);
            } else {
                List<String> list = new ArrayList<>();
                list.add(action);
                map.put(name, list);
            }
        }
        return map;
    }

    // copied from leetcode solution
    static void checkForWrongTagsFromLeetCode(String[][] records) {

        Map<String, Set<String>> result = new HashMap<>();
        Set<String> exitWithoutEntry = new HashSet<>();
        Set<String> entryWithoutExit = new HashSet<>();
        Set<String> room = new HashSet<>();

        for (String record[] : records) {
            String action = record[1];
            String employeeName = record[0];
            if (action.equalsIgnoreCase("exit")) {
                // if employee is the room that means valid entry otherwise it's exit without an entry
                if (!room.remove(employeeName)) {
                    exitWithoutEntry.add(employeeName);
                }
            } else if (!room.add(employeeName)) { // it's enter case and room should not have entry of this employee
                entryWithoutExit.add(employeeName);
            }
        }
        entryWithoutExit.addAll(room);// log entry ends
        result.put("enter", entryWithoutExit);
        result.put("exit", exitWithoutEntry);

        System.out.println(result);
    }


}
