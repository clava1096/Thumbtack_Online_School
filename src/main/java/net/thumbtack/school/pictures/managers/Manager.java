package net.thumbtack.school.pictures.managers;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.pictures.v3.Picture;
import net.thumbtack.school.pictures.v3.Point;

class Manager<T extends Picture>  {
    private T picture;
    public Manager(T obj) throws GraphicException{
        super();
        checkPicture(obj);
        this.picture =  obj;
    }

    public T getPicture(){
        return picture;
    }
    public void setPicture(T obj) throws GraphicException {
        checkPicture(obj);
        this.picture = obj;
    }

    public void moveTo(int x, int y){
        picture.moveTo(x,y);
    }

    public void moveTo(Point point){
        picture.moveTo(point);
    }

    private void checkPicture(T obj) throws GraphicException{
        if(obj==null){
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
    }

}
