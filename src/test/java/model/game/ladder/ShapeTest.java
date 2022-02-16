package model.game.ladder;

import message.ShapeMessage;
import model.game.ladder.element.Element;
import model.game.ladder.element.Line;
import model.game.ladder.element.None;
import model.game.ladder.element.Pole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ShapeTest {
    private Shape<Element> shape;

    @BeforeEach
    void before() {
        shape = new Shape(3, 5, 1); /* 높이가 3, 너비가 5 인 사다리 */
    }

    @Test
    void testAddElementFail() {
        assertThatThrownBy(() -> shape.addElement(shape.getHeight(), shape.line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ShapeMessage.getRowIndexErrMsg(shape.getHeight()));

        for (int w = 0; w < shape.getWidth(); ++w) {
            shape.addElement(0, shape.line);
        }
        assertThatThrownBy(() -> shape.addElement(0, shape.line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ShapeMessage.getColIndexErrMsg(0, shape.getWidth()));
    }

    @Test
    void testGetElement() {
        shape.addElement(0, shape.line);
        shape.addElement(0, shape.none);
        shape.addElement(0, shape.pole);
        shape.addElement(1, shape.line);

        assertThat(shape.getElement(0, 0)).isInstanceOf(Line.class);
        assertThat(shape.getElement(0, 1)).isInstanceOf(None.class);
        assertThat(shape.getElement(0, 2)).isInstanceOf(Pole.class);
        assertThat(shape.getElement(1, 0)).isInstanceOf(Line.class);
    }
}