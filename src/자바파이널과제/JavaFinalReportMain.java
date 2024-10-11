package 자바파이널과제;

// 임의의 위치에 텍스트 파일을 만들고, 10명의 정보를 공백 기준으로 미리 입력 해둠.
// 이름 국어 영어 수학 형식
// 해당 파일을 읽어 총점을 구하고
// 총점이 높은 사람 순으로 이름과 총점 보여주기 (총점이 같은 경우 이름순)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class JavaFinalReportMain {
    static String[][] arr = new String[10][2];
    static int cnt = 0;

    public JavaFinalReportMain() {
        this.arr = new String[10][2];
        this.cnt = 0;
    }

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/자바파이널과제/student.txt");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다.");
        }
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] list = line.split(" ");
            int sum = 0;
            arr[cnt][0] = list[0];
            for (int i = 1; i < list.length; i++) {
                sum += Integer.parseInt(list[i]);
            }
            arr[cnt][1] = String.valueOf(sum);
            cnt++;
        }

        sortArray();
        showInfo(cnt);
    }

    // 총점이 높은 사람 순으로 이름과 총점 보여주기 (총점이 같은 경우 이름순)
    public static void sortArray(){
        Arrays.sort(arr, 0, cnt, (o1, o2) -> {
            int cp = Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
            if (cp == 0) {
                return o1[0].compareTo(o2[0]);
            }
            return cp;
        });
    }

    public static void showInfo(int cnt){
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%-4s : %-2s", arr[i][0],arr[i][1]);
            System.out.println();
        }
    }

}
