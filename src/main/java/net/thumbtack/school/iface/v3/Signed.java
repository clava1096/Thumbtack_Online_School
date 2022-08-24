package net.thumbtack.school.iface.v3;

import net.thumbtack.school.exceptions.v3.GraphicException;

public interface Signed {
    String getSignature();
    void setSignature(String signature) throws GraphicException;
}
