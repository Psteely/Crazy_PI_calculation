import org.jetbrains.annotations.NotNull;

public class Box {
    double x, y, vel;
    float width,  mass;

    Box (double x, double y, float w, double vel, float mass) {
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
        MainClass.processing.rect((float)x,(float) y,width,width);
    }

    void update() {
        x = x + vel;

    }

    boolean collide(Box sb) {
        if (x < sb.x + sb.width || x+width<sb.x) {
           return true;
        } else {
            return false;
        }
    }

    double elasticCollision(@NotNull Box other) {

        double den = mass + other.mass;
        double first = ((mass - other.mass) / den) * vel;
        double second = ((2 * other.mass)/den) * other.vel;
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
