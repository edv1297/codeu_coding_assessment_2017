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

import java.io.IOException;

final class MyJSONParser implements JSONParser {

  @Override
  public JSON parse(String in)throws IOException {
    MyJSON json;
    String name;
    Value value;
    int start, end;

    if(in.startsWith("{") && in.endsWith("}") ){
      if(in.contains("\"") && in.contains(":")){
        start = in.indexOf("\"");
        end = in.indexOf("\"", start);
        if(start>0  && end > 0){
          name = in.substring(start+1, end);
          if(in.indexOf("}") == in.lastIndexOf("}")){
            int valueStart = in.indexOf("\"", in.indexOf(":"));
            int valueEnd = in.indexOf("\"", valueStart);

            if(valueStart>0 && valueEnd>0){
              value = new Value(in.substring(valueStart,valueEnd));
              // good std input
              return new MyJSON(name, value);
            }
            else{
              int startKey = in.indexOf(":", end);
              Value key= new Value(in.substring(startKey+1));

              int recursiveStart = in.indexOf("{", in.indexOf(":"));
              int recursiveEnd = in.indexOf("}", recursiveStart);
              String search = in.substring(recursiveStart, recursiveEnd+1);

              parse(search);
              return new MyJSON(name,key);
            }
          }
          //good curly braces but bad formatting within them
          System.out.println("<Improper formatting>: Please try again.");
        }}}
        //empty entry "{ }"";
        return new MyJSON();
    }
  }
