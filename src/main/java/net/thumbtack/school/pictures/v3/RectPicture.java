package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class RectPicture extends Picture implements Resizable, Movable {
    private Point topLeft, bottomRight;
    // REVU width, height не нужны, так как вычисляются через topLeft и bottomRight
    private int width, height;
    // REVU не нужен, есть у родителя
    private PictureFormat format;
    // REVU В классе должен быть только один конструктор, явно присваивающий значения полям. Остальные должны вызывать другой конструктор
    public RectPicture(Point topLeft, Point bottomRight, PictureFormat format) throws GraphicException{
        // REVU сделайте конструктор в родительском классе (то есть Picture) и вызывайте его через super(...)
        this.topLeft= topLeft;
        this.bottomRight = bottomRight;
        this.width = bottomRight.getX()-topLeft.getX()+1;
        this.height = bottomRight.getY()-topLeft.getY()+1;
        setFormat(format);
        this.format = format;
    }

    public RectPicture(Point topLeft, Point bottomRight, String format) throws  GraphicException{
        this.topLeft= topLeft;
        this.bottomRight = bottomRight;
        this.width = bottomRight.getX()-topLeft.getX()+1;
        this.height = bottomRight.getY()-topLeft.getY()+1;
        this.format = PictureFormat.fromString(format);
    }

    public RectPicture(int xLeft, int yTop, int width, int height, PictureFormat format) throws GraphicException{
        this.width = width;
        setFormat(format);
        this.format = format;
        this.height = height;
        topLeft = new Point(xLeft,yTop);
        bottomRight = new Point(width+xLeft-1, yTop+height-1);
    }

    public RectPicture(int xLeft, int yTop, int width, int height, String format) throws GraphicException {
        this.width = width;
        this.format = PictureFormat.fromString(format);
        this.height = height;
        topLeft = new Point(xLeft,yTop);
        bottomRight = new Point(width+xLeft-1, yTop+height-1);
    }

    public RectPicture(Point topLeft, Point bottomRight) throws GraphicException{
        format = PictureFormat.GIF;
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.width = bottomRight.getX()-topLeft.getX()+1;
        this.height = bottomRight.getY() - topLeft.getY()+1;
    }
    public RectPicture(int xLeft, int yTop, int width, int height) throws GraphicException{
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(width+xLeft-1, yTop+height-1);
        this.width = width;
        this.height = height;
        this.format = PictureFormat.GIF;
    }
    public Point getTopLeft(){
        return topLeft;
    }
    public Point getBottomRight(){
        return bottomRight;
    }
    public PictureFormat getFormat(){
        return format;
    }

    public void setTopLeft(Point topLeft){
        this.topLeft = topLeft;
        width = bottomRight.getX()-topLeft.getX()+1;
        height = bottomRight.getY() - topLeft.getY()+1;
    }
    public void setBottomRight(Point bottomRight){
        this.bottomRight = bottomRight;
        width = bottomRight.getX()-topLeft.getX()+1;
        height = bottomRight.getY() - topLeft.getY()+1;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void moveTo(int x, int y){
        topLeft.moveTo(x,y);
        this.bottomRight = new Point(width+x-1, y+height-1);
    }
    public void moveTo(Point point){
        topLeft = new Point(point.getX(),point.getY());
        bottomRight = new Point(width+point.getX()-1, point.getY()+height-1);
    }
    public void moveRel(int dx, int dy){
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }
    public void resize(double ratio) {
        int old_h= height ,old_w= width;
        this.height = (int)(this.height*ratio);
        if(height == 0) {height = 1;}
        this.width = (int)(this.width*ratio);
        if(width == 0) {width =1;}
        bottomRight = new Point(bottomRight.getX()-old_w+width, bottomRight.getY()-old_h+height);
    }
    public boolean isInside(int x, int y){
        return bottomRight.getX() >= x & bottomRight.getY() >= y & x >= topLeft.getX() & y >= topLeft.getY();
    }
    public boolean isInside(Point point) {
        return bottomRight.getX() >= point.getX() & bottomRight.getY() >= point.getY() & point.getX() >= topLeft.getX() & point.getY() >= topLeft.getY();
    }

    public boolean isIntersects(RectPicture rectPicture){
        if (bottomRight.getY() <  rectPicture.topLeft.getY() || rectPicture.bottomRight.getY() < topLeft.getY()) return false;
        return bottomRight.getX() >= rectPicture.topLeft.getX() && rectPicture.bottomRight.getX() >= topLeft.getX();
    }

    public boolean isInside(RectPicture rectPicture){
        return (rectPicture.bottomRight.getX() <= bottomRight.getX() && topLeft.getX() <=rectPicture.topLeft.getX() &&
                rectPicture.bottomRight.getY() <= bottomRight.getY() && topLeft.getY() <= rectPicture.topLeft.getY());
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return topLeft.getY() >= 0 & topLeft.getX() >= 0 & bottomRight.getX() < 640 & bottomRight.getY() < 480;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectPicture that = (RectPicture) o;
        return format == that.format && width == that.width && height == that.height && Objects.equals(topLeft, that.topLeft) && Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight, format, width, height);
    }
}
