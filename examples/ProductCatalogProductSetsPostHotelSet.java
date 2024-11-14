/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

 import com.facebook.ads.sdk.*;
import java.io.File;
import java.util.Arrays;

public class ProductCatalogProductSetsPostHotelSet {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<PRODUCT_CATALOG_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new ProductCatalog(id, context).createProductSet()
      .setName("Test Hotel Set")
      .setFilter("{\"brand\":{\"i_contains\":\"sample brand\"}}")
      .execute();

  }
}