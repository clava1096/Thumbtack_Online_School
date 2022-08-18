package net.thumbtack.school.winobjects.v2;

import net.thumbtack.school.iface.Movable;
import net.thumbtack.school.iface.Signed;
import net.thumbtack.school.pictures.v2.Point;

public class Icon implements Movable, Signed {
    int x,y; String signature;
    public Icon(int x,int y, String signature){
        this.x = x;
        this.y = y;
        this.signature = signature;
    }
    public Icon(Point point, String signature) {
        this.x = point.getX();
        this.y = point.getY();
        this.signature = signature;
    }

    public void setSignature(String signature){
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

}
