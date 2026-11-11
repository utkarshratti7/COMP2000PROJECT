
import java.util.ArrayList;
import java.util.List;

public class BlackHoleCollisionStrategyTest {

    public static void main(String[] args) {

        List<Body> bodies = new ArrayList<>();

        BlackHole blackHole = new BlackHole(
                "Test Black Hole",
                10000,
                new Location(0, 0),
                10,
                new Velocity(0, 0)
        );

        Planet nearbyPlanet = new Planet(
                "Nearby Planet",
                10,
                new Location(5, 0),
                2,
                new Velocity(0, 0)
        );

        Planet distantPlanet = new Planet(
                "Distant Planet",
                10,
                new Location(100, 100),
                2,
                new Velocity(0, 0)
        );

        bodies.add(blackHole);
        bodies.add(nearbyPlanet);
        bodies.add(distantPlanet);

        CollisionStrategy strategy =
                new BlackHoleCollisionStrategy();

        strategy.resolveCollisions(bodies);

        boolean blackHoleSurvived = bodies.contains(blackHole);
        boolean nearbyPlanetRemoved = !bodies.contains(nearbyPlanet);
        boolean distantPlanetSurvived = bodies.contains(distantPlanet);

        if (!blackHoleSurvived
                || !nearbyPlanetRemoved
                || !distantPlanetSurvived) {
            throw new AssertionError(
                    "Black hole collision strategy test failed."
            );
        }

        System.out.println(
                "PASS: Black hole collision strategy works correctly."
        );
    }
}
