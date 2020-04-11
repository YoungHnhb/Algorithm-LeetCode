public class Code28 {

    public static void main(String[] args) {
//        String haystack = "hello", needle = "ll";
        String haystack = "aaaaa", needle = "bba";
//        String haystack = "mississippi", needle = "issip";
        System.out.println(new Code28().strStr(haystack, needle));
    }

    public int strStrNew(String haystack, String needle) {
        if(needle.equals("")) return 0;
        if(haystack.equals("")) return -1;
        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int x = 0;
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        while (x + needleLength <= haystackLength) {
            String tempStr = haystack.substring(x, needle.length() + x);
            if (needle.equals(tempStr)) {
                return x;
            } else {
                x++;
            }
        }
        return -1;
    }
}
