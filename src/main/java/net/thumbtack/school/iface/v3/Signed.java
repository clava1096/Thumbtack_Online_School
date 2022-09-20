package net.thumbtack.school.iface.v3;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;

public interface Signed {
    String getSignature();
    void setSignature(String signature) throws GraphicException;
    default void checkSignature(String signature) throws GraphicException{
        if(signature == null){
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
    }

}
