
import java.util.List;

/**
 * Defines a common interface for collision handling.
 *
 * Different strategies can implement different collision
 * behaviours without changing the simulation's main loop.
 */
public interface CollisionStrategy {

    void resolveCollisions(List<Body> bodies);

}
