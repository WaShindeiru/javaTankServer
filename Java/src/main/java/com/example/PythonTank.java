package com.example;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class PythonTank {

    private final Process process;

    private final BufferedWriter writer;
    private final BufferedReader reader;

    public PythonTank() throws IOException {
        process = new ProcessBuilder("python", "../python/main.py").start();

        writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    }

    public void forward() throws IOException {
        writer.write("1\n");
        writer.flush();
    }

    public void backwards() throws IOException {
        writer.write("2\n");
        writer.flush();
    }

    public void right() throws IOException {
        writer.write("3\n");
        writer.flush();
    }

    public void left() throws IOException {
        writer.write("4\n");
        writer.flush();
    }

    public void stop() throws IOException {
        writer.write("5\n");
        writer.flush();
    }

    public void quit() throws IOException {
        writer.write("0\n");
        writer.flush();
    }

    public void closeConnection() throws IOException {
        stop();
        quit();
        reader.close();
        writer.close();
    }
}
