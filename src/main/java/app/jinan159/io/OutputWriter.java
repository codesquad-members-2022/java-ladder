package app.jinan159.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputWriter implements Closeable {

    private final OutputStreamWriter writer;

    public OutputWriter() {
        this.writer = new OutputStreamWriter(System.out);
    }

    public OutputWriter(OutputStream outputStream) {
        this.writer = new OutputStreamWriter(outputStream);
    }

    public void write(String s) throws IOException {
        writer.write(s);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
