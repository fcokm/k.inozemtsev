package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test"));
    }

    @Test
    public void whenUserAddThreeItemsThenReplaceThirdItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "desc1", 123L);
        tracker.add(first);
        Input input = new StubInput(new String[]{"0", "test2", "desc2", "0", "test3", "desc3",
                "0", "test4", "desc4", "6"});
        new StartUI(input, tracker).init();
        tracker.replace(tracker.getAll()[2].getId(), first);
        assertThat(tracker.getAll()[2].getDesc(), is("desc1"));
    }

    @Test
    public void whenUserAddThreeItemsThenTDeleteFirstItemAndReturnArraysItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desc1", "0", "test2", "desc2",
                "0", "test3", "desc3", "6"});
        new StartUI(input, tracker).init();
        Item[] except = {tracker.getAll()[0], tracker.getAll()[2]};
        tracker.delete(tracker.getAll()[1].getId());
        Item[] result = tracker.getAll();
        assertThat(result, arrayContainingInAnyOrder(except));
    }

}
