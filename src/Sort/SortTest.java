package Sort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

	public static List<String> init() {
		List<String> list = new ArrayList<String>();
		list.add("李方1");
		list.add("郭云2");
		list.add("郭云3");
		list.add("赵飞3");
		list.add("马路4");
		list.add("xxx");
		list.add("xxy");
		list.add("432");
		return list;
	}

	public static void main(String[] args) {
		List<String> list = init();
		Comparator<String> comparator = new Comparator<String>() {

			public int compare(String o1, String o2) {
				Collator collator = Collator.getInstance();
				return collator.getCollationKey(o1).compareTo(
						collator.getCollationKey(o2));
			}
		};
		Collections.sort(list, comparator);
		System.out.println(list);

	}
	
	public static void sort() {
		List<String> list = init();
		Comparator<String> comparator = new Comparator<String>() {

			public int compare(String o1, String o2) {
				Collator collator = Collator.getInstance();
				return collator.getCollationKey(o1).compareTo(
						collator.getCollationKey(o2));
			}
		};
		Collections.sort(list, comparator);
		System.out.println(list);
	}
}
