package net.thumbtack.school.exceptions.v3;

public enum GraphicErrorCode {
    WRONG_PICTURE_FORMAT("WRONG_PICTURE_FORMAT"),
    NULL_PICTURE_FORMAT("NULL_PICTURE_FORMAT"),
    NULL_SIGNATURE("NULL_SIGNATURE");
    private String errorString;

    GraphicErrorCode(String errorString){
        this.errorString = errorString;
    }

    public String getErrorString(){
        return errorString;
    }

}
