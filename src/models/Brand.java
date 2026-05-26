package models;

import java.util.Arrays;

public class Brand {
  
  private String BrandName;
  private CarModel[] models;
  
  
  public Brand(String BrandName, CarModel[] models) {
    this.BrandName = BrandName;
    this.models = models;
  }


  public String getBrandName() {
    return BrandName;
  }


  public void setBrandName(String BrandName) {
    this.BrandName = BrandName;
  }


  public CarModel[] getModels() {
    return models;
  }


  public void setModels(CarModel[] models) {
    this.models = models;
  }

  
  public int getTotalValidYears(){
    int total = 0;
    if(this.models ==null){
      return 0;
    }
    for(int i = 0; i < this.models.length; i++){
      CarModel currentModel = this.models[i];

      if(currentModel != null && currentModel.getYears() != null){
        CarYear[] years = currentModel.getYears();

        for(int j = 0; j < years.length; j++){
          CarYear currentYear = years[j];

          if(currentYear != null && currentYear.isValid()){
            total++;
          }
        }
      }
    }
    return total;
  }

  @Override
  public String toString() {
    return "Brand [BrandName=" + BrandName + ", models=" + Arrays.toString(models) + "]";
  }
  
}
