package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private final HashMap<Furniture, Integer> furnitureItems;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        furnitureItems = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        Integer count = 0;
        if(furnitureItems.containsKey(type)) {
            count = furnitureItems.get(type);
        }
        furnitureItems.put(type, count + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return new HashMap<Furniture, Integer>(furnitureItems);
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        if(!furnitureItems.isEmpty()) {
        	return furnitureItems.entrySet().stream()
        			.map(f -> f.getKey().cost() * f.getValue())
        			.collect(Collectors.toList())
        			.stream()
        			.reduce(Float::sum)
        			.get();
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if(furnitureItems.containsKey(type)) {
        	return furnitureItems.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
        if(furnitureItems.containsKey(type)) {
        	return furnitureItems.get(type) * type.cost();
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        if(!furnitureItems.isEmpty()) {
        	return furnitureItems.values().stream()
        			.reduce(Integer::sum)
        			.get();
        }
        return 0;
    }
}
