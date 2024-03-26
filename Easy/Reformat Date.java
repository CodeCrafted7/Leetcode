class Solution {
    static String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(split[2]).append("-");
        int monthNum = 0;
        for (int i = 0; i < months.length; i++) {
            if (split[1].equals(months[i])) {
                monthNum = i + 1;
                break;
            }
        }
        if (monthNum > 9) {
            sb.append(monthNum);
        } else {
            sb.append("0").append(monthNum);
        }
        sb.append("-");

        if (split[0].length() == 3) {
            sb.append("0").append(split[0].charAt(0));
        } else {
            sb.append(split[0].charAt(0)).append(split[0].charAt(1));
        }
        return sb.toString();
    }
}
