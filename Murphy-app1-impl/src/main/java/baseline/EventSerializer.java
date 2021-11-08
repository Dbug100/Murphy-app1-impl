package baseline;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

    public final class EventSerializer {

        private static final String DATA_PATH = "data.bin";

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
