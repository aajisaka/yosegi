/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.co.yahoo.yosegi.message.formatter.text;

import jp.co.yahoo.yosegi.message.objects.PrimitiveObject;
import jp.co.yahoo.yosegi.message.parser.IParser;
import jp.co.yahoo.yosegi.util.ByteArrayData;

import java.io.IOException;

public class TextBooleanFormatter implements ITextFormatter {

  @Override
  public void write( final ByteArrayData buffer , final Object obj ) throws IOException {
    if ( obj instanceof Boolean ) {
      buffer.append( ( (Boolean)obj ).toString().getBytes( "UTF-8" ) );
    } else if ( obj instanceof String ) {
      buffer.append(
          Boolean.valueOf(
            "true".equals( (String)obj )
          ).toString().getBytes( "UTF-8" ) );
    } else if ( obj instanceof PrimitiveObject) {
      buffer.append(
          Boolean.valueOf(
            ( (PrimitiveObject)obj ).getBoolean() 
          ).toString().getBytes( "UTF-8" ) );
    }
  }

  @Override
  public void writeParser(
      final ByteArrayData buffer ,
      final PrimitiveObject obj ,
      final IParser parser ) throws IOException {
    buffer.append(
        Boolean.valueOf(
          ( (PrimitiveObject)obj ).getBoolean() 
        ).toString().getBytes( "UTF-8" ) );
  }

}
