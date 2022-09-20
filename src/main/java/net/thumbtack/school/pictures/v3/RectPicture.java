package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class RectPicture extends Picture implements Resizable, Movable {
    private Point topLeft, bottomRight;
    public RectPicture(Point topLeft, Point bottomRight, PictureFormat format) throws GraphicException{
        super(bottomRight.getY()-topLeft.getY()+1, bottomRight.getX()-topLeft.getX()+1, format);
        setFormat(format);
        this.topLeft= topLeft;
        this.bottomRight = bottomRight;
    }

    public RectPicture(Point topLeft, Point bottomRight, String format) throws  GraphicException{
        this(topLeft, bottomRight, PictureFormat.fromString(format));
    }

    public RectPicture(int xLeft, int yTop, int width, int height, PictureFormat format) throws GraphicException{
        this(new Point(xLeft,yTop), new Point(width+xLeft-1, yTop+height-1), format);
    }

    public RectPicture(int xLeft, int yTop, int width, int height, String format) throws GraphicException {
        this(new Point(xLeft,yTop), new Point(width+xLeft-1, yTop+height-1), PictureFormat.fromString(format));
    }

    public RectPicture(Point topLeft, Point bottomRight) throws GraphicException{
        this(topLeft, bottomRight, PictureFormat.GIF);
    }
    public RectPicture(int xLeft, int yTop, int width, int height) throws GraphicException{
        this(new Point(xLeft, yTop), new Point(width+xLeft-1, yTop+height-1), PictureFormat.GIF);
    }
    public Point getTopLeft(){
        return topLeft;
    }
    public Point getBottomRight(){
        return bottomRight;
    }
    public void setTopLeft(Point topLeft){
        this.topLeft = topLeft;
        setWidth(topLeft.getX() + this.bottomRight.getX() + 1);
        setHeight(topLeft.getY() + this.bottomRight.getY() + 1);
    }
    public void setBottomRight(Point bottomRight){
        this.bottomRight = bottomRight;
        setWidth(topLeft.getX() + this.bottomRight.getX() + 1);
        setHeight(topLeft.getY() + this.bottomRight.getY() + 1);
    }
    @Override
    public void moveTo(int x, int y){
        topLeft.moveTo(x,y);
        //bottomRight.moveTo(x,y);
        this.bottomRight = new Point(getWidth()+x-1, y+getHeight()-1);
    }

    @Override
    public void moveRel(int dx, int dy){
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }
    @Override
    public void resize(double ratio) {
        int old_h= bottomRight.getY() - topLeft.getY()+1 ,old_w= bottomRight.getX()-topLeft.getX()+1;
        setHeight((int)(getHeight()*ratio));
        if (getHeight() == 0) {setHeight(1);}
        setWidth((int)(getWidth()*ratio));
        if (getWidth() == 0) {setWidth(1);}
        bottomRight = new Point(bottomRight.getX() - old_w+getWidth(), bottomRight.getY() - old_h+getHeight());
    }
    @Override
    public boolean isInside(int x, int y){
        return bottomRight.getX() >= x & bottomRight.getY() >= y & x >= topLeft.getX() & y >= topLeft.getY();
    }

    public boolean isIntersects(RectPicture rectPicture){
        if (bottomRight.getY() <  rectPicture.topLeft.getY() || rectPicture.bottomRight.getY() < topLeft.getY()) return false;
        return bottomRight.getX() >= rectPicture.topLeft.getX() && rectPicture.bottomRight.getX() >= topLeft.getX();
    }
    public boolean isInside(RectPicture rectPicture){
        return (rectPicture.bottomRight.getX() <= bottomRight.getX() && topLeft.getX() <=rectPicture.topLeft.getX() &&
                rectPicture.bottomRight.getY() <= bottomRight.getY() && topLeft.getY() <= rectPicture.topLeft.getY());
    }
    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return topLeft.getY() >= 0 & topLeft.getX() >= 0 & bottomRight.getX() < 640 & bottomRight.getY() < 480;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectPicture that = (RectPicture) o;
        return Objects.equals(topLeft, that.topLeft) && Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
