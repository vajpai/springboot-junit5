package com.demo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestParamsDef {
  private String keywords;
  private String departments;
  private Integer storeNumber;
  private long contractId = 0;
  private boolean isEmployee = false;
  private boolean showRelatedCats = false;
  private boolean showJumpNav = false;
  private boolean showVariants = false;
  private boolean isMobile = false;
  private boolean showURL = false;
  private boolean rollUpVariants = false;
  private String sortMethod;
  private String searchSegment;
  private String searchSegmentList;
  private Integer offset;
  private Integer maxResults;
  private String channelType;
  private String site;

}