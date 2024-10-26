package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;

public class BurgerValidation {

    public static boolean isIdValid(Long id){
        if(id <= 0 || id == null){
            return false;
        }
        return true;
    }


    public static boolean burgerIsValid(Burger burger){
        if(burger.getIsVegan() == null ||
                burger.getName() == null ||
                burger.getPrice() == null ||
                burger.getContents() == null ||
                burger.getBreadType() == null){
            return false;
        }
        return true;
    }

    public static boolean isPriceValid(Integer price){
        if(price <= 0){
            return false;
        }

        return true;
    }


    public static boolean isBreadTypeValid(BreadType breadType){
        if (breadType != null){
            return true;
        }
        return false;
    }


    public static boolean isContentValid(String content){
        if (content != null){
            return true;
        }

        return false;
    }

}
