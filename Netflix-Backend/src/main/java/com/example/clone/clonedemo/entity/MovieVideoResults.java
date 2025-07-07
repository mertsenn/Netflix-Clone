package com.example.clone.clonedemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieVideoResults {
     @JsonProperty("iso_639_1")
     private String iso6391;
        @JsonProperty("iso_3166_1")     
     private String iso31661;
     @JsonProperty("name")
     private String name;
        @JsonProperty("key")
     private String key;
        @JsonProperty("site")
     private String site;
        @JsonProperty("size")
     private int size;
        public String getIso6391() {
            return iso6391;
        }
        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }
        public String getIso31661() {
            return iso31661;
        }
        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getKey() {
            return key;
        }
        public void setKey(String key) {
            this.key = key;
        }
        public String getSite() {
            return site;
        }
        public void setSite(String site) {
            this.site = site;
        }
        public int getSize() {
            return size;
        }
        public void setSize(int size) {
            this.size = size;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public boolean isOfficial() {
            return official;
        }
        public void setOfficial(boolean official) {
            this.official = official;
        }
        public String getPublishedAt() {
            return publishedAt;
        }
        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        @JsonProperty("type")
     private String type;
        @JsonProperty("official")
     private boolean official;
        @JsonProperty("published_at")
     private String publishedAt;
     private String id;
}
