package com.kodokoto.gotchimon;

public final class App {

    public static int resolution = 640;
    public static void main(String[] args) {
        Main game = new Main("gotchimon", resolution, resolution);
        game.start();
    }
}
