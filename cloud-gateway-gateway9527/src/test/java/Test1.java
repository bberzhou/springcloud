import java.time.ZonedDateTime;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/7/2022
 * Create By Intellij IDEA
 */
public class Test1 {
    public static void main(String[] args) {
        // 获取当前的默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
