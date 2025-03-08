package annualflowers.com.example;

public class StringUtility {
    
    // Make first letter uppercase, rest lowercase
    public static String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        
        return text.substring(0, 1).toUpperCase() + 
               text.substring(1).toLowerCase();
    }

    // Convert 2D array to readable string
        public static String stringify2DArray(String[][] data) {
        StringBuilder result = new StringBuilder();
        
        for (String[] row : data) {
            for (String item : row) {
                result.append(item).append(" ");
            }
            result.append("\n");
        }
        
        return result.toString();
    }

    // Sum up a column in a 2D array
    public static int getColumnTotal(int[][] data, int col) {
        int sum = 0;
        
        for (int[] row : data) {
            if (col < row.length) {
                sum += row[col];
            }
        }
        
        return sum;
    }
}