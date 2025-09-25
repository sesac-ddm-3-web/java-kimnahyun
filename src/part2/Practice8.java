package part2;

public class Practice8 {
    static int globalVar = 100;

    public static void main(String[] args) {
        int localVar = 10;

        System.out.println("메인 메소드에서:");
        System.out.println("globalVar = " + globalVar);
        System.out.println("localVar = " + localVar);

        {
            int blockVar = 20;
            System.out.println("\n블록 안에서:");
            System.out.println("globalVar = " + globalVar);
            System.out.println("localVar = " + localVar);
            System.out.println("blockVar = " + blockVar);
        }

        System.out.println("\n블록 밖에서:");
        System.out.println("globalVar = " + globalVar);
        System.out.println("localVar = " + localVar);
    }

}
