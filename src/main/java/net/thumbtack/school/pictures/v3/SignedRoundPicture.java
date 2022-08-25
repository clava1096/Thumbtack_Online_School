package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.iface.v3.Signed;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class SignedRoundPicture extends RoundPicture implements Resizable, Movable, Signed {
    String signature;
    public SignedRoundPicture(Point center, int radius, PictureFormat format, String signature) throws GraphicException {
        super(center,radius,format);
        checkSignature(signature);
        this.signature = signature;
    }
    public SignedRoundPicture(int xCenter, int yCenter, int radius, PictureFormat format, String signature) throws GraphicException {
        super(xCenter,yCenter,radius,format);
        checkSignature(signature);
        this.signature = signature;
    }

    public SignedRoundPicture(int xCenter, int yCenter, int radius, String format, String signature) throws GraphicException {
        super(xCenter,yCenter,radius,format);
        checkSignature(signature);
        this.signature = signature;
    }

    public SignedRoundPicture(Point center, int radius, String signature) throws GraphicException{
        super(center,radius);
        checkSignature(signature);
        this.signature = signature;
    }
    public SignedRoundPicture(int xCenter, int yCenter, int radius, String signature) throws GraphicException{
        super(xCenter,yCenter,radius);
        checkSignature(signature);
        this.signature = signature;
    }

    public SignedRoundPicture(Point center, int radius, String format, String signature) throws GraphicException{
        super(center, radius, format);
        checkSignature(signature);
        this.signature = signature;
    }

    public Point getCenter() {
        return super.getCenter();
    }
    public int getRadius(){
        return super.getRadius();
    }
    public PictureFormat getFormat(){
        return super.getFormat();
    }

    public String getSignature(){
        return signature;
    }
    public void setSignature(String signature) throws GraphicException{
        checkSignature(signature);
        this.signature = signature;
    }
    public void setCenter(int x, int y){
        super.setCenter(x, y);
    }
    public void setRadius(int radius){
        super.setRadius(radius);
    }
    public void moveTo(int x, int y){
        super.moveTo(x,y);
    }
    public void moveRel(int dx, int dy){
        super.moveRel(dx,dy);
    }
    public void resize(double ratio){
        super.resize(ratio);
    }
    public boolean isInside(int x, int y){
        return super.isInside(x, y);
    }
    public boolean isInside(Point point){
        return super.isInside(point);
    }
    public boolean isFullyVisibleOnDesktop(Desktop desktop){
        return super.isFullyVisibleOnDesktop(desktop);
    }

    private static void checkSignature(String signature) throws GraphicException{
        if(signature == null){
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
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
