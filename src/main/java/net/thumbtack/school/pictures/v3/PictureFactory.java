package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;

public class PictureFactory {
    static int countRectPicture;
    static int countRoundPicture;
    public static RectPicture createRectPicture(Point leftTop, Point rightBottom, PictureFormat format) throws GraphicException{
        RectPicture rectPicture = new RectPicture(leftTop, rightBottom, format);
        countRectPicture++;
        return rectPicture;
    }
    public static RoundPicture createRoundPicture(Point center, int radius, PictureFormat format) throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(center,radius,format);
        countRoundPicture++;
        return roundPicture;
    }

    public static int getRectPictureCount(){
        return countRectPicture;
    }

    public static int getRoundPictureCount(){
        return countRoundPicture;
    }

    public static int getPictureCount(){
        return countRectPicture+countRoundPicture;
    }
    public static void reset(){
        countRectPicture = 0;
        countRoundPicture = 0;
    }
}
