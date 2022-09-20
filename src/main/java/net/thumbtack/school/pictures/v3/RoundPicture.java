package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class RoundPicture extends Picture implements Resizable, Movable {
    private Point center;
    private int radius;
    public RoundPicture(Point center, int radius, PictureFormat format) throws GraphicException {
        super(format);
        this.center = center;
        this.radius = radius;
    }

    public RoundPicture(int xCenter, int yCenter, int radius, PictureFormat format) throws GraphicException {
        this(new Point(xCenter,yCenter), radius , format);
    }

    public RoundPicture(int xCenter, int yCenter, int radius, String format) throws GraphicException {
        this(new Point(xCenter,yCenter), radius, PictureFormat.fromString(format));
    }

    public RoundPicture(Point center, int radius) throws GraphicException{
        this(center, radius, PictureFormat.GIF);
    }

    public RoundPicture(int xCenter, int yCenter, int radius) throws GraphicException{
        this(new Point(xCenter,yCenter), radius, PictureFormat.GIF);
    }

    public RoundPicture(Point center, int radius, String format)  throws GraphicException{
        this(center, radius, PictureFormat.fromString(format));
    }

    public void setRadius(int radius) {
        this.radius=radius;
    }

    public int getRadius() {
        return radius;
    }
    @Override
    public void moveTo(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }
    @Override
    public void moveRel(int dx, int dy){
        this.center.setX(center.getX()+dx);
        this.center.setY(center.getY()+dy);
    }
    @Override
    public void resize(double ratio){
        setRadius((int)(getRadius()*ratio));
        if (getRadius() == 0) {setRadius(1);}
    }
    @Override
    public boolean isInside(int x, int y){
        int Xc = center.getX(), Yc = center.getY();
        return ((x - Xc) * (x - Xc) + (y - Yc) * (y - Yc)) <= getRadius() * getRadius();
    }
    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop){
        int xLeft = center.getX()-getRadius();
        int xRight = center.getX()+getRadius();
        int yUp = center.getY()+getRadius();
        int yDown = center.getY()-getRadius();
        return xLeft >= 0 && xRight < desktop.getWidth() && yUp < desktop.getHeight() && yDown >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundPicture that = (RoundPicture) o;
        return radius == that.radius && Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
