package net.thumbtack.school.winobjects.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Signed;
import net.thumbtack.school.pictures.v3.Point;

public class Icon implements Movable, Signed {
    int x,y; String signature;
    public Icon(int x,int y, String signature){
        this.x = x;
        this.y = y;
        this.signature = signature;
    }
    public Icon(Point point, String signature) throws GraphicException {
        this.x = point.getX();
        this.y = point.getY();
        checkSignature(signature);
        this.signature = signature;

    }

    public void setSignature(String signature) throws GraphicException{
        checkSignature(signature);
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }
    public int getX(){
        return x;
    }
    public void setX (int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void moveRel(int dx, int dy){
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    private static void checkSignature(String signature) throws GraphicException {
        if(signature == null){
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
    }

}
