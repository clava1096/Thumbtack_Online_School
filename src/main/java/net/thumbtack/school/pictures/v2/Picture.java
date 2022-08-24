package net.thumbtack.school.pictures.v2;

import net.thumbtack.school.iface.v2.Movable;
import net.thumbtack.school.iface.v2.Resizable;
import net.thumbtack.school.winobjects.v2.Desktop;

public abstract class Picture implements Movable, Resizable {
    private int format;
    private Point topLeft, bottomRight;

    public int getFormat(){
        return format;
    }

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    public abstract void moveTo(int x, int y);

    public abstract void moveTo(Point point);


}
