import java.util.ArrayList;
import java.util.List;

/*
* Goal: Maximize number of items
* Constraints: Do not exceed the weight limit
* Time complexity: O(2^n)
* */
class Item {
  Integer weight;

  Item(Integer weight) {
    this.weight = weight;
  }

  public Integer getWeight() {
    return weight;
  }
}

public class ItemCombiner {
  List<Item> items;

  public ItemCombiner(List<Item> items) {
    this.items = items;
  }

  public List<Item> bestCombination(Integer weightLimit) {
    List<Item> bestCombo = new ArrayList<>();
    backtrack(0, new ArrayList<>(), 0, weightLimit, bestCombo);
    return bestCombo;
  }

  private void backtrack(int index, List<Item> currentCombo, int currentWeight, Integer weightLimit, List<Item> bestCombo) {
    if (currentWeight <= weightLimit && currentCombo.size() > bestCombo.size()) {
      bestCombo.clear();
      bestCombo.addAll(currentCombo);
    }

    for (int i = index; i < items.size(); i++) {
      Item item = items.get(i);
      if (currentWeight + item.getWeight() <= weightLimit) {
        currentCombo.add(item); // Choose the item
        backtrack(i + 1, currentCombo, currentWeight + item.getWeight(), weightLimit, bestCombo); // Move to the next item
        currentCombo.removeLast(); // Backtrack - remove the item
      }
    }
  }

  public static void main(String[] args) {
    List<Item> items = new ArrayList<>();
    items.add(new Item(1));
    items.add(new Item(1));
    items.add(new Item(2));
    items.add(new Item(3));
    items.add(new Item(4));
    items.add(new Item(5));
    items.add(new Item(9));
    items.add(new Item(7));

    ItemCombiner combiner = new ItemCombiner(items);
    Integer weightLimit = 15;
    List<Item> result = combiner.bestCombination(weightLimit);

    for (Item item : result) {
      System.out.println("Item weight: " + item.getWeight());
    }
  }
}