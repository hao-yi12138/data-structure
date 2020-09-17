/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-17 08:38
 **/
public enum TestEnum {
    RED,BLACK,WHITE,GREEN;

    public static void main(String[] args) {

    }
    public static void main2(String[] args) {
        //拿到枚举实例BLACK
        TestEnum testEnum = TestEnum.BLACK;
        //拿到枚举实例RED
        TestEnum testEnum21 = TestEnum.RED;
        System.out.println(testEnum.compareTo(testEnum21));
        System.out.println(BLACK.compareTo(RED));
        System.out.println(RED.compareTo(BLACK));
    }
    public static void main1(String[] args) {
        TestEnum[]testEnums = TestEnum.values();
        for (int i = 0; i <testEnums.length ; i++) {
            System.out.println(testEnums[i]+" "+testEnums[i].ordinal());
        }
        System.out.println("============");
        System.out.println(TestEnum.valueOf("BLACK"));
    }
}
