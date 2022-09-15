package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.iface.v3.Signed;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class SignedRectPicture extends RectPicture implements Resizable, Movable, Signed {
    String signature;

    // REVU В классе должен быть только один конструктор, явно присваивающий значения полям. Остальные должны вызывать другой конструктор
    public SignedRectPicture(Point topLeft, Point bottomRight, PictureFormat format, String signature) throws GraphicException{
        super(topLeft,bottomRight,format);
        checkSignature(signature);
        this.signature = signature;
    }
    public SignedRectPicture(Point topLeft, Point bottomRight, String format, String signature) throws GraphicException {
        super(topLeft,bottomRight,format);
        checkSignature(signature);
        this.signature = signature;
    }
    public SignedRectPicture(int xLeft, int yTop, int width, int height, PictureFormat format, String signature) throws GraphicException{
        super(xLeft, yTop, width, height, format);
        checkSignature(signature);
        this.signature = signature;
    }
    public SignedRectPicture(int xLeft, int yTop, int width, int height, String format, String signature) throws GraphicException {
        super(xLeft, yTop, width, height, format);
        checkSignature(signature);
        this.signature = signature;
    }
    public SignedRectPicture(Point topLeft, Point bottomRight, String signature) throws GraphicException{
        super(topLeft, bottomRight,PictureFormat.GIF);
        this.signature = signature;
    }
    public SignedRectPicture(int xLeft, int yTop, int width, int height, String signature) throws GraphicException{
        super(xLeft, yTop, width, height,PictureFormat.GIF);
        this.signature = signature;
    }
    // REVU Если метод у потомка только вызывает тот же метод родителя и ничего больше не делает, то его переопределять не надо. Удалите все такие методы
    public Point getTopLeft(){
        return super.getTopLeft();
    }
    public Point getBottomRight(){
        return super.getBottomRight();
    }
    public PictureFormat getFormat(){
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
    public void setSignature(String signature) throws GraphicException{
        checkSignature(signature);
        this.signature = signature;
    }
    public void moveTo(int x, int y){
        super.moveTo(x,y);
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
        SignedRectPicture that = (SignedRectPicture) o;
        return Objects.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), signature);
    }
}
