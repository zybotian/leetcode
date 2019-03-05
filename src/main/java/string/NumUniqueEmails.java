package string;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-03-05
 */
public class NumUniqueEmails {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee" +
                ".tcode.com", "yee.lee@lee.tc.ode.com"};
        System.out.println(solution.numUniqueEmails(emails));
    }

    // 击败80.93%
    static class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> emailSet = new HashSet<>();
            for (int i = 0; i < emails.length; i++) {
                int indexOfPlus = emails[i].indexOf('+');
                int indexOfSign = emails[i].indexOf('@');
                String local, domain = emails[i].substring(indexOfSign);
                if (indexOfPlus >= 0) {
                    local = emails[i].substring(0, indexOfPlus).replaceAll("\\.", "");
                } else {
                    local = emails[i].substring(0, indexOfSign).replaceAll("\\.", "");
                }
                emailSet.add(local.concat(domain));
            }
            return emailSet.size();
        }
    }
}
