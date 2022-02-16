package domain.game.ladder;

import application.domain.ladder.Shape;
import application.domain.ladder.element.Element;
import application.domain.ladder.element.Line;
import application.domain.ladder.element.None;
import application.domain.ladder.element.Pole;
import application.message.ShapeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ShapeTest {
    private Shape<Element> shape;
    private Line line;
    private None none;
    private Pole pole;

    @BeforeEach
    void before() {
        shape = new Shape(3, 5); /* 높이가 3, 너비가 5 인 사다리 */
        line = new Line(1);
        none = new None(1);
        pole = new Pole();
    }

    @Test
    void testAddElementFail() {
        assertThatThrownBy(() -> shape.addElement(shape.getHeight(), line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ShapeMessage.getRowIndexErrMsg(shape.getHeight()));

        for (int w = 0; w < shape.getWidth(); ++w) {
            shape.addElement(0, line);
        }
        assertThatThrownBy(() -> shape.addElement(0, line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ShapeMessage.getColIndexErrMsg(0, shape.getWidth()));
    }

    @Test
    void testGetElement() {
        shape.addElement(0, line);
        shape.addElement(0, none);
        shape.addElement(0, pole);
        shape.addElement(1, line);

        assertThat(shape.getElement(0, 0)).isInstanceOf(Line.class);
        assertThat(shape.getElement(0, 1)).isInstanceOf(None.class);
        assertThat(shape.getElement(0, 2)).isInstanceOf(Pole.class);
        assertThat(shape.getElement(1, 0)).isInstanceOf(Line.class);
    }
}