package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.pictures.v3.Point;
import net.thumbtack.school.pictures.v3.RectPicture;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.util.Objects;

public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        File file = new File(fileName);
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(array);
        }catch (IOException ex){
            throw new IOException();
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException{
        writeByteArrayToBinaryFile(file.toString(), array);
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        byte[] read = new byte[6];
        try(FileInputStream fi = new FileInputStream(fileName)){
            fi.read(read);
        }catch (IOException ex){
            throw new IOException();
        }
        return read;
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        return readByteArrayFromBinaryFile(file.toString());
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            bos.write(array);
        }
        catch (IOException ex){
            throw new IOException();
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        byte[] arr = new byte[array.length/2];
        int c , j = 0, i = 0;
        while((c=bis.read())!=-1){
            if (j%2==0){
                arr[i] = (byte)c;
                i++;
            }
            j++;
        }
        return arr;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream br = new  BufferedOutputStream(new FileOutputStream(fileName))) {
            br.write(array);
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(file.toString(), array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        byte[] array = new byte[6];
        try(BufferedInputStream bs = new BufferedInputStream(new FileInputStream(fileName))){
            bs.read(array);
        }catch (IOException ex){
            throw new IOException();
        }
        return array;
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
       return readByteArrayFromBinaryFileBuffered(file.toString());
    }

    public static void  writeRectPictureToBinaryFile(File file, RectPicture rectPicture) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(rectPicture.getHeight());
            dos.writeInt(rectPicture.getWidth());
            dos.writeUTF(rectPicture.getFormat().toString());
            dos.writeInt(rectPicture.getTopLeft().getX());
            dos.writeInt(rectPicture.getTopLeft().getY());
        }catch (IOException ex){
            throw new IOException();
        }
    }

    public static RectPicture readRectPictureFromBinaryFile(File file) throws IOException, GraphicException {
        int height, width, LeftX, RightY;
        String format;
        try(DataInputStream fi = new DataInputStream(new FileInputStream(file))){
            height = fi.readInt();
            width = fi.readInt();
            format = fi.readUTF();
            LeftX = fi.readInt();
            RightY = fi.readInt();
        }catch (IOException ex){
            throw new IOException();
        }
        return new RectPicture(LeftX,RightY,width,height,format);
    }
    public static void writeRectPictureArrayToBinaryFile(File file, RectPicture[] rects) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            for (RectPicture rect : rects) {
                dos.writeInt(rect.getTopLeft().getX());
                dos.writeInt(rect.getTopLeft().getY());
                dos.writeInt(rect.getHeight());
                dos.writeInt(rect.getWidth());
            }
        }catch (IOException ex){
            throw new IOException();
        }
    }

    public static void modifyRectPictureArrayInBinaryFile(File file) throws IOException, GraphicException {
        int[] buba = new int[20];
        try(DataInputStream fi = new DataInputStream(new FileInputStream(file))){
            for(int i =0; i < 20; i++){
                buba[i] = fi.readInt();
            }
            for(int i =0; i < 20; i++){
                if (i%4==0) buba[i] = buba[i]+1;
            }
        }catch (IOException ex){
            throw new IOException();
        }
        RectPicture[] MrectPicture = new RectPicture[5];
        int j =0;
        for(int i =0; i< buba.length; i++) {
            if (i%4==0){  MrectPicture[j] = new RectPicture(buba[i],buba[i+1],buba[i+2],buba[i+3],"GIF"); j++;}
        }
        writeRectPictureArrayToBinaryFile(file ,MrectPicture);
    }

    public static RectPicture[] readRectPictureArrayFromBinaryFile(File file) throws IOException {
        int height, width, LeftX, RightY;
        RectPicture[] MrectPicture = new RectPicture[5];
        try(DataInputStream fi = new DataInputStream(new FileInputStream(file))){
            for(int i =0; i< MrectPicture.length; i++) {
            LeftX = fi.readInt();
            RightY = fi.readInt();
            width = fi.readInt();
            height = fi.readInt();
                MrectPicture[i] = new RectPicture(LeftX,RightY,width,height,"GIF");
            }
        }catch (IOException | GraphicException ex){
            throw new IOException();
        }
        return MrectPicture;
    }

    public static void saveObjectFile(Object obj, File file, String nameOfClass, boolean Lines) throws IOException {
        String c;
        if(Objects.equals(nameOfClass, "RectPicture")){
            RectPicture rectPicture = (RectPicture)obj;
            try(FileWriter writer = new FileWriter(file.toString())){
                if (!Lines) {
                    c = " ";
                    writer.write(rectPicture.getFormat().toString() + c);
                    writer.write(rectPicture.getHeight() + c);
                    writer.write(rectPicture.getWidth() + c);
                    writer.write(rectPicture.getTopLeft().getX() + c);
                    writer.write(rectPicture.getTopLeft().getY() + c);
                }
                if (Lines){
                    c = "\n";
                    writer.write(rectPicture.getBottomRight().getX() + c);
                    writer.write(rectPicture.getBottomRight().getY() + c);
                    writer.write(rectPicture.getTopLeft().getX()+ c);
                    writer.write(rectPicture.getTopLeft().getY()+ c);
                    writer.write(rectPicture.getFormat().toString() + c);
                }
            }catch (IOException ex){
                throw new IOException();
            }
        }
        if (Objects.equals(nameOfClass, "Trainee")){
            Trainee trainee = (Trainee)obj;
            try(FileWriter writer = new FileWriter(file.toString())){
                if (!Lines) {
                    c = " ";
                    writer.write(trainee.getFirstName() + c);
                    writer.write(trainee.getLastName() + c);
                    writer.write(trainee.getRating() + c);
                }
                if (Lines){
                    c = "\n";
                    writer.write(trainee.getFirstName() + c);
                    writer.write(trainee.getLastName() + c);
                    writer.write(trainee.getRating() + c);
                }
            }catch (IOException ex){
                throw new IOException();
            }
        }
    }


    public static void writeRectPictureToTextFileOneLine(File file, RectPicture rectPicture) throws IOException{
        saveObjectFile(rectPicture,file,"RectPicture", false);
    }


    public static RectPicture readRectPictureFromTextFileOneLine(File file) throws IOException, GraphicException {
        RectPicture rectPicture;
        String str = "";
        String format = ""; int height = 0, width = 0, getx = 0, gety = 0;
        try(FileReader reader = new FileReader(file.toString())){
            int c;
            int b = 0;
            while((c=reader.read())!=-1){
                if((char)c !=' ') str+=(char)c;
                if (b == 4 & (c==' ' | c == '\n')) {gety = Integer.parseInt(str); b++;}
                if (b == 3 & (c==' ' | c == '\n')) {getx = Integer.parseInt(str); b++;}
                if (b == 2 & (c==' ' | c == '\n')) {width = Integer.parseInt(str); b++;}
                if (b == 1 & (c==' ' | c == '\n')) {
                    height = Integer.parseInt(str);
                    b++;
                }
                if (b==0 & (c==' ' | c == '\n')) {format = str;b++;}
                if ((c == ' '| c == '\n')) str = "";
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
        rectPicture = new RectPicture(getx, gety, width, height, format);
        return rectPicture;
    }

    public static void writeRectPictureToTextFileFiveLines(File file, RectPicture rectPicture) throws IOException{
       saveObjectFile(rectPicture,file,"RectPicture", true);
    }

    public static RectPicture readRectPictureFromTextFileFiveLines(File file) throws IOException, GraphicException {
        RectPicture rectPicture;
        String str = "";
        String format = ""; int Lgetx = 0, Lgety = 0, Rgetx = 0, Rgety = 0;
        try(FileReader reader = new FileReader(file.toString())){
            int c;
            int b = 0;
            while((c=reader.read())!=-1){
                if((char)c !='\n') str+=(char)c;
                if (b == 4 & c=='\n') { format = str; b++;}
                if (b == 3 & c=='\n') { Lgety = Integer.parseInt(str); b++;}
                if (b == 2 & c=='\n') { Lgetx = Integer.parseInt(str); b++;}
                if (b == 1 & c=='\n') { Rgety = Integer.parseInt(str); b++;}
                if (b == 0 & c=='\n') { Rgetx = Integer.parseInt(str); b++;}
                if (c == '\n') str = "";
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
        Point topLeft = new Point(Lgetx,Lgety);
        Point bottomRight = new Point(Rgetx,Rgety);
        rectPicture = new RectPicture(topLeft, bottomRight, format);
        return rectPicture;
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException{
        saveObjectFile(trainee,file,"Trainee", false);
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws TrainingException, IOException {
        Trainee trainee;
        String str = "";
        String firstName = "", LastName = "";
        int rating = 0;
        try(FileReader reader = new FileReader(file.toString())){
            int c;
            int b = 0;
            while((c=reader.read())!=-1){
                if((char)c !=' ') str+=(char)c;
                if (b == 2 & c==' ') { rating = Integer.parseInt(str); b++;}
                if (b == 1 & c==' ') { LastName = str; b++;}
                if (b == 0 & c==' ') { firstName = str; b++;}
                if (c == ' ') str = "";
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
        trainee = new Trainee(firstName, LastName, rating);
        return trainee;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException{
        saveObjectFile(trainee,file,"Trainee", true);
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        Trainee trainee;
        String str = "";
        String firstName = "", LastName = "";
        int rating = 0;
        try(FileReader reader = new FileReader(file.toString())){
            int c;
            int b = 0;
            while((c=reader.read())!=-1){
                if((char)c !='\n') str+=(char)c;
                if (b == 2 & c=='\n') { rating = Integer.parseInt(str); b++;}
                if (b == 1 & c=='\n') { LastName = str; b++;}
                if (b == 0 & c=='\n') { firstName = str; b++;}
                if (c == '\n') str = "";
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
        trainee = new Trainee(firstName, LastName, rating);
        return trainee;
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
        catch(IOException ex){
            throw new IOException();
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException {
        Trainee p;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            p = (Trainee)ois.readObject();
        }catch (IOException | ClassNotFoundException ex){
            throw new IOException();
        }
        return p;
    }
    public static String serializeTraineeToJsonString(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }
    public static Trainee deserializeTraineeFromJsonString(String json){
        Gson gson = new Gson();
        Trainee trainee;
        trainee = gson.fromJson(json,Trainee.class);
        return trainee;
    }
    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        String gsonText = gson.toJson(trainee);
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(file))){
            bf.write(gsonText);
        }
        catch (IOException ex){
            throw new IOException();
        }
    }
    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        Trainee trainee;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            trainee = gson.fromJson(br, Trainee.class);
        }catch (IOException ex){
            throw new IOException();
        }
        return trainee;
    }
}
