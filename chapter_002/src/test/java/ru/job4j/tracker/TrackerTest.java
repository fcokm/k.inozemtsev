package ru.job4j.tracker;

import org.junit.Test;

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
        assertThat(tracker.getAll()[0], is(item));
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
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 124L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 125L);
        tracker.add(third);
        tracker.delete(first.getId());
        Item[] except = {second, third};
        Item[] result = tracker.getAll();
        assertThat(result, arrayContainingInAnyOrder(except));

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
        Item[] result = tracker.findByName(first.getName());
        Item[] except = {first, four};
        assertThat(result, arrayContainingInAnyOrder(except));

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
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 124L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 125L);
        tracker.add(third);
        Item four = new Item("test4", "testDescription4", 126L);
        tracker.add(four);
        Item[] result = tracker.getAll();
        Item[] except = {first, second, third, four};
        assertThat(result, arrayContainingInAnyOrder(except));

    }


}
