package com.mapr.qss.cep.demo.telecom;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Offer implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   private long id;
   private java.lang.String type;

   public Offer()
   {
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public java.lang.String getType()
   {
      return this.type;
   }

   public void setType(java.lang.String type)
   {
      this.type = type;
   }

   public Offer(long id, java.lang.String type)
   {
      this.id = id;
      this.type = type;
   }

}