package com.tdd.chap05;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadTest {

    private FileOperator op = new FileOperator();
    private static File file; // 두 테스트가 데이터를 공유할 목적으로 필드 사용
    /**
     * 테스트코드간 의존관계가 생기면 안된다.
     *Junit 5는 테스트 실행순서를 보여주기는 한다.
     * */

    @Test
    @DisplayName("파일 읽기 테스트 코드")
    @Disabled
    void readFile() {
        long data = op.readData(file);
        assertTrue(data > 0);
    }

    @Test
    @DisplayName("파일 생성 테스트 코드")
    void fileCreationTest() {
        File createdFile = op.createFile();
        assertTrue(createdFile.length() > 0);
        this.file = createdFile;
    }




    class FileOperator {

        public FileOperator() {
        }

        private File createFile() {
            return new File("/");
        }

        private long readData(File file) {
            return 1;
        }
    }

}
