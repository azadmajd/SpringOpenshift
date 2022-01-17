package com.example.springopenshift;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Configuration
@EnableScheduling
public class WriteOnDisk {

    UUID uuid = UUID.randomUUID();

    @Value("${datasource1.addr}")
    String prefixPath1;

    @Value("${datasource2.addr}")
    String prefixPath2;



    @Scheduled(fixedDelay = 500)
    public void whenWriteStringUsingBufferedWritter_thenCorrect()
            throws IOException {
        String str = "Hello, time is"+new Date()+uuid.toString();
        String fileName1=prefixPath1+"/store1.db";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1));
        writer.write(str);
        writer.close();
    }

    @Scheduled(fixedDelay = 500)
    public void whenWriteStringUsingBufferedWritter_thenCorrect2()
            throws IOException {
        String str = "Hello, time is"+new Date()+uuid.toString();
        String fileName2=prefixPath2+"/store2.db";
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(fileName2));

        writer2.write(str);

        writer2.close();
    }
}
