package ru.job4j.departments;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrganizationTest {
    private String[] departments;
    private Organization org;

    @Before
    public void beforeTest() {
        departments = new String[]{"K1\\SK1", "K2", "K1\\SK1\\SSK2", "K1\\SK2", "K2\\SK1\\SSK2",
                "K1", "K1\\SK1\\SSK1", "K2\\SK1", "K2\\SK1\\SSK1"};
    }

    @Test
    public void whenSortDepartmentsByAscending() {

        String[] expectArray = {
                "K1",
                "K1SK1",
                "K1SK1SSK1",
                "K1SK1SSK2",
                "K1SK2",
                "K2",
                "K2SK1",
                "K2SK1SSK1",
                "K2SK1SSK2"};
        org = new Organization(departments, Organization.AscenCodeComparator);
        String[] result = org.sort();
        assertThat(result, is(expectArray));

    }

    @Test
    public void whenSortDepartmentsByDesc() {
        String[] expectArray = {
                "K2",
                "K2SK1",
                "K2SK1SSK2",
                "K2SK1SSK1",
                "K1",
                "K1SK2",
                "K1SK1",
                "K1SK1SSK2",
                "K1SK1SSK1"};
        org = new Organization(departments, Organization.DescCodeComparator);
        String[] result = org.sort();
        assertThat(result, is(expectArray));

    }

}
