package com.example.mvp_test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvFactory {

    public static MultipartFile createBasketball1() {
        String basketballContent1 = "BASKETBALL\n" +
            "player 1;nick1;4;Team A;10;2;7\n" +
            "player 2;nick2;8;Team A;0;10;0\n" +
            "player 3;nick3;15;Team A;15;10;4\n" +
            "player 4;nick4;16;Team B;20;0;0\n" +
            "player 5;nick5;23;Team B;4;7;7\n" +
            "player 6;nick6;42;Team B;8;10;0";

        return new MockMultipartFile("basketball_1", basketballContent1.getBytes());
    }

    public static MultipartFile createBasketball2() {
        String basketballContent2 = "BASKETBALL\n" +
            "player 1;nick1;4;Team A;5;26;7\n" +
            "player 2;nick2;8;Team A;3;6;8\n" +
            "player 3;nick3;15;Team A;20;15;6\n" +
            "player 4;nick4;16;Team B;0;4;8\n" +
            "player 5;nick5;23;Team B;4;9;3\n" +
            "player 6;nick6;42;Team B;15;15;0";

        return new MockMultipartFile("basketball_2", basketballContent2.getBytes());
    }

    public static MultipartFile createBasketballWithOnePlayer() {
        String basketballContent3 = "BASKETBALL\n" +
            "player 1;nick1;4;Team A;10;2;7\n";

        return new MockMultipartFile("basketball_3", basketballContent3.getBytes());
    }

    public static MultipartFile createHandball1() {
        String handballContent = "HANDBALL\n" +
            "player 1;nick1;4;Team A;0;20\n" +
            "player 2;nick2;8;Team A;15;20\n" +
            "player 3;nick3;15;Team A;10;20\n" +
            "player 4;nick4;16;Team B;1;25\n" +
            "player 5;nick5;23;Team B;12;25\n" +
            "player 6;nick6;42;Team B;8;25";

        return new MockMultipartFile("handball_1", handballContent.getBytes());
    }

    public static MultipartFile createHandball2() {
        String handballContent = "HANDBALL\n" +
            "player 1;nick1;4;Team A;10;2\n" +
            "player 2;nick2;8;Team A;16;4\n" +
            "player 3;nick3;15;Team A;1;2\n" +
            "player 4;nick4;16;Team B;10;7\n" +
            "player 5;nick5;23;Team B;13;6\n" +
            "player 6;nick6;42;Team B;9;14";

        return new MockMultipartFile("handball_2", handballContent.getBytes());
    }

    public static MultipartFile createHandballWithBug() {
        String handballContent = "HANDBALL\n" +
            "player 1;nick1;4;Team A;0;20\n" +
            "player 2;nick2;8;Team A;15;20\n" +
            "player 3;nick3;15;Team A;20\n" +
            "player 4;nick4;16;Team B;1;25\n" +
            "player 5;nick5;23;Team B;12;25\n" +
            "player 6;nick6;42;Team B;8;25";

        return new MockMultipartFile("handball_3", handballContent.getBytes());
    }
}
