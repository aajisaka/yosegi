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

package jp.co.yahoo.yosegi.block;

import jp.co.yahoo.yosegi.binary.ColumnBinary;
import jp.co.yahoo.yosegi.config.Configuration;
import jp.co.yahoo.yosegi.spread.Spread;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface IBlockWriter {

  void setup( final int blockSize , final Configuration config ) throws IOException;

  void appendHeader( final byte[] headerBytes );

  void append( final int spreadSize , final List<ColumnBinary> binaryList ) throws IOException;

  List<ColumnBinary> convertRow( final Spread spread ) throws IOException;

  boolean canAppend( final List<ColumnBinary> binaryList ) throws IOException;

  int size();

  void writeFixedBlock( final OutputStream out ) throws IOException;

  void writeVariableBlock( final OutputStream out ) throws IOException;

  void write( final OutputStream out , final int dataSize ) throws IOException;

  String getReaderClassName();

  void close() throws IOException;

}
