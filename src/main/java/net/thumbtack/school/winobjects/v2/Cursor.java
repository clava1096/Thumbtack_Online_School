package net.thumbtack.school.winobjects.v2;

import net.thumbtack.school.iface.Movable;
import net.thumbtack.school.pictures.v2.Point;

import java.util.Objects;

public class Cursor implements Movable {
    private int x,y, cursorForm;
    public Cursor(int x, int y, int cursorForm){
        this.cursorForm = cursorForm;
        this.y = y;
        this.x = x;
    }

    public Cursor(Point point, int cursorForm){
        this.cursorForm = cursorForm;
        this.x = point.getX();
        this.y = point.getY();
    }

    public int getCursorForm(){
        return cursorForm;
    }

    public void setCursorForm(int cursorForm){
        this.cursorForm = cursorForm;
    }

    public int getX(){
        return x;
    }
    public void setX(int x){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursor cursor = (Cursor) o;
        return x == cursor.x && y == cursor.y && cursorForm == cursor.cursorForm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, cursorForm);
    }

}
