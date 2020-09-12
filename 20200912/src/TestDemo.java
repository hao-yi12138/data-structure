import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-12 09:52
 **/
public class TestDemo {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
    public static void main(String[] args) {

    }
}
