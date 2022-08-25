package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Desktop;

public abstract class Picture implements Movable, Resizable {
    private PictureFormat format;

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

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    public abstract void moveTo(int x, int y);

    public abstract void moveTo(Point point);


}
