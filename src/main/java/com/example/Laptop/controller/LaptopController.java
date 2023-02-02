package com.example.Laptop.controller;

import com.example.Laptop.entity.Laptop;
import com.example.Laptop.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    //atributos
    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    //constructor



    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    //Metodo get para obtener todas las laptop`almacenada en la db
    //Obtenemos realizando una peticion al http://localhost:8082/api/laptops
    @GetMapping(value = "/api/laptops")
    @ApiOperation("Metodo para obtener todas las laptos de la base de datos")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
    //Crear laptop y almacenarlos en la db
    //Para guardar una laptop lo realizamos al http://localhost:8082/api/laptop
    @PostMapping(value = "/api/laptop")
    @ApiOperation("Metodo para registrar una laptop en la base de datos")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        return laptopRepository.save(laptop);
    }


    //buscar laptop por id
    @GetMapping(value = "/api/laptop/{id}")
    @ApiOperation("Metodo para obtener laptop por clave primaria id de tipo Long")
    public ResponseEntity<Laptop> getById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        Optional <Laptop> opt = laptopRepository.findById(id);
        if (opt.isPresent())
            return ResponseEntity.ok(opt.get());
        else
            return ResponseEntity.notFound().build();
    }

    //Borrar laptop por id
    @DeleteMapping(value = "/api/laptop/{id}")
    @ApiIgnore // Esta anotacion sirve para que no aparezca en la documentacion de la api swagger
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.info("Estas queriendo borrar un id que no ha sido encontrado");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    //Borrar todas las laptos existentes en la db
    @DeleteMapping("api/laptops")
    @ApiIgnore // Esta anotacion sirve para que no aparezca en la documentacion de la api swagger
    public ResponseEntity<Laptop> deleteAll(){
        log.info("Solicitud REST para eliminar todas las laptos");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    //actualizar laptop
    @PutMapping(value="/api/laptops")
    @ApiOperation("Metodo que sirve para actualizar una laptop en la db, enviandole con su id")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId().equals(laptop)){//si el id es nulo  quiere decir que no es una actualizacion
            log.warn("Estas intentando realizar algo distinto que actualizar");
            return ResponseEntity.badRequest().build();

        }if (!laptopRepository.existsById(laptop.getId())){
            log.warn("El id de la laptop no existe");
            return ResponseEntity.notFound().build();
        }
        //proceso de actualizacion
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);//laptop devuelto tien una clave primaria


    }

}
