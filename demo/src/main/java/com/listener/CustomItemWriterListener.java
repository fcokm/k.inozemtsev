package com.listener;


import com.model.Entry;
import org.springframework.batch.core.ItemWriteListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class CustomItemWriterListener implements ItemWriteListener<Entry> {


    @Override
    public void beforeWrite(List<? extends Entry> list) {

    }

    @Override
    public void afterWrite(List<? extends Entry> list) {
        try {
            Files.move(Paths.get("src/main/com/resources/file1.csv"),Paths.get("src/main/com/resources/processing/file1.csv"),StandardCopyOption.REPLACE_EXISTING );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onWriteError(Exception e, List<? extends Entry> list) {

    }
}