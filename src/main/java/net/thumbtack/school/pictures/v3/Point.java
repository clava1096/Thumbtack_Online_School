package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class Point extends GraphicException {
    private int x,y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Point(){
        x = 0;
        y = 0;
    }
    public Point(Point point){
        this.x = point.getX();
        this.y = point.getY();
    }
    public  int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void moveRel(int dx, int dy){
        this.x = this.x+dx;
        this.y = this.y+dy;
    }
    public boolean isVisibleOnDesktop(Desktop desktop) {
        if (this.x < 0 | this.y <0){return false;}
        if (desktop.getWidth() > this.x && desktop.getHeight() > this.y) // 640 >= -1 : 480 >=100
            return true;
        return false;
    }
    public boolean isNotVisibleOnDesktop(Desktop desktop){
        if (this.x <= 0 | this.y <= 0){return true;}
        if (desktop.getWidth() < this.x && desktop.getHeight() < this.y)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
