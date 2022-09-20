package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.exceptions.v3.GraphicException;
import net.thumbtack.school.pictures.v3.Point;
import net.thumbtack.school.pictures.v3.RectPicture;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.util.ArrayList;

public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        File file = new File(fileName);
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(array);
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException{
        writeByteArrayToBinaryFile(file.toString(), array);
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        byte[] read = new byte[6];
        try(FileInputStream fi = new FileInputStream(fileName)){
            fi.read(read);
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
            bis.skip(1);
            arr[i] = (byte)c;
            i++;
            j++;
        }
        return arr;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream br = new  BufferedOutputStream(new FileOutputStream(fileName))) {
            br.write(array);
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(file.toString(), array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        byte[] array = new byte[6];
        try(BufferedInputStream bs = new BufferedInputStream(new FileInputStream(fileName))){
            bs.read(array);
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
        }
    }

    public static RectPicture readRectPictureFromBinaryFile(File file) throws IOException, GraphicException {
        int height, width, leftX, rightY;
        String format;
        try(DataInputStream fi = new DataInputStream(new FileInputStream(file))){
            height = fi.readInt();
            width = fi.readInt();
            format = fi.readUTF();
            leftX = fi.readInt();
            rightY = fi.readInt();
        }
        return new RectPicture(leftX,rightY,width,height,format);
    }
    public static void writeRectPictureArrayToBinaryFile(File file, RectPicture[] rects) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            for (RectPicture rect : rects) {
                dos.writeInt(rect.getTopLeft().getX());
                dos.writeInt(rect.getTopLeft().getY());
                dos.writeInt(rect.getHeight());
                dos.writeInt(rect.getWidth());
            }
        }
    }

    public static void modifyRectPictureArrayInBinaryFile(File file) throws IOException, GraphicException {
        ArrayList<RectPicture> MrectPicture1 = new ArrayList<>();
        try(RandomAccessFile raf = new RandomAccessFile(file , "rw")){
            RectPicture MrectPicture3;
            int j = 0;
            while(j<5) {
                raf.seek(16 * j);
                MrectPicture3 = new RectPicture(raf.readInt()+1,raf.readInt(),raf.readInt(),raf.readInt(),"GIF");
                MrectPicture1.add(MrectPicture3);
                j++;
            }
        }
        RectPicture[] MrectPicture = new RectPicture[MrectPicture1.size()];
        for (int i =0; i < MrectPicture.length; i++) {
            MrectPicture[i] = MrectPicture1.get(i);
        }
        writeRectPictureArrayToBinaryFile(file ,MrectPicture);
    }

    public static RectPicture[] readRectPictureArrayFromBinaryFile(File file) throws IOException, GraphicException {
        int height, width, leftX, rightY;
        RectPicture[] MrectPicture = new RectPicture[5];
        try(DataInputStream fi = new DataInputStream(new FileInputStream(file))){
            for(int i =0; i< MrectPicture.length; i++) {
            leftX = fi.readInt();
            rightY = fi.readInt();
            width = fi.readInt();
            height = fi.readInt();
            MrectPicture[i] = new RectPicture(leftX,rightY,width,height,"GIF");
            }
        }
        return MrectPicture;
    }


    public static void writeRectPictureToTextFileOneLine(File file, RectPicture rectPicture) throws IOException{
        String c = " ";
        try(FileWriter writer = new FileWriter(file.toString())) {
            writer.write(rectPicture.getFormat().toString() + c);
            writer.write(rectPicture.getHeight() + c);
            writer.write(rectPicture.getWidth() + c);
            writer.write(rectPicture.getTopLeft().getX() + c);
            writer.write(rectPicture.getTopLeft().getY() + c);
        }
    }


    public static RectPicture readRectPictureFromTextFileOneLine(File file) throws IOException, GraphicException {
        RectPicture rectPicture;
        String format;
        String[] strings;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            strings = br.readLine().split(" ");
            format = strings[0];
            rectPicture = new RectPicture(Integer.parseInt(strings[3]),Integer.parseInt(strings[4]),Integer.parseInt(strings[2]),Integer.parseInt(strings[1]),format);
        }
        return rectPicture;
    }

    public static void writeRectPictureToTextFileFiveLines(File file, RectPicture rectPicture) throws IOException{
        try(FileWriter writer = new FileWriter(file.toString())){
            writer.write(rectPicture.getBottomRight().getX() + "\n");
            writer.write(rectPicture.getBottomRight().getY() + "\n");
            writer.write(rectPicture.getTopLeft().getX()+ "\n");
            writer.write(rectPicture.getTopLeft().getY()+ "\n");
            writer.write(rectPicture.getFormat().toString() + "\n");
        }
    }

    public static RectPicture readRectPictureFromTextFileFiveLines(File file) throws IOException, GraphicException {
        RectPicture rectPicture;
        String format;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            Point bottomRight = new Point(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
            Point topLeft = new Point(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
            format = br.readLine();
            rectPicture = new RectPicture(topLeft,bottomRight,format);
        }
        return rectPicture;
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException{
        try(FileWriter writer = new FileWriter(file.toString())){
            writer.write(trainee.getFirstName() + " ");
            writer.write(trainee.getLastName() + " ");
            writer.write(trainee.getRating() + " ");
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws TrainingException, IOException {
        Trainee trainee;
        String[] strings;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            strings = br.readLine().split(" ");
            trainee = new Trainee(strings[0],strings[1], Integer.parseInt(strings[2]));
        }
        return trainee;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try(FileWriter writer = new FileWriter(file.toString())){
            writer.write(trainee.getFirstName() + "\n");
            writer.write(trainee.getLastName() + "\n");
            writer.write(trainee.getRating() + "\n");
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        Trainee trainee;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            trainee = new Trainee(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()));
        }
        return trainee;
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        Trainee p;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            p = (Trainee)ois.readObject();
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
    }
    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        Trainee trainee;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            trainee = gson.fromJson(br, Trainee.class);
        }
        return trainee;
    }
}
