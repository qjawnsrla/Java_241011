package 예외처리리본;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain2 {
    public static void main(String[] args) {
        fileNotFoundFunc();
        nullPointerFunc();
        nullPointerFunc2();
        arithemeticFunc();
    }
    static void arrayExceptionFunc(){
        try {
            int[] arr = new int[5];
            for (int i = 0; i <= 5; i++) {
                arr[i] = i;
                System.out.println(arr[i]);
            }
        } catch (Exception e) {
            System.out.println(e + "인덱스가 배열의 범위를 벗어났습니다.");
        }
        System.out.println("프로그램 정상 종료");
    }

    static void fileNotFoundFunc() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("해당 파일이 없습니다. 계속 진행하시겠습니까?");
        }
    }

    // NullPointerException
    static void nullPointerFunc() {
        try {
            Test test = null;   // 참조하는 객체가 없음을 의미
            System.out.println(test.name);
        } catch (NullPointerException e) {
            System.out.println("참조하고자 하는 객체가 생성되지 않았습니다.");
        }
    }
    static void nullPointerFunc2() {
        Test test = null;
        if(test != null){
            System.out.println(test.name);
        } else {
            System.out.println("test가 없습니다.");
        }
    }

    static void arithemeticFunc() {
        Scanner sc = new Scanner(System.in);
        int rst = 0;
        try{
            System.out.print("첫번째 값 : ");
            int a = sc.nextInt();
            System.out.print("두번째 값 : ");
            int b = sc.nextInt();
            rst = a/b;
            System.out.println(rst);
        } catch (ArithmeticException | InputMismatchException e) {
            System.out.println(e + "오류 발생");
        } finally {
            System.out.println("무조건 수행되는 구문");
        }
    }


    class Test{
        String name = "민지";
    }
}
