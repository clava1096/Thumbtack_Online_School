package net.thumbtack.school.pictures.v1;

import java.util.Objects;

public class RoundPicture {
    private Point center;
    private int format, radius;
    public RoundPicture(Point center, int radius, int format) {
        this.center = center;
        this.radius = radius;
        this.format = format;
    }

    public RoundPicture(int xCenter, int yCenter, int radius, int format) {
        center = new Point(xCenter,yCenter);
        this.radius = radius;
        this.format = format;
    }

    public RoundPicture(Point center, int radius) {
        format = 1;
        this.center = center;
        this.radius = radius;
    }

    public RoundPicture(int xCenter, int yCenter, int radius) {
        center = new Point(xCenter,yCenter);
        format = 1;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public int getFormat() {
        return format;
    }

    public void moveTo(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    public void moveTo(Point point) {
        this.center.setX(point.getX());
        this.center.setY(point.getY());
    }

    public void setCenter(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    public void setRadius(int radius) {
        this.radius=radius;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public void moveRel(int dx, int dy){
        this.center.setX(center.getX()+dx);
        this.center.setY(center.getY()+dy);
    }

    public void resize(double ratio){
        this.radius = (int)(this.radius*ratio);
        if (radius == 0) radius=1;
    }
    public boolean isInside(int x, int y){
        int Xc = center.getX(), Yc = center.getY();
        if(((x - Xc) * (x - Xc) + (y - Yc) * (y - Yc)) <= radius * radius){
            return true;
        }
        return false;
    }

    public boolean isInside(Point point){
        int Xc = center.getX(), Yc = center.getY();
        if(((point.getX() - Xc) * (point.getX() - Xc) + (point.getY() - Yc) * (point.getY() - Yc))<=radius*radius ){
            return true;
        }
        return false;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop){
        int xLeft = center.getX()-radius; // >=0
        int xRight = center.getX()+radius; // <=640
        int yUp = center.getY()+radius; // <=480
        int yDown = center.getY()-radius; // >=0
        if (xLeft >=0 && xRight < desktop.getWidth() && yUp <desktop.getHeight() && yDown>=0) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundPicture that = (RoundPicture) o;
        return format == that.format && radius == that.radius && Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, format, radius);
    }
}
