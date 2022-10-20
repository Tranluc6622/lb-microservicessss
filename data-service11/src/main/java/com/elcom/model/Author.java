    package com.elcom.model;

    import javax.persistence.*;
    import java.io.Serializable;

    @Entity
    @Table(name = "author")
    public class Author implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @Column(name = "id", nullable = false)
        private String id;

        @Column(name = "author_name", length = 255, nullable = false,unique = true)
        private String authorName;

        public Author() {
        }

        public Author(String id, String authorName) {
            this.id = id;
            this.authorName = authorName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }
    }
