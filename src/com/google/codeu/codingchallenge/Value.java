package com.google.codeu.codingchallenge;


public class Value{
  /**
   * The kind of Value this is.
   */
  public int kind;		// type of token
  /**
   * Value is a number.
   */
    static public final int sumJSON = 1;
    /**
     * Value is a boolean.
     */
    static public final int sumString = 2;

    /**
      * A string value
    */
    private String aString;
    /**
      * A JSON value
    */
    private JSON aJSON;

    public Value(String s){
      kind = sumString;
      aString = s;
    }
    public Value(JSON j){
      kind = sumJSON;
      j = aJSON;
    }
    public boolean isJSON(){
      return kind == sumJSON;
    }
    public boolean isString(){
      return kind == sumString;
    }
    public String getString (){

      return aString;
    }
    public JSON getJSON(){

      return aJSON;
    }
    public boolean equals(Object other){
      //PRE: given a string or JSON to compare,
      //POST: Return true if they are logically equal.
      Value that = (Value)other;
      boolean result = false;

      //accounts for if they are different types
      if(this.kind!=that.kind) return false;

      switch(this.kind){
        case sumJSON:
        result = aJSON.toString().equals(
                 that.aJSON.toString());
                 break;
        case sumString:
        result = this.aString.equals(
                 that.aString);
                 break;
          default:
          result = false;
          break;
      }
      return result;
    }

    //PRE:given a JSON
    //POST: return a string representation of it.
    @Override
    public String toString(){
      String result ="<unknown>";
      if(kind==sumJSON){
        result = ""+aJSON;
      }
      return result;

    }
}
