package com.mapr.qss.cep.demo.telecom.models;

import java.util.*;

public class SiteManager {

  private static final Map<Long, SiteInfo> siteMap =
          new HashMap<>();
  private static final Set<Long> lutSiteSet =
          new HashSet<>();
  private static final Set<Long> shoppingMallSiteSet =
          new HashSet<>();
  private static final int MAX_SITE_NO = 1000;

  static {
    generateSiteMap();
  }

  public static void generateSiteMap() {
    boolean[] lutSets = {false, false, false, false, false,
            true, false, true, false, false
    };
    boolean[] shoppingSets = {true, false, true, false, false,
            false, false, false, false, false
    };
    Coverage coverage = Coverage.SITE_2G;

    for (int index = 0; index < MAX_SITE_NO; index++) {
      SiteInfo siteInfo = new SiteInfo(index,
                                              lutSets[index % 10], shoppingSets[index % 10], coverage);
      siteMap.put(siteInfo.getSiteId(), siteInfo);

      if (lutSets[index % 10]) {
        lutSiteSet.add(siteInfo.getSiteId());
      }
      if (shoppingSets[index % 10]) {
        shoppingMallSiteSet.add(siteInfo.getSiteId());
      }

      if (coverage == Coverage.SITE_2G) {
        coverage = Coverage.SITE_3G;
      } else if (coverage == Coverage.SITE_3G) {
        coverage = Coverage.SITE_4G;
      } else if (coverage == Coverage.SITE_4G) {
        coverage = Coverage.SITE_2G;
      }
    }
  }

  public static Long getAnySiteId() {
    Random random = new Random();
    int maxNumber = random.nextInt(MAX_SITE_NO);
    Iterator<Long> iterator = siteMap.keySet().iterator();

    for (int index = 0; index < maxNumber - 1; index++) {
      iterator.next();
    }

    return iterator.next();
  }

  public static Set<Long> getLutSiteSet() {
    return lutSiteSet;
  }

  public static Set<Long> getShoppingMallSiteSet() {
    return shoppingMallSiteSet;
  }

  public static Long getSiteIdByCoverage(Coverage coverage) {
    Iterator<SiteInfo> iterator = siteMap.values().iterator();
    long siteId = -1;

    while (iterator.hasNext()) {
      SiteInfo siteInfo = iterator.next();
      if (siteInfo.getCoverage() == coverage && !siteInfo.isLut() && !siteInfo.isShoppingMall()) {
        siteId = siteInfo.getSiteId();
        break;
      }
    }

    return siteId;
  }

  public static Iterator<SiteInfo> iterator() {
    return siteMap.values().iterator();
  }

  public static void addSite(SiteInfo siteInfo) {
    siteMap.put(siteInfo.getSiteId(), siteInfo);
  }

  public static SiteInfo lookup(long siteId) {
    return siteMap.get(siteId);
  }

  public static boolean hasSite(long siteId) {
    return siteMap.containsKey(siteId);
  }

  public static boolean isLUTSite(long siteId) {
    SiteInfo siteInfo = siteMap.get(siteId);
    return siteInfo != null && siteInfo.isLut();
  }

  public static boolean isShoppingMallSite(long siteId) {
    SiteInfo siteInfo = siteMap.get(siteId);
    return siteInfo != null && siteInfo.isShoppingMall();
  }

  public static Coverage getCoverage(long siteId) {
    SiteInfo siteInfo = siteMap.get(siteId);
    Coverage coverage = null;

    if (siteInfo != null) {
      coverage = siteInfo.getCoverage();
    }

    return coverage;
  }
}
