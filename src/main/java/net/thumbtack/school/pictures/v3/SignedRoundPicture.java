package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.iface.v3.Signed;

import java.util.Objects;

public class SignedRoundPicture extends RoundPicture implements Resizable, Movable, Signed {

    String signature;
    public SignedRoundPicture(Point center, int radius, PictureFormat format, String signature) throws GraphicException {
        super(center,radius,format);
        checkSignature(signature);
        setSignature(signature);
    }

    public SignedRoundPicture(int xCenter, int yCenter, int radius, PictureFormat format, String signature) throws GraphicException {
        this(new Point(xCenter,yCenter), radius, format, signature);
    }

    public SignedRoundPicture(int xCenter, int yCenter, int radius, String format, String signature) throws GraphicException {
        this(new Point(xCenter,yCenter), radius, PictureFormat.fromString(format), signature);
    }

    public SignedRoundPicture(Point center, int radius, String signature) throws GraphicException {
        this(center, radius, PictureFormat.GIF ,signature);
    }

    public SignedRoundPicture(int xCenter, int yCenter, int radius, String signature) throws GraphicException{
        this(new Point(xCenter,yCenter), radius, PictureFormat.GIF, signature);
    }

    public SignedRoundPicture(Point center, int radius, String format, String signature) throws GraphicException{
        this(center,radius,PictureFormat.fromString(format),signature);
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
        SignedRoundPicture that = (SignedRoundPicture) o;
        return Objects.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), signature);
    }
}
