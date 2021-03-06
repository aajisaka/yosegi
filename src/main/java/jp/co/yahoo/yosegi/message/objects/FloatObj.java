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

package jp.co.yahoo.yosegi.message.objects;

import java.io.IOException;

public class FloatObj implements PrimitiveObject {

  private static final float BYTE_MIN = Float.valueOf( Byte.MIN_VALUE );
  private static final float BYTE_MAX = Float.valueOf( Byte.MAX_VALUE );

  private static final float SHORT_MIN = Float.valueOf( Short.MIN_VALUE );
  private static final float SHORT_MAX = Float.valueOf( Short.MAX_VALUE );

  private static final float INTEGER_MIN = Float.valueOf( Integer.MIN_VALUE );
  private static final float INTEGER_MAX = Float.valueOf( Integer.MAX_VALUE );

  private static final float LONG_MIN = Float.valueOf( Long.MIN_VALUE );
  private static final float LONG_MAX = Float.valueOf( Long.MAX_VALUE );

  private final Float value;

  public FloatObj( final float value ) {
    this.value = value;
  }

  @Override
  public Object get() throws IOException {
    return value;
  }

  @Override
  public String getString() throws IOException {
    return Float.toString( value );
  }

  @Override
  public byte[] getBytes() throws IOException {
    return value.toString().getBytes( "UTF-8" );
  }

  @Override
  public byte getByte() throws IOException {
    if ( value < BYTE_MIN || BYTE_MAX < value ) {
      throw new NumberFormatException(
          "Can not down cast. float to byte. float value is " + value );
    }
    return value.byteValue();
  }

  @Override
  public short getShort() throws IOException {
    if ( value < SHORT_MIN || SHORT_MAX < value ) {
      throw new NumberFormatException(
          "Can not down cast. float to short. float value is " + value );
    }
    return value.shortValue();
  }

  @Override
  public int getInt() throws IOException {
    // Same as Integer.MAX_VALUE up to +128
    // Same as Integer.MIN_VALUE up to -128
    if ( value < INTEGER_MIN || INTEGER_MAX < value ) {
      throw new NumberFormatException(
          "Can not down cast. float to int. float value is " + value );
    }
    return value.intValue();
  }

  @Override
  public long getLong() throws IOException {
    // Same as Long.MAX_VALUE up to 549755846656
    // Same as Long.MIN_VALUE up to -549755846656
    if ( value < LONG_MIN || LONG_MAX < value ) {
      throw new NumberFormatException(
          "Can not down cast. float to long. float value is " + value );
    }
    return value.longValue();
  }

  @Override
  public float getFloat() throws IOException {
    return value;
  }

  @Override
  public double getDouble() throws IOException {
    return value.doubleValue();
  }

  @Override
  public boolean getBoolean() throws IOException {
    return ! ( value.equals( Float.valueOf(0) ) );
  }

  @Override
  public PrimitiveType getPrimitiveType() {
    return PrimitiveType.FLOAT;
  }

  @Override
  public int getObjectSize() {
    return Float.BYTES;
  }

}
