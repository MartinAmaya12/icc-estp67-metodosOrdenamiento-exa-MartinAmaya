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

  public Brand binarySearchByValidYears(Brand[] brands, int validYears, boolean isAscending) {
    int bajo = 0;
    int alto = brands.length - 1;

    while (bajo <= alto) {
        int centro = bajo + (alto - bajo) / 2;
        int valorCentro = brands[centro].getTotalValidYears();

        if (valorCentro == validYears) {
            return brands[centro];
        }

        if (isAscending) {
            if (valorCentro < validYears) {
                bajo = centro + 1;
            } else {
                alto = centro - 1;
            }
        } else { 
            if (valorCentro < validYears) {
                alto = centro - 1; 
            } else {
                bajo = centro + 1;
            }
        }
    }

    return null; 
}
}
