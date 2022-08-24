package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;

public enum PictureFormat {
    TIFF,
    GIF,
    PNG,
    JPG;


    public static PictureFormat fromString(String formatString) throws GraphicException {
        checkNull(formatString);
        if (formatString.equals(TIFF.toString())) return TIFF;
        if (formatString.equals(GIF.toString())) return GIF;
        if (formatString.equals(PNG.toString())) return PNG;
        if ((formatString.equals(JPG.toString()))) return JPG;
        else throw new GraphicException(GraphicErrorCode.WRONG_PICTURE_FORMAT);
    }
    private static void checkNull(String string) throws GraphicException{
        if (string == null) throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
    }
}
