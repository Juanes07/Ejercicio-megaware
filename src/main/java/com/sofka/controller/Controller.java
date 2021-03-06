package com.sofka.controller;

import com.sofka.domain.*;
import com.sofka.service.CategoryService;
import com.sofka.service.DescargaService;
import com.sofka.service.ItemService;
import com.sofka.service.SubCategoryService;
import com.sofka.utility.LoginData;
import com.sofka.utility.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {

    @Autowired
    DescargaService descargaService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ItemService itemService;



    /**
     * Variable para el manejo de las respuestas de las API
     */
    private  Response response = new Response();

    /**
     * Manejo del código HTTP que se responde en las API
     */
    private HttpStatus httpStatus = HttpStatus.OK;

    @PostMapping(path = "/api/v1/login")
    public ResponseEntity<Response> login(@RequestBody LoginData loginData) {
        response.restart();
        try {
            response.message = "Todo OK";
            response.data = loginData.getToken();
            httpStatus = HttpStatus.OK;
            // realizo consulta para saber si el usuario y contraseña coinciden
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    @GetMapping(path = "/api/v1/ejemplo-token")
    public ResponseEntity<Response> getToken(@RequestHeader("Authorization") String authorization) {
        response.restart();
        try {
            response.message = "Todo OK - TOKEN";
            response.data = authorization.replace("Bearer ", "");
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    @GetMapping(path = "api/v1/category/desc")
    public List<Categoria> getCategoryDesc(){
        try {
            response.message = "Todo OK";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return categoryService.getByCategoryDesc();

    }

    @GetMapping(path = "api/v1/category/asc")
    public List<Categoria> getCategoryAsc(){
        try {
            response.message = "Todo OK";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return categoryService.getByCategoryAsc();
    }


    @GetMapping(path = "api/v1/subcategory/asc")
    public List<Subcategoria> getSubCategoryAsc(){
        try {
            response.message = "Todo OK";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return subCategoryService.getBySubCategoryAsc();
    }

    @GetMapping(path = "api/v1/subcategory/desc")
    public List<Subcategoria> getSubCategorydesc(){
        try {
            response.message = "Todo OK";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return subCategoryService.getBySubCategorydesc();
    }

    @GetMapping(path = "api/v1/item/desc")
    public List<Item> getItemDesc(){
        try {
            response.message = "Todo OK";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return itemService.getItemDesc();
    }

    @GetMapping(path = "api/v1/item/asc")
    public List<Item> getItemAsc(){
        try {
            response.message = "Todo OK";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return itemService.getItemAsc();
    }

    @DeleteMapping(path="/api/v1/category/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable ("id") Categoria categoria) {
      log.info("Categoria a borrar: {}", categoria);
      categoryService.delete(categoria);
      return  new ResponseEntity(categoria,HttpStatus.OK);
    }

//    @DeleteMapping(path="/api/v1/subcategory/{id}")
//    public ResponseEntity<Subcategoria> delete(@PathVariable ("id") Subcategoria subcategoria) {
//        log.info("Subcategoria a borrar: {}", subcategoria);
//        subCategoryService.delete(subcategoria);
//        return  new ResponseEntity(subcategoria,HttpStatus.OK);
//    }

    @PatchMapping (path = "/api/v1/category/namecategory")
    public ResponseEntity<Categoria> updateCategoryName(Categoria categoria, Integer idCategory){
        log.info("categoria a modificar: {}", categoria);
        response.data = categoria;
        categoryService.updateCategory(categoria, idCategory);
        return  new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PatchMapping (path = "/api/v1/subcategory/namesubcategory")
    public ResponseEntity<Subcategoria> updateSubCategoryName(Subcategoria subcategoria, Integer idSubCategory){
        log.info("subcategoria a modificar: {}", subcategoria);
        response.data = subcategoria;
        subCategoryService.updateSubCategory(subcategoria, idSubCategory);
        return  new ResponseEntity<>(subcategoria, HttpStatus.OK);
    }

    @GetMapping(path = "/api/vi/download")
    public List<Descarga> getDownloadByUser(Descarga descarga){
        try {
            response.message = "Todo OK";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return descargaService.getDownloadByUser(descarga);
    }


    private void getErrorMessageInternal(Exception exception) {
        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private void getErrorMessageForResponse(DataAccessException exception) {
        response.error = true;
        if(exception.getRootCause() instanceof SQLException) {
            SQLException sqlEx = (SQLException) exception.getRootCause();
            var sqlErrorCode = sqlEx.getErrorCode();
            switch (sqlErrorCode) {
                case 1062:
                    response.message = "El dato ya está registrado";
                    break;
                case 1452:
                    response.message = "El usuario indicado no existe";
                    break;
                default:
                    response.message = exception.getMessage();
                    response.data = exception.getCause();
            }
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            response.message = exception.getMessage();
            response.data = exception.getCause();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
