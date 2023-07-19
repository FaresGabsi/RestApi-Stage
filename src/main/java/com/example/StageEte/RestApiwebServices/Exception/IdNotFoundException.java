package com.example.StageEte.RestApiwebServices.Exception;


public class IdNotFoundException extends RuntimeException {

  public IdNotFoundException(int id) {
    super("Could not find id:" + id);
  }
}