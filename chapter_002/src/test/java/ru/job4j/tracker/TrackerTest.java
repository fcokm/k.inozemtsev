package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


public class TrackerTest {


    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }


    @Test
    public void whenDeleteFirstItemThenReturnArraysItem() {
        Tracker tracker = new Tracker();
        List<Item> exceptItems = new ArrayList<>();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 124L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 125L);
        tracker.add(third);
        tracker.delete(first.getId());
        exceptItems.add(second);
        exceptItems.add(third);
        List<Item> result = tracker.getAll();
        assertThat(result, contains(second, third));
        //assertThat(result, arrayContainingInAnyOrder(exceptItems));

    }


    @Test
    public void whenFindByNameFirstItemThenReturnArraysItemWithElementsFirstAndFour() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 124L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 125L);
        tracker.add(third);
        Item four = new Item("test1", "testDescription4", 126L);
        tracker.add(four);
        List<Item> result = tracker.findByName("test1");
        //Item[] except = {first, four};
        List<Item> except = new ArrayList<>(Arrays.asList(first, four));
        assertThat(result, is(except));
        // assertThat(result, arrayContainingInAnyOrder(except));

    }


    @Test
    public void whenFindByIdFourItemThenReturnItemWithId() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 124L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 125L);
        tracker.add(third);
        Item four = new Item("test4", "testDescription4", 126L);
        tracker.add(four);
        Item result = tracker.findById(second.getId());
        Item except = second;
        assertThat(result, is(except));

    }

    @Test
    public void whenGetAllItemsNotNullElementsThenHasSameArraysItem() {
        Tracker tracker = new Tracker();
        List<Item> result = new ArrayList<>();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 124L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 125L);
        tracker.add(third);
        Item four = new Item("test4", "testDescription4", 126L);
        tracker.add(four);
        result = tracker.getAll();
        List<Item> except = new ArrayList<>(Arrays.asList(first, second, third, four));
        assertThat(result, is(except));
        //  assertThat(result, arrayContainingInAnyOrder(except));

    }


}
