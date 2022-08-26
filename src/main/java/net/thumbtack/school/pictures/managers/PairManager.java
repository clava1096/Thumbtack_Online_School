package net.thumbtack.school.pictures.managers;


import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.pictures.v3.Picture;
import net.thumbtack.school.winobjects.v3.Desktop;

class PairManager<T extends Picture,S extends Picture>{
    private T FirstPicture;
    private S SecondPicture;
    public PairManager(T FirstPicture, S SecondPicture) throws GraphicException {
        checkPictures(FirstPicture,SecondPicture);
        this.FirstPicture = FirstPicture;
        this.SecondPicture = SecondPicture;
    }

    public void setFirstPicture(T firstPicture) throws GraphicException{
        checkPicture(firstPicture);
        FirstPicture = firstPicture;
    }

    public T getFirstPicture() {
        return FirstPicture;
    }

    public void setSecondPicture(S secondPicture) throws GraphicException {
        checkPicture(secondPicture);
        SecondPicture = secondPicture;
    }

    public S getSecondPicture() {
        return SecondPicture;
    }

    private void checkPictures(T FirstPicture, S SecondPicture) throws GraphicException{
        if (FirstPicture == null | SecondPicture == null){
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
    }

    private void checkPicture(Object Picture) throws GraphicException{
        if (Picture == null){
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
    }

    public boolean allPicturesFullyVisibleOnDesktop(PairManager pairManager, Desktop desktop){
        return (SecondPicture.isFullyVisibleOnDesktop(desktop) & FirstPicture.isFullyVisibleOnDesktop(desktop) &
                pairManager.FirstPicture.isFullyVisibleOnDesktop(desktop) & pairManager.SecondPicture.isFullyVisibleOnDesktop(desktop));
    }

    public static boolean allPicturesFullyVisibleOnDesktop(PairManager pairManager1, PairManager pairManager2, Desktop desktop){
        return (pairManager1.SecondPicture.isFullyVisibleOnDesktop(desktop) & pairManager1.FirstPicture.isFullyVisibleOnDesktop(desktop) &
                pairManager2.FirstPicture.isFullyVisibleOnDesktop(desktop) & pairManager2.SecondPicture.isFullyVisibleOnDesktop(desktop));
    }

}
