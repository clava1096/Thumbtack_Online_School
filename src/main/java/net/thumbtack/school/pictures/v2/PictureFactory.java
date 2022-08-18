package net.thumbtack.school.pictures.v2;

public class PictureFactory {
    static int countRectPicture;
    static int countRoundPicture;
    public static RectPicture createRectPicture(Point leftTop, Point rightBottom, int format){
        RectPicture rectPicture = new RectPicture(leftTop, rightBottom, format);
        countRectPicture++;
        return rectPicture;
    }
    public static RoundPicture createRoundPicture(Point center, int radius, int format){
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
