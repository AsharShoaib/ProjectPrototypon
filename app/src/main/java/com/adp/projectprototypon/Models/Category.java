package com.adp.projectprototypon.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asharshoaib on 2016-09-19.
 */
public class Category {

    @SerializedName("meta")
    @Expose
    private Meta meta;

    @SerializedName("data")
    @Expose
    private List<Data> data = new ArrayList<>();

    /**
     * @return The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * @param meta The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * @return The data
     */
    public List<Data> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data {
        @SerializedName("_id")
        @Expose
        private String id;

        @SerializedName("created_at")
        @Expose
        private String createdAt;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("__v")
        @Expose
        private Integer v;

        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        @SerializedName("image")
        @Expose
        private String image;

        @SerializedName("search_terms")
        @Expose
        private List<Object> searchTerms = new ArrayList<Object>();


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<Object> getSearchTerms() {
            return searchTerms;
        }

        public void setSearchTerms(List<Object> searchTerms) {
            this.searchTerms = searchTerms;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id='" + id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", name='" + name + '\'' +
                    ", v=" + v +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", image='" + image + '\'' +
                    ", searchTerms=" + searchTerms +
                    '}';
        }


    }
}
