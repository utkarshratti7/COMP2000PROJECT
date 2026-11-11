
import java.util.Iterator;
import java.util.List;

/**
 * Collision strategy for black holes.
 * Removes celestial bodies that overlap a black hole.
 */
public class BlackHoleCollisionStrategy
        implements CollisionStrategy {

    @Override
    public void resolveCollisions(List<Body> bodies) {

        Iterator<Body> iterator = bodies.iterator();

        while (iterator.hasNext()) {
            Body body = iterator.next();

            // Black holes must not consume themselves.
            if (body instanceof BlackHole) {
                continue;
            }

            for (Body other : bodies) {

                if (!(other instanceof BlackHole)) {
                    continue;
                }

                double dx = body.l.x - other.l.x;
                double dy = body.l.y - other.l.y;

                double distance = Math.hypot(dx, dy);

                if (distance < body.radius + other.radius) {

                    System.out.println(
                            body.name + " was consumed by "
                                    + other.name
                    );

                    iterator.remove();
                    break;
                }
            }
        }
    }
}
