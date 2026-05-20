package controllers;

import models.Brand;

public class BrandController {
  public Brand[]  sortBubbleDesc(Brand[] brands){
    int n = brands.length;

    for(int i = 0; i < n - 1; i++){
      boolean cambio = false;
      for(int j = 1; j < n - 1 - i; j++){
        int anioAct = brands[j].getTotalValidYears();
        int anioSig = brands[j + 1].getTotalValidYears();

        if(anioAct < anioSig){
          Brand aux = brands[j];
          brands[j] = brands[j + 1];
          brands[j + 1] = aux;
          cambio = true;
        }
      }
      if(! cambio){
        break;
      }
    }

    return brands;
  }

  public Brand binarySearchByValidYears(Brand[] brands, int validYears, boolean isAscending){
    int bajo = 0;
    int alto = 0;
    while(bajo <= alto){
      int centro = (bajo + alto)/2;
      int aniosCentro = brands[centro].getTotalValidYears();
      if(aniosCentro == validYears){
        return brands[centro];
      }

      if (isAscending) {
            if (aniosCentro < validYears) {
                bajo = centro + 1;
            } else {
                alto = centro - 1;
            }
        } else {
            if (aniosCentro > validYears) {
                bajo = centro + 1;
            } else {
                alto = centro - 1;
            }
        }
    }


    return null;
  }
}
