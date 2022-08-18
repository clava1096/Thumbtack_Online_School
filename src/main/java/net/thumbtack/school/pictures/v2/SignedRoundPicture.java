package net.thumbtack.school.pictures.v2;

import net.thumbtack.school.iface.Movable;
import net.thumbtack.school.iface.Resizable;
import net.thumbtack.school.iface.Signed;
import net.thumbtack.school.winobjects.v2.Desktop;

import java.util.Objects;

public class SignedRoundPicture extends RoundPicture implements Resizable, Movable, Signed {
    String signature;
    public SignedRoundPicture(Point center, int radius, int format, String signature){
        super(center,radius,format);
        this.signature = signature;
    }
    public SignedRoundPicture(int xCenter, int yCenter, int radius, int format, String signature){
        super(xCenter,yCenter,radius,format);
        this.signature = signature;
    }
    public SignedRoundPicture(Point center, int radius, String signature){
        super(center,radius);
        this.signature = signature;
    }
    public SignedRoundPicture(int xCenter, int yCenter, int radius, String signature){
        super(xCenter,yCenter,radius);
        this.signature = signature;
    }
    public Point getCenter() {
        return super.getCenter();
    }
    public int getRadius(){
        return super.getRadius();
    }
    public int getFormat(){
        return super.getFormat();
    }
    public String getSignature(){
        return signature;
    }
    public void setSignature(String signature){
        this.signature = signature;
    }
    public void setCenter(int x, int y){
        super.setCenter(x, y);
    }
    public void setRadius(int radius){
        super.setRadius(radius);
    }
    //public void moveTo(Point point){
   //     super.moveTo(point);
    //}
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
