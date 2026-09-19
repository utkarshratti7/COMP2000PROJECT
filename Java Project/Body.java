import java.awt.Color;

public class Body {
       String  name;
       double mass;
       Location l;
       double radius ;
       Velocity v;

       Body(String name , double mass, Location l, double radius ,Velocity v){
        if (name == null || name.trim().isEmpty()){
            throw new InvalidBodyException("A body needs a name");
        }
        if (mass <= 0){
            throw new InvalidBodyException(name + " needs a positive mass, got " + mass);
        }
        if (radius <= 0){
            throw new InvalidBodyException(name + " needs a positive radius, got " + radius);
        }
        this.name=name;
        this.mass=mass;
        this.l=l;
        this.radius=radius;
        this.v=v;

    }

    Color colour(){
        return Color.LIGHT_GRAY;
    }

    @Override
    public String toString() {
        return String.format("%s [Mass: %.2f, Radius: %.1f]", name, mass, radius);
    }
}