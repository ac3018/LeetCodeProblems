import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses_929 {
  
}

class Solution {
  /**
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public int numUniqueEmails(String[] emails) {
    // Store unique emails
    Set<String> set = new HashSet<>();

    for(String s : emails) {
      String[] split = s.split("@"); // split string into local and domain parts
      String[] local = split[0].split("\\+"); // split local by "+"
      set.add(local[0].replace(".", "") + "@" + split[1]); // remove all ".", concatenate "@" and domain, then add to set
    }

    return set.size();
  }
}
