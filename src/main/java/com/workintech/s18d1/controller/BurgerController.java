package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@NoArgsConstructor
public class BurgerController {

    private BurgerDaoImpl burgerDaoImp;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImp) {
        this.burgerDaoImp = burgerDaoImp;
    }


    @GetMapping("/burgers")
    public ResponseEntity<List<Burger>> getBurgers(){
        return ResponseEntity.of(Optional.ofNullable(burgerDaoImp.findAll()));
    }

    @GetMapping("/burgers/{id}")
    public ResponseEntity<Burger> getById(long id){
        if(BurgerValidation.isIdValid(id)){
            return ResponseEntity.ok(burgerDaoImp.findById(id));
        }

        throw new BurgerException("Please enter valid id" , HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/burgers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Burger> createBurger(Burger burger){
        if(BurgerValidation.burgerIsValid(burger)){
            burgerDaoImp.save(burger);
        }

        throw  new BurgerException("The data of burger is not valid" , HttpStatus.BAD_REQUEST);
    }


      @PutMapping("/burgers/{id}")
     public ResponseEntity<Burger> updateBurger(@PathVariable long id , @RequestBody Burger burger){
        if(BurgerValidation.isIdValid(id) && BurgerValidation.burgerIsValid(burger)){
           return ResponseEntity.ok(burgerDaoImp.update(burger));
        } else if (!BurgerValidation.isIdValid(id)) {
            throw   new BurgerException("There is no burger with this id" , HttpStatus.NOT_FOUND);
        } else if (!BurgerValidation.burgerIsValid(burger)) {
            throw new BurgerException("The data of burger is not valid" , HttpStatus.BAD_REQUEST);
        }

          throw new BurgerException("Request is not valid" , HttpStatus.BAD_REQUEST);
      }


      @DeleteMapping("/burgers/{id}")
    public ResponseEntity<Burger> deleteBurger(@PathVariable long id){
        if(BurgerValidation.isIdValid(id)){
           return  ResponseEntity.ok( burgerDaoImp.remove(id));
        }
        throw new BurgerException("Id is not valid" , HttpStatus.BAD_REQUEST);
      }


      @GetMapping("/burgers/findByPrice")
    public ResponseEntity<List<Burger>> findByPrice(@RequestBody Integer price){
        if(BurgerValidation.isPriceValid(price)){
            return ResponseEntity.ok(burgerDaoImp.findByPrice(price));
        }

        throw new BurgerException("The price is not valid" , HttpStatus.BAD_REQUEST);
      }


      @GetMapping("/burgers/findByBreadType")
    public ResponseEntity<List<Burger>> findByPriceType(@RequestBody BreadType breadType){
        if(BurgerValidation.isBreadTypeValid(breadType)){
            return ResponseEntity.ok(burgerDaoImp.findByBreadType(breadType));
        }

        throw new BurgerException("The data is breadType is nor valid" , HttpStatus.BAD_REQUEST);
      }


      @GetMapping("/burgers/findByContent")
    public ResponseEntity<List<Burger>> findByContent(@RequestBody String content){
        if(BurgerValidation.isContentValid(content)){
            return ResponseEntity.ok(burgerDaoImp.findByContent(content));
        }

        throw new BurgerException("Please enter valid content" , HttpStatus.BAD_REQUEST);
      }


}
