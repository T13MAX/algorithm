package com.atb.leetcode;

import java.util.*;

/**
 * @Author 呆呆
 * @Datetime 2021/12/29 7:55
 */
public class LeetCode_1_30 {

    /**
     * 第一题 两数之和
     *
     * @return int[]
     * @Author 呆呆
     * @Date 2021/12/31 7:32
     * @Param [nums, target]
     **/
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    /**
     * 第二题 两数之和
     *
     * @return com.atb.leetcode.Main.ListNode
     * @Author 呆呆
     * @Date 2022/1/1 9:00
     * @Param [l1, l2]
     **/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
        /*ListNode result = new ListNode(0);
        ListNode currsor = result;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + add;
            add = sum / 10;
            ListNode sumNode = new ListNode(sum % 10);
            currsor.next = sumNode;
            currsor = sumNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        return result.next;*/
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null) return add == 0 ? null : new ListNode(add);
        if (l1 != null) {
            add += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            add += l2.val;
            l2 = l2.next;
        }
        return new ListNode(add % 10, addTwoNumbers(l1, l2, add / 10));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int end = -1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) set.remove(s.charAt(i - 1));
            while (end + 1 < s.length() && !set.contains(s.charAt(end + 1))) {
                set.add(s.charAt(end + 1));
                end++;
            }
            result = Math.max(result, end - i + 1);
        }
        return result;
    }

    /**
     * 一转二
     *
     * @return int[][]
     * @Author 呆呆
     * @Date 2022/1/2 8:49
     * @Param [original, m, n]
     **/
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[][]{};
        int[][] result = new int[m][n];
        for (int i = 0; i < original.length; i += n) {
            //int line = i / n;
            //if (line >= m) return new int[][]{};
            //result[line][i % n] = original[i];
            System.arraycopy(original, i, result[i / n], 0, n);
        }
        return result;
    }

    /**
     * 消除游戏 删数组
     *
     * @return int
     * @Author 呆呆
     * @Date 2022/1/2 8:49
     * @Param [n]
     **/
    public static int lastRemaining(int n) {
        int fitst = 1;
        int end = n;
        int step = 1;
        int k = 0;
        int cnt = n;
        while (cnt > 1) {
            if (k % 2 == 0) {
                fitst += step;
                end = (cnt % 2 == 0 ? end : end - step);
            } else {
                fitst = (cnt % 2 == 0 ? fitst : fitst + step);
                end -= step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }

        return fitst;
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        days += day;
        return week[(days + 3) % 7];
    }

    public static int catMouseGame(int[][] graph) {


        return 0;
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 1 || s == null) {
            return "";
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            int len_odd = expandCenter(s, i, i);
            int len_even = expandCenter(s, i, i + 1);
            int len = Math.max(len_odd, len_even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    /*public static String longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char c = s.charAt(0);
        int length = 1;
        for (int i = 0; i < chars.length; i++) {
            if (map.keySet().contains(chars[i])) {
                if (i - map.get(chars[i]) + 1 > length) {
                    c = chars[i];
                    length = i - map.get(chars[i])+1;
                }
                continue;
            }
            map.put(chars[i], i);
        }
        return s.substring(s.indexOf(c), s.indexOf(c) + length);
    }*/

    /**
     * Z
     *
     * @return java.lang.String
     * @Author 呆呆
     * @Date 2022/2/8 20:34
     * @Param [s, numRows]
     **/
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    /**
     * 反转数字
     *
     * @return int
     * @Author 呆呆
     * @Date 2022/2/8 20:40
     * @Param [x]
     **/
    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static int myAtoi(String s) {
        String trim = s.trim();
        if (trim.length() == 0) {
            return 0;
        }
        if (!Character.isDigit(trim.charAt(0)) && trim.charAt(0) != '-' && trim.charAt(0) != '+') {
            return 0;
        }
        boolean neg = trim.charAt(0) == '-';//是-则为负 否则无论有没有+ 都是正
        int i = Character.isDigit(trim.charAt(0)) ? 0 : 1;
        int result = 0;
        while (i < trim.length() && Character.isDigit(trim.charAt(i))) {
            int add = trim.charAt(i) - '0';
            if ((result == Integer.MAX_VALUE / 10 && add > 7) || result > Integer.MAX_VALUE / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
            result = result * 10 + add;
        }

        return neg ? -result : result;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int y = 0;
        while (x > y) {
            int last = x % 10;
            x = x / 10;
            y = y * 10 + last;
        }
        return x == y || x == y / 10;
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while (i < j) {
            result = Math.max((j - i) * Math.min(height[j], height[i]), result);
            if (height[j] < height[i]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @return java.lang.String
     * @Author 呆呆
     * @Date 2022/2/13 21:13
     * @Param [num]
     **/
    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        char[] chs = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        int index = 0;
        while (num > 0) {
            int i = num % 10;
            if (i < 4) {
                for (int j = 0; j < i; j++) {
                    result.insert(0, chs[index]);
                }
            } else if (i == 4) {
                result.insert(0, chs[index + 1]);
                result.insert(0, chs[index]);
            } else if (i == 5) {
                result.insert(0, chs[index + 1]);
            } else if (i < 9) {
                for (int j = 0; j < i - 5; j++) {
                    result.insert(0, chs[index]);
                }
                result.insert(0, chs[index + 1]);
            } else if (i == 9) {
                result.insert(0, chs[index + 2]);
                result.insert(0, chs[index]);
            } else {
                result.insert(0, chs[index + 2]);
            }
            num /= 10;
            index += 2;
        }
        return result.toString();
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer value = symbolValues.get(chars[i]);
            if (i < chars.length - 1 && value < symbolValues.get(chars[i + 1])) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        out:
        while (true) {
            char c = '\0';
            if (strs[0].length() > index)
                c = strs[0].charAt(index);
            else break;
            for (String str : strs) {

                if (str.length() <= index || c != str.charAt(index)) {
                    break out;
                }
            }
            result.append(c);
            index++;
        }
        return result.toString();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int begin = i + 1, end = nums.length - 1;
            int num = nums[i];
            while (begin < end) {
                int first = nums[begin];
                int second = nums[end];
                int sum = first + second;

                if (sum == -num) {
                    result.add(new ArrayList() {{
                        add(first);
                        add(second);
                        add(-sum);
                    }});
                    begin++;
                    end--;
                    while (begin < end && nums[begin] == nums[begin - 1]) {
                        begin++;
                    }
                    while (begin < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < -num) {
                    begin++;
                } else if (sum > -num) {
                    end--;
                }
            }

        }
        return result;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += nums[i];
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            int num = nums[i];
            while (begin < end) {
                int sum = num + nums[begin] + nums[end];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    result = Math.abs(result - target) < Math.abs(sum - target) ? result : sum;//Math.min();
                    begin++;
                } else if (sum > target) {
                    result = Math.abs(result - target) < Math.abs(sum - target) ? result : sum;//Math.min();
                    end--;
                }
            }
        }

        return result;
    }

    static char[][] chs = new char[][]{{'\0'}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        //for (int i = 0; i < digits.length(); i++) {
            /*char c = digits.charAt(0);
            for (char ch : chs[c - 48 - 1]) {
                StringBuilder str = new StringBuilder();
                str.append(ch);
            }*/
        digui(digits, 0, new StringBuilder(), result);
        //}
        return result;
    }

    private static void digui(String digits, int index, StringBuilder str, List<String> result) {
        if (index == digits.length()) {
            result.add(str.toString());
            return;
        }

        char c = digits.charAt(index);
        for (char ch : chs[c - 48 - 1]) {
            StringBuilder s = new StringBuilder(str);
            s.append(ch);
            digui(digits, index + 1, s, result);
        }

    }


    /**
     * 可以用栈 入栈才出栈
     * 可以计算长度
     * 可以双指针 second比first快n
     *
     * @return com.atb.leetcode.Main.ListNode
     * @Author 呆呆
     * @Date 2022/2/15 21:29
     * @Param [head, n]
     **/
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode tmp = head;
        while (head.next != null) {
            map.put(index, tmp);
            if (tmp.next != null) {
                tmp = tmp.next;
                index++;
            } else {
                break;
            }
        }
        if (map.size() == n) return head.next;
        ListNode listNode = map.get(map.size() - n - 1);
        listNode.next = map.get(map.size() - n + 1);
        return head;
    }

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.size() == 0 || stack.removeLast() != '(') return false;
            } else if (c == ']') {
                if (stack.size() == 0 || stack.removeLast() != '[') return false;
            } else if (c == '}') {
                if (stack.size() == 0 || stack.removeLast() != '{') return false;

            } else {
                throw new RuntimeException("输入的字符串就有问题");
            }
        }
        return stack.size() == 0;
    }

    public static ListNode mergeTwoListsMerge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsMerge(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsMerge(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        digui(result, "", n, n);
        return result;
    }

    private static void digui(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left == right) {
            digui(result, str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                digui(result, str + "(", left - 1, right);
            }
            digui(result, str + ")", left, right - 1);
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp = first;
        }
        return dummyHead.next;
    }

    /**
     * 双指针还可以这么用啊
     *
     * @return int
     * @Author 呆呆
     * @Date 2022/2/17 22:01
     * @Param [nums]
     **/
    public static int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;

        /*int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;*/
        
       /* int fast = 0, slow = 0;
        while (slow < nums.length && fast < nums.length) {
            if (nums[slow] == val) {
                while (nums[fast] == val) {
                    if (fast == nums.length - 1) return slow;
                    fast++;
                }
                nums[slow] = nums[fast];
                nums[fast] = val;
                slow++;
            }else{
                fast++;
                slow++;
            }
        }
        return slow;*/
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return 0;
        }
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * X/Y=Z
     * Z*Y<=X<=(z+1)Y
     *
     * @return int
     * @Author 呆呆
     * @Date 2022/2/22 21:45
     * @Param [dividend, divisor]
     **/
    public static int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // 快速乘
    private static boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(strStr("", ""));
