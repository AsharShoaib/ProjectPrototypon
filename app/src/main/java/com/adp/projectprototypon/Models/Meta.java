package com.adp.projectprototypon.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by asharshoaib on 2016-09-19.
 */
public class Meta {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("request_type")
    @Expose
    private String requestType;

    @SerializedName("base_URI")
    @Expose
    private String baseURI;

    @SerializedName("version")
    @Expose
    private Integer version;

    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("more_info")
    @Expose
    private MoreInfo moreInfo;

    @SerializedName("status")
    @Expose
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MoreInfo getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(MoreInfo moreInfo) {
        this.moreInfo = moreInfo;
    }


    @Override
    public String toString() {
        return "Meta{" +
                "title='" + title + '\'' +
                ", requestType='" + requestType + '\'' +
                ", baseURI='" + baseURI + '\'' +
                ", version=" + version +
                ", statusCode=" + statusCode +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", moreInfo=" + moreInfo +
                '}';
    }

    public class MoreInfo {

        @SerializedName("results_count")
        @Expose
        private Integer resultsCount;

        /**
         * @return The resultsCount
         */
        public Integer getResultsCount() {
            return resultsCount;
        }

        /**
         * @param resultsCount The results_count
         */
        public void setResultsCount(Integer resultsCount) {
            this.resultsCount = resultsCount;
        }

    }
}
