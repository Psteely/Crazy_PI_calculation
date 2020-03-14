import processing.core.PApplet;

//import java.util.ArrayList;

public class MainClass extends PApplet {
    public static PApplet processing;

    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    public void settings() {
        size(800, 800);
    }


    public void setup() {
        processing = this;


    }

}