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
    float power =4;
    float steps =10000000;
    int count = 0;
    //float steps = pow(10,power);


    public void setup() {
        background(0);
        processing = this;
        double bigBoxMass = pow(100,power);

        bigBox = new Box(width/2,height-bigBoxSize,bigBoxSize,-2,(float) bigBoxMass);
        smallBox = new Box(width/4,height-smallBoxSize,smallBoxSize,0,1);
    }
    public void draw () {
        background(255);
        MainClass.processing.textSize(12);
        MainClass.processing.text(count, 10, 20);
        if ((bigBox.vel >0 & smallBox.vel >0 & bigBox.vel > smallBox.vel) ) {
            MainClass.processing.text("Done", 10, 55);
            noLoop();
        }
        if (smallBox.vel > 0 ) {
            MainClass.processing.text("right", 10, 35);
        } else if (smallBox.vel < 0 ) {
            MainClass.processing.text("left", 10, 35);
        }

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
            double inf = Double.POSITIVE_INFINITY;
            //println((double)inf);

            bigBox.update();
            smallBox.update();
//            if (bigBox.x < smallBoxSize-5) {
//                bigBox.x = smallBoxSize;
//            }
//            if (smallBox.x > bigBox.x-smallBoxSize+5) {
//                smallBox.x = bigBox.x-smallBoxSize;
//            }
            if (bigBox.x < smallBoxSize) {
                bigBox.x = smallBoxSize+2;

            }
         //  bigBox.x = MainClass.processing.constrain((float) bigBox.x,smallBoxSize+2, 1000000000);
           smallBox.x = MainClass.processing.constrain((float) smallBox.x,0,((float)bigBox.x-smallBoxSize+1));
//            println("small box " + smallBox.x + "      big   box " + bigBox.x) ;

        }

            bigBox.show();
            smallBox.show();
            //println(smallBox.x);

    }
}