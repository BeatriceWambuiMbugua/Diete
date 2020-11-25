
package com.moringaschool.diete.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpoonacularRecipeSearchResponse {

    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SpoonacularRecipeSearchResponse() {
    }

    /**
     * 
     * @param number
     * @param totalResults
     * @param offset
     * @param results
     */
    public SpoonacularRecipeSearchResponse(Integer offset, Integer number, List<Result> results, Integer totalResults) {
        super();
        this.offset = offset;
        this.number = number;
        this.results = results;
        this.totalResults = totalResults;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

}
