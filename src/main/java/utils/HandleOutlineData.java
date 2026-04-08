package utils;

public class HandleOutlineData {
    public static String normalizeInput(String input) {
        if (input == null) return null;
//    if (!input.isEmpty() && input.startsWith("\"\"") && input.endsWith("\"\"") && input.length() >= 4) {
//        input = input.substring(2, input.length() - 2);
//    }
        if (!input.isEmpty() && input.startsWith("\"") && input.endsWith("\"") && input.length() >= 2) {
            input = input.substring(1, input.length() - 1);
            if (!input.isEmpty() && input.startsWith("\"") && input.endsWith("\"") && input.length() >= 2) {
                input = input.substring(1, input.length() - 1);
            }
        }
        return input;
    }
}
