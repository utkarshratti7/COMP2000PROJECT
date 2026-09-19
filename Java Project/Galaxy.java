import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; // ADDED THIS IMPORT

//A typed group of bodies. Sorts by descending radius to prevent larger
//bodies from covering smaller ones (earlier items are drawn first)
//Prevents adding non-body objects to the list
public class Galaxy<T extends Body> {
    private final List<T> items = new ArrayList<>();

    void add(T body) throws DuplicateBodyException {
        for (T item : items){
            if (item.name.equals(body.name)){
                throw new DuplicateBodyException(body.name);
            }
        }
        items.add(body);
    }

    //Returns a sorted list of bodies in descending radius
    List<T> byDescendingRadius(){
        List<T> sorted = new ArrayList<>(items);
        sorted.sort((a, b) -> Double.compare(b.radius, a.radius));
        return sorted;
    }

    // ADDED THIS NEW METHOD: Uses Java Streams to filter bodies by their specific class type
    public List<T> filterByType(Class<? extends Body> type) {
        return items.stream()
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }
}