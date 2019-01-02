package com.linkquest.lhq;

public class CustomClass {

    public interfaceCustom interfaceCustom;

   public interface  interfaceCustom{
        void setData(String Data);
    }
    public static CustomClass customClass;

    public static CustomClass geCustomclass(){

     if(customClass == null){
         customClass = new CustomClass();
     }
     return customClass;
    }

    public void setInterfaceCustom(interfaceCustom interfaceCustom){
        this.interfaceCustom = interfaceCustom;
    }

    public void setNotifyData(String data){
        if(interfaceCustom != null) {
            interfaceCustom.setData(data);
        }
     //  interfaceCustom.setData(data);
    }
}
