package io.github.elysium_development.photonkatademo.utils;

import android.util.Log;

/**
 * Utility class containing all the utility methods for the application.
 */
public class GridUtilities {

    /**
     * Method to convert input String to array.
     * @param input
     * @return
     */
    public static int[][] gridArrayFromString(String input) {
        if (input != null) {
            String[] rows = input.split("\n");
            String[] firstColumns = rows[0].split("\\s+");
            int[][] output = new int[rows.length][firstColumns.length];

            try {
                for (int row = 0; row < rows.length; row++) {
                    String[] columns = rows[row].split("\\s+");
                    if (columns.length==firstColumns.length) {
                        for (int column = 0; column < columns.length; column++) {
                            if (column < output[0].length) {
                                output[row][column] = Integer.valueOf(columns[column]);
                            }
                        }
                    }
                }

                return output;
            } catch (NumberFormatException nfe) {
                return new int[0][0];
            }
        } else {
            return new int[0][0];
        }
    }

  public static String gridStringAreValid(String gridString) {
    String[] rows = gridString.split("\n");
    if (rows.length< 1 || rows.length > 10) return "Must have 1 to 10 lines";
    int lines = rows.length;
    int count = 0;
    for (String row : rows) {
      String[] column = row.split("\\s+");
      if (column.length < 5 || column.length > 100) return "Must have 5 to 100 numbers per line";
      for (String aColumn : column) {
        try {
          Integer.parseInt(aColumn);
          count++;
        } catch (NumberFormatException e) {
          return "Only Numeric Characters Allowed";
        }
      }
    }
    int firstColumnLength = rows[0].split("\\s+").length;
    if (count!= firstColumnLength * lines) return "Number rows must have the same length of columns";
    return "";
  }

}
