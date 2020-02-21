package com.felix.common.object;

import java.io.*;

public class Objects {

    public static boolean hasNull(Object... objects) {
        if (objects == null || objects.length == 0)
            return true;

        for (Object object : objects) {
            if (object == null)
                return true;
        }

        return false;
    }

    public static <T extends Serializable> T clone(T obj) {
        return deserialize(serialize(obj));
    }

    public static <T extends Serializable> byte[] serialize(T obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Serializable> T deserialize(byte[] bytes) {
        try (ByteArrayInputStream bos = new ByteArrayInputStream(bytes); ObjectInputStream in = new ObjectInputStream(bos)) {
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
