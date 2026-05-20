package models;

import java.util.Arrays;

public class Brand {
  private String brandName;
  private CarModel [] models;
  public Brand(String brandName, CarModel[] models) {
    this.brandName = brandName;
    this.models = models;
  }
  public String getBrandName() {
    return brandName;
  }
  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }
  public CarModel[] getModels() {
    return models;
  }
  public void setModels(CarModel[] models) {
    this.models = models;
  }
  @Override
  public String toString() {
    return "Brand [brandName=" + brandName + ", models=" + Arrays.toString(models) + "]";
  }

  public int getTotalValidYears(){
    int total = 0;
    for(int i = 0; i < models.length; i++){
      CarModel modeloAct = this.models[i];
      for(int j = 0; j < modeloAct.getYears().length; j++){
        CarYear anioAct = modeloAct.getYears()[j];
        if(anioAct != null && anioAct.isValid()){
          total++;
        }
      }
    }

    return total;
  }

  
}
