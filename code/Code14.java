public class Code14 {

    public static void main(String[] args) {
        String[] test = new String[]{"aflower", "aflow", "aflight"};
        String result = new Code14().longestCommonPrefix(test);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
