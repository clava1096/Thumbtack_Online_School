package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.winobjects.v3.Desktop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectPicture {

    @Test
    public void testRectPicture1() throws GraphicException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        try{
            RectPicture rectPicture = new RectPicture(topLeft, bottomRight, (PictureFormat) null);
        }
        catch (GraphicException ex){
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        RectPicture rectPicture = new RectPicture(topLeft, bottomRight, PictureFormat.GIF);
        assertAll(
                () -> assertEquals(10, rectPicture.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture.getTopLeft().getY()),
                () -> assertEquals(30, rectPicture.getBottomRight().getX()),
                () -> assertEquals(40, rectPicture.getBottomRight().getY()),
                () -> assertEquals(21, rectPicture.getWidth()),
                () -> assertEquals(21, rectPicture.getHeight()),
                () -> assertEquals(PictureFormat.GIF, rectPicture.getFormat())
        );
    }

    @Test
    public void testRectPicture2() throws GraphicException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectPicture rectPicture = new RectPicture(topLeft, bottomRight, "GIF");
        assertAll(
                () -> assertEquals(10, rectPicture.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture.getTopLeft().getY()),
                () -> assertEquals(30, rectPicture.getBottomRight().getX()),
                () -> assertEquals(40, rectPicture.getBottomRight().getY()),
                () -> assertEquals(21, rectPicture.getWidth()),
                () -> assertEquals(21, rectPicture.getHeight()),
                () -> assertEquals(PictureFormat.GIF, rectPicture.getFormat())
        );
    }

    @Test
    public void testRectPicture3() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40, PictureFormat.GIF);
        assertAll(
                () -> assertEquals(10, rectPicture.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture.getTopLeft().getY()),
                () -> assertEquals(39, rectPicture.getBottomRight().getX()),
                () -> assertEquals(59, rectPicture.getBottomRight().getY()),
                () -> assertEquals(30, rectPicture.getWidth()),
                () -> assertEquals(40, rectPicture.getHeight()),
                () -> assertEquals(PictureFormat.GIF, rectPicture.getFormat())
        );
    }

    @Test
    public void testRectPicture4() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40, "GIF");
        assertAll(
                () -> assertEquals(10, rectPicture.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture.getTopLeft().getY()),
                () -> assertEquals(39, rectPicture.getBottomRight().getX()),
                () -> assertEquals(59, rectPicture.getBottomRight().getY()),
                () -> assertEquals(30, rectPicture.getWidth()),
                () -> assertEquals(40, rectPicture.getHeight()),
                () -> assertEquals(PictureFormat.GIF, rectPicture.getFormat())
        );
    }

    @Test
    public void testRectPicture5() throws GraphicException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectPicture rectPicture = new RectPicture(topLeft, bottomRight);
        assertAll(
                () -> assertEquals(10, rectPicture.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture.getTopLeft().getY()),
                () -> assertEquals(30, rectPicture.getBottomRight().getX()),
                () -> assertEquals(40, rectPicture.getBottomRight().getY()),
                () -> assertEquals(21, rectPicture.getWidth()),
                () -> assertEquals(21, rectPicture.getHeight()),
                () -> assertEquals(PictureFormat.GIF, rectPicture.getFormat())
        );
        try{
            RectPicture rectPicture1 = new RectPicture(topLeft, bottomRight,(PictureFormat) null);
        }
        catch(GraphicException ex){
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
    }

    @Test
    public void testRectPicture6() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        assertAll(
                () -> assertEquals(10, rectPicture.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture.getTopLeft().getY()),
                () -> assertEquals(39, rectPicture.getBottomRight().getX()),
                () -> assertEquals(59, rectPicture.getBottomRight().getY()),
                () -> assertEquals(30, rectPicture.getWidth()),
                () -> assertEquals(40, rectPicture.getHeight()),
                () -> assertEquals(PictureFormat.GIF, rectPicture.getFormat())
        );
    }

    @SuppressWarnings("unused")
    @Test
    public void testWrongSettings() {
        boolean failed = false;
        try {
            RectPicture picture = new RectPicture(10, 20, 10, 20, (PictureFormat) null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        try {
            RectPicture picture = new RectPicture(10, 20, 10, 20, (String) null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        try {
            RectPicture picture = new RectPicture(10, 20, 10, 20, "BMP");
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.WRONG_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        if (failed) {
            fail();
        }
    }

    @Test
    public void testMoveToRectPicture1() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        rectPicture.moveTo(100, 50);
        assertAll(
                () -> assertEquals(100, rectPicture.getTopLeft().getX()),
                () -> assertEquals(50, rectPicture.getTopLeft().getY()),
                () -> assertEquals(129, rectPicture.getBottomRight().getX()),
                () -> assertEquals(89, rectPicture.getBottomRight().getY()),
                () -> assertEquals(30, rectPicture.getWidth()),
                () -> assertEquals(40, rectPicture.getHeight())
        );
    }

    @Test
    public void testMoveToRectPicture2() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        rectPicture.moveTo(new Point(100, 50));
        assertAll(
                () -> assertEquals(100, rectPicture.getTopLeft().getX()),
                () -> assertEquals(50, rectPicture.getTopLeft().getY()),
                () -> assertEquals(129, rectPicture.getBottomRight().getX()),
                () -> assertEquals(89, rectPicture.getBottomRight().getY()),
                () -> assertEquals(30, rectPicture.getWidth()),
                () -> assertEquals(40, rectPicture.getHeight())
        );
    }

    @Test
    public void testMoveRelRectPicture() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        rectPicture.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, rectPicture.getTopLeft().getX()),
                () -> assertEquals(70, rectPicture.getTopLeft().getY()),
                () -> assertEquals(139, rectPicture.getBottomRight().getX()),
                () -> assertEquals(109, rectPicture.getBottomRight().getY()),
                () -> assertEquals(30, rectPicture.getWidth()),
                () -> assertEquals(40, rectPicture.getHeight())
        );
    }

    @Test
    public void testResizeRectPicture() throws GraphicException {
        RectPicture rectPicture1 = new RectPicture(10, 20, 30, 40);
        rectPicture1.resize(2);
        assertAll(
                () -> assertEquals(10, rectPicture1.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture1.getTopLeft().getY()),
                () -> assertEquals(69, rectPicture1.getBottomRight().getX()),
                () -> assertEquals(99, rectPicture1.getBottomRight().getY()),
                () -> assertEquals(60, rectPicture1.getWidth()),
                () -> assertEquals(80, rectPicture1.getHeight())
        );
        RectPicture rectPicture2 = new RectPicture(10, 20, 30, 40);
        rectPicture2.resize(0.5);
        assertAll(
                () -> assertEquals(10, rectPicture2.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture2.getTopLeft().getY()),
                () -> assertEquals(24, rectPicture2.getBottomRight().getX()),
                () -> assertEquals(39, rectPicture2.getBottomRight().getY()),
                () -> assertEquals(15, rectPicture2.getWidth()),
                () -> assertEquals(20, rectPicture2.getHeight())
        );
        RectPicture rectPicture3 = new RectPicture(10, 20, 4, 4);
        rectPicture3.resize(0.5);
        assertAll(
                () -> assertEquals(10, rectPicture3.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture3.getTopLeft().getY()),
                () -> assertEquals(11, rectPicture3.getBottomRight().getX()),
                () -> assertEquals(21, rectPicture3.getBottomRight().getY()),
                () -> assertEquals(2, rectPicture3.getWidth()),
                () -> assertEquals(2, rectPicture3.getHeight())
        );
        RectPicture rectPicture4 = new RectPicture(10, 20, 30, 40);
        rectPicture4.resize(0.01);
        assertAll(
                () -> assertEquals(10, rectPicture4.getTopLeft().getX()),
                () -> assertEquals(20, rectPicture4.getTopLeft().getY()),
                () -> assertEquals(10, rectPicture4.getBottomRight().getX()),
                () -> assertEquals(20, rectPicture4.getBottomRight().getY()),
                () -> assertEquals(1, rectPicture4.getWidth()),
                () -> assertEquals(1, rectPicture4.getHeight())
        );
    }

    @Test
    public void testIsPointInsideRectPicture1() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        assertAll(
                () -> assertTrue(rectPicture.isInside(20, 30)),
                () -> assertTrue(rectPicture.isInside(10, 30)),
                () -> assertTrue(rectPicture.isInside(30, 30)),
                () -> assertTrue(rectPicture.isInside(10, 59)),
                () -> assertFalse(rectPicture.isInside(10, 60)),
                () -> assertFalse(rectPicture.isInside(0, 0)),
                () -> assertFalse(rectPicture.isInside(10, 100)),
                () -> assertFalse(rectPicture.isInside(-10, 20)),
                () -> assertFalse(rectPicture.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsideRectPicture2() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        assertAll(
                () -> assertTrue(rectPicture.isInside(new Point(20, 30))),
                () -> assertTrue(rectPicture.isInside(new Point(10, 30))),
                () -> assertTrue(rectPicture.isInside(new Point(30, 30))),
                () -> assertTrue(rectPicture.isInside(new Point(10, 59))),
                () -> assertFalse(rectPicture.isInside(new Point(10, 60))),
                () -> assertFalse(rectPicture.isInside(new Point(0, 0))),
                () -> assertFalse(rectPicture.isInside(new Point(10, 100))),
                () -> assertFalse(rectPicture.isInside(new Point(-10, 20))),
                () -> assertFalse(rectPicture.isInside(new Point(10, -20)))
        );
    }

    @Test
    public void testIsIntersectsRectPicture() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        assertAll(
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(15, 25, 25, 35))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(-10, 20, 30, 40))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(10, 20, 50, 40))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(-10, 20, 50, 40))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(10, -20, 30, 41))),
                () -> assertFalse(rectPicture.isIntersects(new RectPicture(10, -20, 30, 40))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(10, 20, 30, 60))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(-10, -20, 50, 60))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(0, 10, 20, 30))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(20, 30, 40, 50))),
                () -> assertFalse(rectPicture.isIntersects(new RectPicture(-40, 20, -30, 40))),
                () -> assertFalse(rectPicture.isIntersects(new RectPicture(110, 120, 30, 40))),
                () -> assertFalse(rectPicture.isIntersects(new RectPicture(10, 120, 30, 40))),
                () -> assertFalse(rectPicture.isIntersects(new RectPicture(10, -40, 30, 20))),
                () -> assertTrue(rectPicture.isIntersects(new RectPicture(15, 15, 25, 50)))
        );
    }

    @Test
    public void testIsRectPictureInsideRectPicture() throws GraphicException {
        RectPicture rectPicture = new RectPicture(10, 20, 30, 40);
        assertAll(
                () -> assertTrue(rectPicture.isInside(new RectPicture(15, 25, 25, 35))),
                () -> assertFalse(rectPicture.isInside(new RectPicture(-40, 20, 30, 40))),
                () -> assertFalse(rectPicture.isInside(new RectPicture(110, 120, 130, 140))),
                () -> assertFalse(rectPicture.isInside(new RectPicture(10, 120, 30, 40))),
                () -> assertFalse(rectPicture.isInside(new RectPicture(10, -40, 30, 20)))
        );
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertAll(
                () -> assertTrue(new RectPicture(15, 25, 25, 35).isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new RectPicture(0, 0, 639, 479).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RectPicture(200, 200, 640, 480).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RectPicture(-200, -200, 640, 480).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RectPicture(-1200, 700, 1199, 480).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RectPicture(200, -200, 100, 100).isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new RectPicture(200, 300, 100, 100).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RectPicture(200, 700, 100, 100).isFullyVisibleOnDesktop(desktop))
        );
    }

    @Test
    public void testRectPicturesAreEqual() throws GraphicException {
        RectPicture rectPicture1 = new RectPicture(10, 20, 30, 40);
        RectPicture rectPicture2 = new RectPicture(10, 20, 30, 40);
        RectPicture rectPicture3 = new RectPicture(20, 30, 40, 50);
        assertNotEquals(rectPicture1, null);
        assertEquals(rectPicture1, rectPicture1);
        assertNotEquals(rectPicture1, null);
        assertEquals(rectPicture1, rectPicture2);
        assertNotEquals(rectPicture1, rectPicture3);
    }


}
