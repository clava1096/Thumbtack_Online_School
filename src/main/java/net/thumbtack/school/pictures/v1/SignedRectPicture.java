package net.thumbtack.school.pictures.v1;

import java.util.Objects;

public class SignedRectPicture extends RectPicture{
    String signature;
    public SignedRectPicture(Point topLeft, Point bottomRight, int format, String signature){
        super(topLeft,bottomRight,format);
        this.signature = signature;
    }
    public SignedRectPicture(int xLeft, int yTop, int width, int height, int format, String signature){
        super(xLeft, yTop, width, height, format);
        this.signature = signature;
    }
    public SignedRectPicture(Point topLeft, Point bottomRight, String signature){
        super(topLeft, bottomRight,1);
        this.signature = signature;
    }
    public SignedRectPicture(int xLeft, int yTop, int width, int height, String signature){
        super(xLeft, yTop, width, height,1);
        this.signature = signature;
    }
    public Point getTopLeft(){
        return super.getTopLeft();
    }
    public Point getBottomRight(){
        return super.getBottomRight();
    }
    public int getFormat(){
        return super.getFormat();
    }
    public int getWidth(){
        return super.getWidth();
    }
    public int getHeight(){
        return super.getHeight();
    }
    public String getSignature(){
        return signature;
    }
    public void setTopLeft(Point topLeft){
        super.setTopLeft(topLeft);
    }
    public void setBottomRight(Point bottomRigth){
        super.setBottomRight(bottomRigth);
    }
    public void setSignature(String signature){
        this.signature = signature;
    }
    public void moveTo(int x, int y){
        super.moveTo(x,y);
    }
    public void moveTo(Point point){
        super.moveTo(point);
    }
    public void moveRel(int dx, int dy){
        super.moveRel(dx, dy);
    }
    public void resize(double ratio){
        super.resize(ratio);
    }
    public boolean isInside(Point point){
        return super.isInside(point);
    }
    public boolean isIntersects(SignedRectPicture SignedRectPicture){
        return super.isIntersects(SignedRectPicture);
    }
    public boolean isInside(SignedRectPicture SignedRectPicture){
        return super.isInside(SignedRectPicture);
    }
    public boolean isFullyVisibleOnDesktop(Desktop desktop){
        return super.isFullyVisibleOnDesktop(desktop);
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
