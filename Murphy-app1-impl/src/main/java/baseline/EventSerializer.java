package baseline;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

    public final class EventSerializer {

        private static final String DATA_PATH = "data.bin";

        public static void serialize(Object[] events) throws IOException
        {
            try(var serializer = new ObjectOutputStream(new FileOutputStream(DATA_PATH)))
            {
                serializer.writeObject(events);
            }
        }

        public static EventList[] deserialize() throws IOException, ClassNotFoundException
        {
            try(var deserializer = new ObjectInputStream(new FileInputStream(DATA_PATH)))
            {
                Object[] event = (Object[]) deserializer.readObject();
                EventList[] arr = new EventList[event.length];
                for(int i = 0; i < event.length; i++)
                {
                    arr[i] = (EventList) event[i];
                }

                return arr;
            }
        }

        private EventSerializer() {}
    }
