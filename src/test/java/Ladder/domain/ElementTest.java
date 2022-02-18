package Ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    Element element1 = null;
    Element element2 = null;
    Element element3 = null;
    Element element4 = null;

    @Test
    @DisplayName("이전 칸에 발판이 있으면 다음 칸엔 발판이 생성되지 않는다")
    void isStepFalseTest() {
        // given
        element1 = new Element(0, false, false); // |
        element2 = new Element(1, false, true);   // -----
        element3 = new Element(2, true, false);  // |

        // when
        element4 = new Element(3, true, true);   // expected : blank

        // then
        assertFalse(element4.getHasStep());
    }

    @Test
    @DisplayName("이전 칸에 발판이 없고 랜덤값이 참이라면 다음 칸엔 발판이 생성된다")
    void isStepTrueTest() {
        // given
        element1 = new Element(0, false, false);   // |
        element2 = new Element(1, false, false);   // blank
        element3 = new Element(2, false, false);   // |

        // when
        element4 = new Element(3, false, true);    // expected : -----

        // then
        assertTrue(element4.getHasStep());
    }

    @Test
    @DisplayName("이전 칸에 발판이 없고 랜덤값이 거짓이라면 다음 칸엔 발판이 생성되지 않는다")
    void isStepFalseTest2() {
        // given
        element1 = new Element(0, false, false);   // |
        element2 = new Element(1, false, false);   // blank
        element3 = new Element(2, false, false);   // |

        // when
        element4 = new Element(3, false, false);    // expected : blank

        // then
        assertFalse(element4.getHasStep());
    }
}