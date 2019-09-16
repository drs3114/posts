/*
 * Copyright (c) 2019. Deepak Ravi Shankar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.deepakshankar.posts.model;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AppCategoryTest {

    @Test
    public void testAppCategoryValues() {

        // Test for Entertainment Category
        assertCategory(AppCategory.ENTERTAINMENT, "ENTERTAINMENT", 0, "Entertainment Category");

        // Test for Personal Blog Category
        assertCategory(AppCategory.PERSONAL_BLOG, "PERSONAL_BLOG", 1, "Personal Blog Category");

        // Test for Adult Category
        assertAgeRestrictedCategory(AppCategory.ADULT, "ADULT", 2, "Adult Category");
    }

    private void assertCategory(AppCategory category, String name, int id, String description) {
        assertEnum(category, name, id, description, 0, false);

        category.setAgeRestricted(true);
        assertTrue(category.isAgeRestricted());

        category.setMinAge(18);
        assertThat(category.getMinAge(), is(18));

        category.setId(99);
        assertThat(category.getId(), is(99));

        category.setDescription("BLAH");
        assertThat(category.getDescription(), is("BLAH"));

        category.setName("BLAH");
        assertThat(category.getName(), is("BLAH"));
    }

    private void assertAgeRestrictedCategory(AppCategory category, String name, int id, String description) {
        assertEnum(category, name, id, description, 18, true);
    }

    private void assertEnum(AppCategory category, String name, int id, String description, int age, boolean restriction) {
        assertThat(AppCategory.valueOf(category.getName()), is(category));
        assertThat(category.getName(), is(name));
        assertThat(category.getId(), is(id));
        assertThat(category.getDescription(), is(description));
        assertThat(category.getMinAge(), is(age));
        assertThat(category.isAgeRestricted(), is(restriction));
    }

}