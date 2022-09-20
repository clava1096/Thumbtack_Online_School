package net.thumbtack.school.winobjects.v3;

import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.pictures.v3.Point;

import java.util.Objects;

public class Cursor implements Movable {
    private int x,y;
    private CursorForm cursorForm;
    public Cursor(int x, int y, CursorForm cursorForm){
        this.cursorForm = cursorForm;
        this.y = y;
        this.x = x;
    }

    public Cursor(Point point, CursorForm cursorForm){
        this.cursorForm = cursorForm;
        this.x = point.getX();
        this.y = point.getY();
    }

    public CursorForm getCursorForm(){
        return cursorForm;
    }

    public void setCursorForm(CursorForm cursorForm){
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

    @Override
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
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
