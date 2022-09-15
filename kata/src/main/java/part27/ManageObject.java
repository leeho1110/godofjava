package part27;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManageObject {

    public static final String OBJ_PATH = "/Users/leeho/workspace/godofjava-git/kata/src/main/java/part27/serialDto.obj";

    public static void main(String[] args) {
        ManageObject manager = new ManageObject();

        SerialDto serialDto = new SerialDto("bookName", 1, true, 100);
        manager.saveObject(serialDto);
        manager.loadObject(ManageObject.OBJ_PATH);
    }

    private void saveObject(SerialDto serialDto) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(OBJ_PATH);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(serialDto); // return java.io.NotSerializableException if not implement Serializable then
            System.out.println("writeObjec method is Success!!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 반환은 호출의 역순, JDBC Connection 리소스 반환 코드가 떠오르는
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadObject(String path) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);

            // java.io.InvalidClassException: part27.SerialDto;
            // local class incompatible: stream classdesc serialVersionUID = -472947747300743388, local class serialVersionUID = 446293548755684409
            SerialDto serialObj = (SerialDto)ois.readObject();
            System.out.println(serialObj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 반환은 호출의 역순, JDBC Connection 리소스 반환 코드가 떠오르는
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
