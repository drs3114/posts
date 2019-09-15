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

package com.deepakshankar.posts.controller;

import com.deepakshankar.posts.model.Author;
import com.deepakshankar.posts.model.Genre;
import com.deepakshankar.posts.model.Paragraph;
import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.model.PostType;
import com.deepakshankar.posts.model.Reaction;
import com.deepakshankar.posts.service.AuthorService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorControllerTest {

    public static final String USER_EMAIL = "user@blah.com";
    public static final String USER_FIRST_NAME = "santa";
    public static final String USER_LAST_NAME = "clause";
    public static final String USER_PEN_NAME = "hohoho";
    public static final String USER_WEBSITE = "http://blah.com";
    public static final String POST_TITLE = "blah post";
    public static final String PARAGRAPH_CONTENT = "blah";
    AuthorController controller;

    @Mock
    AuthorService service;
    Author author;
    private static String GENRE_NAME = "BLAH";
    private static String GENRE_NOTES = "blah notes";

    @Before
    public void setUp() throws Exception {
        controller = new AuthorController(service);
        author = setUpAuthor();
        when(service.findAll()).thenReturn(Collections.singletonList(author));
    }

    private Author setUpAuthor() {
        author = new Author();
        author.setId(1L);
        author.setEmail(USER_EMAIL);
        author.setFirstName(USER_FIRST_NAME);
        author.setLastName(USER_LAST_NAME);
        author.setPenName(USER_PEN_NAME);
        author.setWebsites(Collections.singleton(USER_WEBSITE));
        author.setPosts(Collections.singleton(getPosts()));
        return author;
    }

    private Post getPosts() {
        Post post = new Post();
        post.setId(1L);
        post.setGenre(new Genre(GENRE_NAME));
        post.setNotes(GENRE_NOTES);
        post.setParagraphs(Collections.singleton(getOneParagraph()));
        post.setTitle(POST_TITLE);
        post.setType(PostType.BLOG);
        post.setReaction(getOneReaction());
        return post;
    }

    private Paragraph getOneParagraph() {
        Paragraph paragraph = new Paragraph();
        paragraph.setContent(PARAGRAPH_CONTENT);
        paragraph.setId(1L);
        paragraph.setOrder(0);
        return paragraph;
    }

    private Reaction getOneReaction() {
        return new Reaction(1L, 1L, 0L, 0L, 0L, 0L);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {
        List<Author> authors = controller.findAll();
        assertNotNull(authors);
        authors.forEach(a -> {

            // Assert not nulls
            assertNotNull(a);
            assertNotNull(a.getId());
            assertNotNull(a.getFirstName());
            assertNotNull(a.getLastName());
            assertNotNull(a.getPenName());
            assertNotNull(a.getEmail());
            assertNotNull(a.getWebsites());
            assertNotNull(a.getPosts());

            // Assert values

            assertThat(a.getId(), is(1L));
            assertThat(a.getFirstName(), is(USER_FIRST_NAME));
            assertThat(a.getLastName(), is(USER_LAST_NAME));
            assertThat(a.getEmail(), is(USER_EMAIL));
            assertThat(a.getPenName(), is(USER_PEN_NAME));
            assertThat(a.getWebsites(), is(Collections.singleton(USER_WEBSITE)));
            assertPosts(a.getPosts());

        });
    }

    private void assertPosts(Set<Post> posts) {
        posts.forEach(post -> {
            // Asserts for not null
            assertNotNull(post);
            assertNotNull(post.getId());
            assertNotNull(post.getTitle());
            assertNotNull(post.getGenre());
            assertNotNull(post.getType());
            assertNotNull(post.getNotes());
            assertNotNull(post.getParagraphs());
            assertNotNull(post.getReaction());

            // Asserts for values
            assertThat(post.getId(), is(1L));
            assertThat(post.getTitle(), is(POST_TITLE));
            assertThat(post.getGenre().getName(), is(GENRE_NAME));
            assertReaction(post.getReaction());
            assertParagraphs(post.getParagraphs());

        });
    }

    private void assertReaction(Reaction reaction) {
        // Assert Not nulls
        assertNotNull(reaction);
        assertNotNull(reaction.getId());
        assertNotNull(reaction.getAngry());
        assertNotNull(reaction.getDislike());
        assertNotNull(reaction.getHappy());
        assertNotNull(reaction.getLike());
        assertNotNull(reaction.getSad());

        // Assert Values

        assertThat(reaction.getId(), is(1L));
        assertThat(reaction.getLike(), is(1L));
        assertThat(reaction.getAngry(), is(0L));
        assertThat(reaction.getDislike(), is(0L));
        assertThat(reaction.getHappy(), is(0L));
        assertThat(reaction.getSad(), is(0L));
    }

    private void assertParagraphs(Set<Paragraph> paragraphs) {
        paragraphs.forEach(paragraph -> {

            // Asserts not nulls
            assertNotNull(paragraph);
            assertNotNull(paragraph.getId());
            assertNotNull(paragraph.getContent());
            assertNotNull(paragraph.getOrder());

            // Assert Values
            assertThat(paragraph.getId(), is(1L));
            assertThat(paragraph.getContent(), is(PARAGRAPH_CONTENT));
            assertThat(paragraph.getOrder(), is(0));

        });
    }

    @Test
    public void findOne() {
    }

    @Test
    public void createNewPost() {
    }

    @Test
    public void saveOne() {
    }
}