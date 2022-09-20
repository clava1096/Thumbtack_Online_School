package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.iface.v3.Signed;

import java.util.Objects;

public class SignedRectPicture extends RectPicture implements Resizable, Movable, Signed {
    String signature;

    public SignedRectPicture(Point topLeft, Point bottomRight, PictureFormat format, String signature) throws GraphicException{
        super(topLeft,bottomRight,format);
        checkSignature(signature);
        setSignature(signature);
    }

    public SignedRectPicture(Point topLeft, Point bottomRight, String format, String signature) throws GraphicException {
        this(topLeft,bottomRight,PictureFormat.fromString(format),signature);
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, PictureFormat format, String signature) throws GraphicException{
        this(new Point(xLeft,yTop), new Point(width+xLeft-1, yTop+height-1), format, signature);
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, String format, String signature) throws GraphicException {
        this(new Point(xLeft,yTop), new Point(width+xLeft-1, yTop+height-1), PictureFormat.fromString(format), signature);
    }

    public SignedRectPicture(Point topLeft, Point bottomRight, String signature) throws GraphicException{
        this(topLeft,bottomRight,PictureFormat.GIF, signature);
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, String signature) throws GraphicException{
        this(new Point(xLeft,yTop), new Point(width+xLeft-1, yTop+height-1), PictureFormat.GIF, signature);
    }

    @Override
    public String getSignature(){
        return signature;
    }

    @Override
    public void setSignature(String signature) throws GraphicException{
        checkSignature(signature);
        this.signature = signature;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SignedRectPicture that = (SignedRectPicture) o;
        return Objects.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), signature);
    }
}
