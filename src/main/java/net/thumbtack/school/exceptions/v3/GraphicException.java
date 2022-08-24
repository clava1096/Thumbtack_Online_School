package net.thumbtack.school.exceptions.v3;

public class GraphicException extends Exception {
    private GraphicErrorCode graphicErrorCode;

    public GraphicException(){
        super();
    }

    public GraphicException(GraphicErrorCode graphicErrorCode){
        super(graphicErrorCode.getErrorString());
        this.graphicErrorCode = graphicErrorCode;
    }
    public GraphicErrorCode getGraphicErrorCode(){
        return graphicErrorCode;
    }
}
