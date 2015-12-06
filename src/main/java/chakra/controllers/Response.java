package chakra.controllers;

public class Response<T> {
  public Response(T data){
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  protected T data;
}
