package com.tdd.chap05;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.Authenticator;

import org.junit.jupiter.api.Test;

public class SumTest {

    @Test
    void sum() {
        int result = 2+3;
        int expected = 5;
        String expectedString = "hello";
        boolean result2 = true;
        boolean result3 = false;
        String result4 = null;
        assertEquals(5, result);
        assertNotEquals(3,result); // 값이 같지 않은지 검증
        assertSame(expected, result); // 두 객체가 동일한 객체인지 검사.
        assertNotSame(expectedString, result); // 두 객체가 동일하지 않은 객체인지 검사한다
        assertTrue(result2); // 값이 True인지 검사한다
        assertFalse(result3); // 값이 false 인지 검사한다.
        assertNull(null); // null인지 검사한다
        assertNotNull("hello"); // null이 아닌지 검사한다

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
        {
            AuthService authService = new AuthService();
            authService.authenticate(null, null);
        });

        assertTrue(thrown.getMessage().contains("파라메터"));

        // 모든 검증을 실행하고 그 중에 실패한 것이 있는지 확인하고 싶을 때
        assertAll(
            () -> assertEquals(2, 5/2),
            () -> assertEquals(4, 2 * 2),
            () -> assertEquals(5, 11/2)
        );
    }

    class AuthService {

        public AuthService() {
        }

        void authenticate(String a, String b) {
            if(a == null && b == null) {
                throw new IllegalArgumentException("파라메터 오류");
            }
        }
    }

}
