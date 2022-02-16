package model.game.ladder;

import model.game.ladder.element.Element;
import model.game.ladder.element.Line;
import model.game.ladder.element.None;
import model.game.ladder.element.Pole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ShapeTest {
    private Shape<Element> shape;
    private Element line;
    private Element none;
    private Element pole;

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
                .isInstanceOf(IllegalArgumentException.class);

        for (int w = 0; w < shape.getWidth(); ++w) {
            shape.addElement(0, line);
        }
        assertThatThrownBy(() -> shape.addElement(0, line))
                .isInstanceOf(IllegalArgumentException.class);
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