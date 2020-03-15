import org.jetbrains.annotations.NotNull;

public class Box {
    float x, y, width, vel, mass;

    Box (float x, float y, float w, float vel, float mass) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.vel = vel;
        this.mass = mass;
    }

    Box (Box cpy) {
        this.x = cpy.x;
        this.y = cpy.y;
        this.width = cpy.width;
        this.vel = cpy.vel;
        this.mass = cpy.mass;
    }
    void show() {
        MainClass.processing.fill(255,0,255);
        MainClass.processing.rect(x,y,width,width);
    }

    void update() {
        x = x + vel;

    }

    boolean collide(Box sb) {
        if (x < sb.x + sb.width) {
           return true;
        } else {
            return false;
        }
    }

    float elasticCollision(@NotNull Box other) {

        float den = mass + other.mass;
        float first = ((mass - other.mass) / den) * vel;
        float second = ((2 * other.mass)/den) * other.vel;
        return (first + second) ;
    }



    boolean hitWall() {

        if (x <= 0) {
            x = 1;
            vel *= -1;
            return true;
        } else return false;
    }
}
