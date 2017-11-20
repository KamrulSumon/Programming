package com.sumon.leetcode;


/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * LeetCode #551
 */
public class StudentAttendenceRecord {

  public boolean checkRecord(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }

    boolean foundAbsent = false;
    int len = s.length();

    if (s.charAt(0) == 'A') {
      foundAbsent = true;
    }

    for (int i = 1; i < len - 1; i++) {
      if (s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i + 1) == 'L') {
        return false;
      }
      if (s.charAt(i) == 'A') {
        if (foundAbsent) {
          return false;
        }
        foundAbsent = true;

      }
    }

    if (len > 1 && s.charAt(len - 1) == 'A' && foundAbsent) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    StudentAttendenceRecord sr = new StudentAttendenceRecord();
    System.out.println(sr.checkRecord("PPALLP"));
    System.out.println(sr.checkRecord("PPALLL"));
  }
}