//        System.out.println(removeElement(new int[]{3}, 2));
//        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
//        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
//        swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));
//        System.out.println();
//        System.out.println(generateParenthesis(0));
//        System.out.println(generateParenthesis(3));

//        mergeTwoLists(null, null);
//        mergeTwoLists(null, new ListNode(0, null));
//        mergeTwoListsMerge(new ListNode(1, new ListNode(2, new ListNode(4, null))), new ListNode(1, new ListNode(3, new ListNode(4, null))));
//        System.out.println(isValid("()[]{}"));
        //removeNthFromEnd(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))), 2);
        //removeNthFromEnd(new ListNode(0, new ListNode(1, null)), 2);
        //System.out.println(letterCombinations("234"));

        //System.out.println(threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));

        //System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));

        //System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        //System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));

        //System.out.println(intToRoman(58));

        //System.out.println("-------------------------------");

        //System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));

        //System.out.println(isPalindrome(10));

        //System.out.println(myAtoi("2147483648"));
        //System.out.println(convert("PAYPALISHIRING", 3));

        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        //addTwoNumbers(l1, l2);
        //construct2DArray(new int[]{3}, 1, 2);
        //lastRemaining(9);
        //catMouseGame(new int[][]{{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}});

        //System.out.println(longestPalindrome("cbbd"));
        //System.out.println(longestPalindrome("babad"));
        //System.out.println(longestPalindrome("ccc"));


    }

    public static void print(String str) {
        System.out.println(str);
        System.out.println("-------------------------------");
    }

}
