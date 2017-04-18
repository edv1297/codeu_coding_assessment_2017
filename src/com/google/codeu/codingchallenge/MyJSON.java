// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.codingchallenge;

import java.util.Collection;
import java.util.HashMap;

final class MyJSON implements JSON {
private HashMap <String,Value> data = new HashMap<String, Value>();

public MyJSON(String name, Value value){
  data.put(name, value);
}
public MyJSON(){}

  @Override
  //pre: given an input that is initialized by curly braces
  //post: return the JSON object if the name in the parameter
  //exists in the code
  public JSON getObject(String name) {

    if(data.containsKey(name)&&
      (data.get(name).isJSON())){
      return data.get(name).getJSON();
    }else{
      System.out.println("<ERROR> String not found.");
      return null;
    }
   }

  @Override
   public JSON setObject(String name, JSON value) {
    // TODO: implement this
      Value v = new Value(value);
      if(data.get(name)!=null){
        data.replace(name,v);
      }else{
        data.put(name,v);
      }
      return this;
    }

@Override
  public String getString(String name) {
    // TODO: implement this

      if(data.containsKey(name)){
        if(data.get(name)!=null){
          return data.get(name).toString();
      }
    }return null;
  }


//   @Override
   public JSON setString(String name, String value) {
    // TODO: implement this
    //Pre: Hashmap

    Value temp = new Value(value);

    if(data.get(name) != null){
      data.replace(name, temp);
    }else{
      data.put(name, temp);
    }

    return this;
   }

  @Override
  public void getObjects(Collection<String> names) {
    // TODO: implement this
    //Assert.pre(data.size()==0, "<ERROR> Data set is empty.");
    names.add(data.values().toString());

}
  @Override
  public void getStrings(Collection<String> names) {
    // TODO: implement this
    //Assert.pre(data.size()==0, "<ERROR> Data set is empty.");
      names.add(data.keySet().toString());

  }
}
