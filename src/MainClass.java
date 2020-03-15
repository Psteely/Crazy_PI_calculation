import processing.core.PApplet;

//import java.util.ArrayList;

public class MainClass extends PApplet {
    public static PApplet processing;

    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    public void settings() {
        size(400, 200);
    }

    Box bigBox;
    Box smallBox;
    float smallBoxSize = 20;
    float bigBoxSize = 50;
    boolean hit = false;
    float power = 2;
    int count = 0;
    int steps = 1;

    public void setup() {
        background(0);
        processing = this;
        float bigBoxMass = pow(100,power);

        bigBox = new Box(width/2,height-bigBoxSize,bigBoxSize,-1,bigBoxMass);
        smallBox = new Box(width/4,height-smallBoxSize,smallBoxSize,0,1);
    }
    public void draw () {
        background(255);
        MainClass.processing.textSize(12);
        MainClass.processing.text(count, 10, 20);

        for (int i = 0; i < steps; i++) {


            hit = bigBox.collide(smallBox);


            if (hit) {
//            bigBox.vel *= -1;
//            smallBox.vel = 1;
//            smallBox.vel *= -1;
                count++;
//                println("hit");
                Box tmp = new Box(smallBox);
                smallBox.vel = smallBox.elasticCollision(bigBox);

                bigBox.vel = bigBox.elasticCollision(tmp);

                hit = false;
            }
            if (smallBox.hitWall()) {
                count++;
            }
            bigBox.x = MainClass.processing.constrain(bigBox.x,smallBoxSize,width);
            bigBox.update();
            smallBox.update();
        }

            bigBox.show();
            smallBox.show();

    }
}