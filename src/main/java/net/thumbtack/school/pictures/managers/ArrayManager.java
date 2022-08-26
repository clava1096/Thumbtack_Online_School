package net.thumbtack.school.pictures.managers;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.pictures.v3.Picture;
import net.thumbtack.school.winobjects.v3.Cursor;
import net.thumbtack.school.winobjects.v3.Desktop;

class ArrayManager<T extends Picture> {
    private T[] pictures;

    public ArrayManager(T[] pictures) throws GraphicException {
        super();
        checkArray(pictures);
        this.pictures = pictures;
    }

    public T[] getPictures() {
        return pictures;
    }

    public T getPicture(int i) {
        return pictures[i];
    }

    public void setPicture(T picture,int i){
        this.pictures[i] = picture;
    }

    public void setPictures(T[] pictures) {
        this.pictures = pictures;
    }

    private void checkArray(T[] pictures) throws GraphicException {
        for(T obj : pictures){
            if (obj == null){
                throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
            }
        }
    }

    public boolean isSameSize(ArrayManager<? extends Picture> another){
        return another.pictures.length == pictures.length;
    }

    public boolean allPicturesFullyVisibleOnDesktop(Desktop desktop){
        for(T picture : pictures){
            if(!picture.isFullyVisibleOnDesktop(desktop)) return false;
        }
        return true;
    }

    public boolean anyPictureFullyVisibleOnDesktop(Desktop desktop){
        for(T picture : pictures){
            if(picture.isFullyVisibleOnDesktop(desktop)) return true;
        }
        return false;
    }
    public Picture getFirstPictureFromCursor(Cursor cursor){
        for(T picture : pictures){
            if(picture.isInside(cursor.getX(),cursor.getY())) return picture;
        }
        return null;
    }

}
