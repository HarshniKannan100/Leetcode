import java.util.*;

public class Solution {
    
    static class Operation {
        char type;
        long length;

        Operation(char type, long length) {
            this.type = type;
            this.length = length;
        }
    }

        // Forward simulation
    public static char processStr(String s, long k) {
        List<Operation> ops = new ArrayList<>();
        long length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                ops.add(new Operation(c, length));
                length++;
            } else if (c == '*') {
                if (length > 0) {
                    ops.add(new Operation('*', length));
                    length--;
                }
            } else if (c == '#') {
                ops.add(new Operation('#', length));
                length *= 2;
            } else if (c == '%') {
                ops.add(new Operation('%', length));
                // length unchanged
            }
        }

        // If k is out of bounds
        if (k >= length) return '.';

        // Reverse operations to trace kth character
        for (int i = ops.size() - 1; i >= 0; i--) {
            Operation op = ops.get(i);
            if (Character.isLowerCase(op.type)) {
                if (k == op.length) {
                    return op.type;
                }
            } else if (op.type == '*') {
                
                if (k >= op.length) k++; // character was removed, shift forward
            } else if (op.type == '#') {
                long half = op.length;
                if (k >= half) {
                    k -= half; // result was duplicated
                }
            } else if (op.type == '%') {
                k = op.length - 1 - k; // reverse index
            }
        }

        return '.';
    }

    
}
