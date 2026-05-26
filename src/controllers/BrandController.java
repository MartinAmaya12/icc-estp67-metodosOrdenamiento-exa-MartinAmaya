package controllers;

import models.Brand;

public class BrandController {
  public Brand[] sortSelectionDesc(Brand[]brands){
    int n = brands.length;
    for(int i = 0; i < n -1; i++){
      int maxIndex = i;
      for(int j = i + 1; j < n; j++){
        if(brands[j].getTotalValidYears() > brands[maxIndex].getTotalValidYears()){
          maxIndex = j;
        }
      }
      if(maxIndex != i){
        Brand temp = brands[i];
        brands[i] = brands[maxIndex];
        brands[maxIndex] = temp;
      }
    }

    return brands;
  }

  public Brand binarySearchByValidYears(Brand[] brands, int validYears,boolean isAscending){
    
    //inicializar indices
    int bajo = 0;
    int alto = brands.length - 1;
    while(bajo <= alto){
      int centro = (bajo + alto)/2;
      int valorCentro = brands[centro].getTotalValidYears();
      if(valorCentro == validYears){
        return brands[centro];
      }else if(isAscending){
        alto = centro + 1;
      }else{
        bajo = centro - 1; 
      }

    }
    
    return null;
  }
}
