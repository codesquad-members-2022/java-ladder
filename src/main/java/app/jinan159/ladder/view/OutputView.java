package app.jinan159.ladder.view;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputView implements Closeable {

    private final OutputStreamWriter writer;

    public OutputView() {
        this.writer = new OutputStreamWriter(System.out);
    }

    public OutputView(OutputStream outputStream) {
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
