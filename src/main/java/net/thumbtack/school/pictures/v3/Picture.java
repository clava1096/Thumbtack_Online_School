package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Desktop;

public abstract class Picture implements Movable, Resizable {
    private PictureFormat format;
    private int height, width;

    public Picture(int height, int width, PictureFormat format) throws GraphicException {
        this.height = height;
        this.width = width;
        setFormat(format);
    }

    public Picture (PictureFormat format) throws GraphicException{
        setFormat(format);
    }

    public PictureFormat getFormat(){
        return format;
    }

    public void setFormat(PictureFormat format) throws GraphicException {
        checkFormat(format);
        this.format = format;
    }
    private static void checkFormat(PictureFormat pictureFormat) throws GraphicException{
        if(pictureFormat == null){
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
    }
    public void setFormat(String format) throws GraphicException {
        this.format = PictureFormat.fromString(format);
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point point){
        return isInside(point.getX(), point.getY());
    }

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    public abstract void moveTo(int x, int y);

    public void moveTo(Point point){
        moveTo(point.getX(), point.getY());
    }


}
