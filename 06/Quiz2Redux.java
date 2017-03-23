import java.util.*;

public class Quiz2Redux {

    
    public static ArrayList<String> combinations(String s) {
	ArrayList<String> words = new ArrayList<String>();
	help(s, words);
	words.add("");
	Collections.sort(words);
	return words;
    }


    
    public static void help(String s, ArrayList<String> words) {

	if (s.length() == 0) {
	    return;
	}
	if (s.length() == 1) {
	    words.add(s);
	    return;
	}
	else {
	    String firstLetter = s.substring(0,1);
	    s = s.substring(1);
	    help(s, words);
	    int size = words.size();
	    for (int i = 0; i < size; i++) {
		words.add(firstLetter + words.get(i));
	    }
	    words.add(firstLetter);
	    return;
	}
    }

	



     // permutation_list=[]

     // def add_permutation(fixed_seq,var_seq):

     // 	if length(var_seq=0):
     // 	  permutation_list.append(fixed_seq)
     // 	else:      
     //      for i in range(0,length(var_seq)):
     //        new_fixed_seq=fixed_seq+var_seq[i]
     // 	    permutation_list.append(new_fixed_seq)
     // 	    add_permutation(new_fixed_seq,var_seq[:i-1]+var_seq[i+1:])	

    public static String toString(ArrayList<String> words) {
	String out = "";
	for (int i = 0; i < words.size(); i++) {
	    out += words.get(i);
	}
	return out;
    }


    public static void main(String[] args) {
	System.out.println(combinations(""));
    }


}
