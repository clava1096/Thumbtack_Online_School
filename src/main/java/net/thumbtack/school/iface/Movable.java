package net.thumbtack.school.iface;

import net.thumbtack.school.pictures.v2.Point;

public interface Movable {
    void moveTo(int x, int y);
    default void moveTo(Point point){
        moveTo(point.getX(), point.getY());
    }
    void moveRel(int dx, int dy);
}
