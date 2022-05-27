package com.assignment.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetPlanetsResponse implements Serializable{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public class Result implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("rotation_period")
        @Expose
        private String rotationPeriod;
        @SerializedName("orbital_period")
        @Expose
        private String orbitalPeriod;
        @SerializedName("diameter")
        @Expose
        private String diameter;
        @SerializedName("climate")
        @Expose
        private String climate;
        @SerializedName("gravity")
        @Expose
        private String gravity;
        @SerializedName("terrain")
        @Expose
        private String terrain;
        @SerializedName("surface_water")
        @Expose
        private String surfaceWater;
        @SerializedName("population")
        @Expose
        private String population;
        @SerializedName("residents")
        @Expose
        private List<String> residents = null;
        @SerializedName("films")
        @Expose
        private List<String> films = null;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("edited")
        @Expose
        private String edited;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRotationPeriod() {
            return rotationPeriod;
        }

        public void setRotationPeriod(String rotationPeriod) {
            this.rotationPeriod = rotationPeriod;
        }

        public String getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public void setOrbitalPeriod(String orbitalPeriod) {
            this.orbitalPeriod = orbitalPeriod;
        }

        public String getDiameter() {
            return diameter;
        }

        public void setDiameter(String diameter) {
            this.diameter = diameter;
        }

        public String getClimate() {
            return climate;
        }

        public void setClimate(String climate) {
            this.climate = climate;
        }

        public String getGravity() {
            return gravity;
        }

        public void setGravity(String gravity) {
            this.gravity = gravity;
        }

        public String getTerrain() {
            return terrain;
        }

        public void setTerrain(String terrain) {
            this.terrain = terrain;
        }

        public String getSurfaceWater() {
            return surfaceWater;
        }

        public void setSurfaceWater(String surfaceWater) {
            this.surfaceWater = surfaceWater;
        }

        public String getPopulation() {
            return population;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        public List<String> getResidents() {
            return residents;
        }

        public void setResidents(List<String> residents) {
            this.residents = residents;
        }

        public List<String> getFilms() {
            return films;
        }

        public void setFilms(List<String> films) {
            this.films = films;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getEdited() {
            return edited;
        }

        public void setEdited(String edited) {
            this.edited = edited;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
}
