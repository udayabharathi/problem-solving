class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean carry = false;
        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i--);
            char c2 = b.charAt(j--);
            if (c1 == '1' && c2 == '1') {
                if (carry) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                carry = true;
            } else if (c1 == '1' || c2 == '1') {
                if (carry) {
                    sb.append(0);
                    carry = true;
                } else {
                    sb.append(1);
                }
            } else {
                if (carry) {
                    sb.append(1);
                    carry = false;
                } else {
                    sb.append(0);
                }
            }
        }
        while (i >= 0) {
            char c = a.charAt(i--);
            if (c == '1') {
                if (carry) {
                    sb.append(0);
                    carry = true;
                } else {
                    sb.append(1);
                }
            } else {
                if (carry) {
                    sb.append(1);
                    carry = false;
                } else {
                    sb.append(0);
                }
            }
        }
        while (j >= 0) {
            char c = b.charAt(j--);
            if (c == '1') {
                if (carry) {
                    sb.append(0);
                    carry = true;
                } else {
                    sb.append(1);
                }
            } else {
                if (carry) {
                    sb.append(1);
                    carry = false;
                } else {
                    sb.append(0);
                }
            }
        }
        if (carry) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}