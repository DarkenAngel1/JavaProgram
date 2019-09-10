import java.util.*;

public class HashMapTest {
    public static void main(String[] args){
        HashMap<String,String> map=new HashMap<>();
        map.put("zhang","31");
        System.out.println(map.containsKey("zhang"));
        System.out.println(map.containsKey("other"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.remove("zhang"));//从键值中删除
        System.out.println(map.containsKey("zhang"));
        System.out.println(map.get("zhang"));//获取值
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }
}
