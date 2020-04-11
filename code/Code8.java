import java.util.HashMap;

public class Code8 {

    public static void main(String[] args) {
//        int result = new Code8().myAtoi("4193 with words");
//        int result = new Code8().myAtoi("   -42");
        int result = new Code8().myAtoi("  0000000000012345678");
        System.out.println(result);
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < str.length(); i++) {
            automaton.get(str.charAt(i));
        }
        return automaton.sign * ((int) automaton.ans);
    }

    class Automaton {

        String START = "start";
        String SIGNED = "signed";
        String IN_NUMBER = "in_number";
        String END = "end";
        String state = START;
        int sign = 1;
        long ans = 0;
        HashMap<String, String[]> table = new HashMap<>();

        public Automaton() {
            table.put(START, new String[]{"start", "signed", "in_number", "end"});
            table.put(SIGNED, new String[]{"end", "end", "in_number", "end"});
            table.put(IN_NUMBER, new String[]{"end", "end", "in_number", "end"});
            table.put(END, new String[]{"end", "end", "end", "end"});
        }

        public int getCol(char c) {
            if (c == ' ') {
                return 0; // start
            } else if (c == '+' || c == '-') {
                return 1; // signed
            } else if (c >= '0' && c <= '9') {
                return 2; // number
            }
            return 3;
        }

        public void get(char c) {
            state = table.get(state)[getCol(c)];
            if (state.equals(IN_NUMBER)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if (state.equals(SIGNED)) {
                sign = c == '+' ? 1 : -1;
            }
        }
    }
}
