package exam.part4;

public class Part4_2 {
    public static void main(String[] args) {
        int sum = 0;

        int i = 1;
        while (i <=5) {
            sum += i;
            i++;
        }
        System.out.println("1부터 5까지의 합: " + sum); // 결과: 15
    }
}
