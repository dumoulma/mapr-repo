package com.mapr.qss.cep.demo.telecom.models;

public class SiteInfo {

  private long siteId;
  private boolean lut;
  private boolean shoppingMall;
  private Coverage coverage;

  public SiteInfo() {
  }

  public SiteInfo(long siteId, boolean lut, boolean shoppingMall, Coverage coverage) {
    super();
    this.siteId = siteId;
    this.lut = lut;
    this.shoppingMall = shoppingMall;
    this.coverage = coverage;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((coverage == null) ? 0 : coverage.hashCode());
    result = prime * result + (lut ? 1231 : 1237);
    result = prime * result + (shoppingMall ? 1231 : 1237);
    result = prime * result + (int) (siteId ^ (siteId >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SiteInfo other = (SiteInfo) obj;
    if (coverage != other.coverage)
      return false;
    if (lut != other.lut)
      return false;
    if (shoppingMall != other.shoppingMall)
      return false;
    if (siteId != other.siteId)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SiteInfo [siteId=").append(siteId).append(", lut=").append(lut).append(", shoppingMall=")
            .append(shoppingMall).append(", coverage=").append(coverage).append("]");
    return builder.toString();
  }

  public long getSiteId() {
    return siteId;
  }

  public void setSiteId(long siteId) {
    this.siteId = siteId;
  }

  public boolean isLut() {
    return lut;
  }

  public void setLut(boolean lut) {
    this.lut = lut;
  }

  public Coverage getCoverage() {
    return coverage;
  }

  public void setCoverage(Coverage coverage) {
    this.coverage = coverage;
  }

  public boolean isShoppingMall() {
    return shoppingMall;
  }

  public void setShoppingMall(boolean shoppingMall) {
    this.shoppingMall = shoppingMall;
  }

}
