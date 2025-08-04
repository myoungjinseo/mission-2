package com.back;

import com.back.dto.request.WiseSayingRequest;

import java.util.Scanner;

public class App {
    private final WiseSayingController wiseSayingController = new WiseSayingController();
    private final Scanner sc = new Scanner(System.in);
    public void run() {
        String command = "";
        System.out.println("== 명언 앱 ==");
        while (!command.equals("종료")){
            System.out.print("명령) ");
            command = sc.nextLine();
            if(command.equals("등록")){
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                WiseSayingRequest request = new WiseSayingRequest(content, author);

                int id = wiseSayingController.createWiseSaying(request);

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            } else if (command.equals("목록")){
                String response = wiseSayingController.getWiseSaying();
                System.out.println(response);
            }
        }
    }
}
