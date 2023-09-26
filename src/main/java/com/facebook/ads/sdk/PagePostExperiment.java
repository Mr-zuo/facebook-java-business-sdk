/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class PagePostExperiment extends APINode {
  @SerializedName("auto_resolve_settings")
  private Object mAutoResolveSettings = null;
  @SerializedName("control_video_id")
  private String mControlVideoId = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("declared_winning_time")
  private String mDeclaredWinningTime = null;
  @SerializedName("declared_winning_video_id")
  private String mDeclaredWinningVideoId = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("experiment_video_ids")
  private List<String> mExperimentVideoIds = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("insight_snapshots")
  private List<Map<String, List<Map<Long, Object>>>> mInsightSnapshots = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("optimization_goal")
  private String mOptimizationGoal = null;
  @SerializedName("post_variant_fields")
  private List<String> mPostVariantFields = null;
  @SerializedName("publish_status")
  private String mPublishStatus = null;
  @SerializedName("publish_time")
  private String mPublishTime = null;
  @SerializedName("scheduled_experiment_timestamp")
  private String mScheduledExperimentTimestamp = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  PagePostExperiment() {
  }

  public PagePostExperiment(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PagePostExperiment(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PagePostExperiment fetch() throws APIException{
    PagePostExperiment newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PagePostExperiment fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PagePostExperiment> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PagePostExperiment fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PagePostExperiment> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PagePostExperiment> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PagePostExperiment>)(
      new APIRequest<PagePostExperiment>(context, "", "/", "GET", PagePostExperiment.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PagePostExperiment>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PagePostExperiment.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static PagePostExperiment loadJSON(String json, APIContext context, String header) {
    PagePostExperiment pagePostExperiment = getGson().fromJson(json, PagePostExperiment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pagePostExperiment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    pagePostExperiment.context = context;
    pagePostExperiment.rawValue = json;
    pagePostExperiment.header = header;
    return pagePostExperiment;
  }

  public static APINodeList<PagePostExperiment> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PagePostExperiment> pagePostExperiments = new APINodeList<PagePostExperiment>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          pagePostExperiments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return pagePostExperiments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pagePostExperiments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pagePostExperiments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pagePostExperiments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pagePostExperiments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  pagePostExperiments.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pagePostExperiments.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pagePostExperiments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pagePostExperiments.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return pagePostExperiments;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              pagePostExperiments.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pagePostExperiments;
          }

          // Sixth, check if it's pure JsonObject
          pagePostExperiments.clear();
          pagePostExperiments.add(loadJSON(json, context, header));
          return pagePostExperiments;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGetVideoInsights getVideoInsights() {
    return new APIRequestGetVideoInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Object getFieldAutoResolveSettings() {
    return mAutoResolveSettings;
  }

  public String getFieldControlVideoId() {
    return mControlVideoId;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldDeclaredWinningTime() {
    return mDeclaredWinningTime;
  }

  public String getFieldDeclaredWinningVideoId() {
    return mDeclaredWinningVideoId;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public List<String> getFieldExperimentVideoIds() {
    return mExperimentVideoIds;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Map<String, List<Map<Long, Object>>>> getFieldInsightSnapshots() {
    return mInsightSnapshots;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public List<String> getFieldPostVariantFields() {
    return mPostVariantFields;
  }

  public String getFieldPublishStatus() {
    return mPublishStatus;
  }

  public String getFieldPublishTime() {
    return mPublishTime;
  }

  public String getFieldScheduledExperimentTimestamp() {
    return mScheduledExperimentTimestamp;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestGetVideoInsights extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVideoInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideoInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/video_insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideoInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideoInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideoInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideoInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideoInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideoInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<PagePostExperiment> {

    PagePostExperiment lastResponse = null;
    @Override
    public PagePostExperiment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "auto_resolve_settings",
      "control_video_id",
      "creation_time",
      "creator",
      "declared_winning_time",
      "declared_winning_video_id",
      "description",
      "experiment_video_ids",
      "id",
      "insight_snapshots",
      "name",
      "optimization_goal",
      "post_variant_fields",
      "publish_status",
      "publish_time",
      "scheduled_experiment_timestamp",
      "updated_time",
    };

    @Override
    public PagePostExperiment parseResponse(String response, String header) throws APIException {
      return PagePostExperiment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PagePostExperiment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PagePostExperiment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PagePostExperiment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PagePostExperiment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PagePostExperiment>() {
           public PagePostExperiment apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAutoResolveSettingsField () {
      return this.requestAutoResolveSettingsField(true);
    }
    public APIRequestGet requestAutoResolveSettingsField (boolean value) {
      this.requestField("auto_resolve_settings", value);
      return this;
    }
    public APIRequestGet requestControlVideoIdField () {
      return this.requestControlVideoIdField(true);
    }
    public APIRequestGet requestControlVideoIdField (boolean value) {
      this.requestField("control_video_id", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestDeclaredWinningTimeField () {
      return this.requestDeclaredWinningTimeField(true);
    }
    public APIRequestGet requestDeclaredWinningTimeField (boolean value) {
      this.requestField("declared_winning_time", value);
      return this;
    }
    public APIRequestGet requestDeclaredWinningVideoIdField () {
      return this.requestDeclaredWinningVideoIdField(true);
    }
    public APIRequestGet requestDeclaredWinningVideoIdField (boolean value) {
      this.requestField("declared_winning_video_id", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestExperimentVideoIdsField () {
      return this.requestExperimentVideoIdsField(true);
    }
    public APIRequestGet requestExperimentVideoIdsField (boolean value) {
      this.requestField("experiment_video_ids", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInsightSnapshotsField () {
      return this.requestInsightSnapshotsField(true);
    }
    public APIRequestGet requestInsightSnapshotsField (boolean value) {
      this.requestField("insight_snapshots", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGet requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGet requestPostVariantFieldsField () {
      return this.requestPostVariantFieldsField(true);
    }
    public APIRequestGet requestPostVariantFieldsField (boolean value) {
      this.requestField("post_variant_fields", value);
      return this;
    }
    public APIRequestGet requestPublishStatusField () {
      return this.requestPublishStatusField(true);
    }
    public APIRequestGet requestPublishStatusField (boolean value) {
      this.requestField("publish_status", value);
      return this;
    }
    public APIRequestGet requestPublishTimeField () {
      return this.requestPublishTimeField(true);
    }
    public APIRequestGet requestPublishTimeField (boolean value) {
      this.requestField("publish_time", value);
      return this;
    }
    public APIRequestGet requestScheduledExperimentTimestampField () {
      return this.requestScheduledExperimentTimestampField(true);
    }
    public APIRequestGet requestScheduledExperimentTimestampField (boolean value) {
      this.requestField("scheduled_experiment_timestamp", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public PagePostExperiment copyFrom(PagePostExperiment instance) {
    this.mAutoResolveSettings = instance.mAutoResolveSettings;
    this.mControlVideoId = instance.mControlVideoId;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mDeclaredWinningTime = instance.mDeclaredWinningTime;
    this.mDeclaredWinningVideoId = instance.mDeclaredWinningVideoId;
    this.mDescription = instance.mDescription;
    this.mExperimentVideoIds = instance.mExperimentVideoIds;
    this.mId = instance.mId;
    this.mInsightSnapshots = instance.mInsightSnapshots;
    this.mName = instance.mName;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mPostVariantFields = instance.mPostVariantFields;
    this.mPublishStatus = instance.mPublishStatus;
    this.mPublishTime = instance.mPublishTime;
    this.mScheduledExperimentTimestamp = instance.mScheduledExperimentTimestamp;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PagePostExperiment> getParser() {
    return new APIRequest.ResponseParser<PagePostExperiment>() {
      public APINodeList<PagePostExperiment> parseResponse(String response, APIContext context, APIRequest<PagePostExperiment> request, String header) throws MalformedResponseException {
        return PagePostExperiment.parseResponse(response, context, request, header);
      }
    };
  }
}
