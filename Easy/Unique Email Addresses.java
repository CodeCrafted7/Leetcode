class Solution {
    public int numUniqueEmails(String[] emails) {
        String[] copy = new String[emails.length];
        HashSet<String> set = new HashSet<>();
        for(String email: emails){
            StringBuilder localName = new StringBuilder();
            boolean local = true;
            int index = -1;
            for(char c: email.toCharArray()){
                index++;
                if(c == '.')
                    continue;
                if(c == '+'){
                    local = false;
                    continue;
                }
                if(c == '@')
                    break;
                else if(local)
                    localName.append(c);
            }
            set.add(localName.toString() + email.substring(index));
        }
        return set.size();
    }
}
