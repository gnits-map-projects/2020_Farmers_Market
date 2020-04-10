// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Kaumudi/Desktop/project/2020_Farmers_Market/service/conf/routes
// @DATE:Fri Apr 10 18:40:06 IST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRegisterController RegisterController = new controllers.ReverseRegisterController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAdminController AdminController = new controllers.ReverseAdminController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCropController CropController = new controllers.ReverseCropController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBiddingController BiddingController = new controllers.ReverseBiddingController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUncheckedCropController UncheckedCropController = new controllers.ReverseUncheckedCropController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseNotificationController NotificationController = new controllers.ReverseNotificationController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRegisterController RegisterController = new controllers.javascript.ReverseRegisterController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAdminController AdminController = new controllers.javascript.ReverseAdminController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCropController CropController = new controllers.javascript.ReverseCropController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBiddingController BiddingController = new controllers.javascript.ReverseBiddingController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUncheckedCropController UncheckedCropController = new controllers.javascript.ReverseUncheckedCropController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseNotificationController NotificationController = new controllers.javascript.ReverseNotificationController(RoutesPrefix.byNamePrefix());
  }

}
