/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.cxf.jaxrs;

import org.apache.cxf.jaxrs.model.ProviderInfo;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import java.util.List;

public class Debug {
    public static String listWriters(final List<ProviderInfo<MessageBodyWriter<?>>> messageWriters) {
        System.out.println("Installed MessageBodyWriter");
        for (final ProviderInfo<MessageBodyWriter<?>> providerInfo : messageWriters) {
            System.out.printf(" - MessageBodyWriter %s %s%n", providerInfo.isCustom(), providerInfo.getServiceClass().getName());
        }
        return "done";
    }

    public static String listReaders(final List<ProviderInfo<MessageBodyReader<?>>> messageReaders) {
        System.out.println("Installed MessageBodyReader");
        for (final ProviderInfo<MessageBodyReader<?>> providerInfo : messageReaders) {
            System.out.printf(" - MessageBodyReader %s %s %n", providerInfo.isCustom(), providerInfo.getServiceClass().getName());
        }
        return "done";
    }

    public static void printSelectedReader(final Class<?> targetTypeClass, final MediaType mediaType, final MessageBodyReader<?> provider) {
        System.out.printf("Selected MessageBodyReader %s, mediaType=%s, targetTypeClass=%s%n",
                provider.getClass().getName(),
                mediaType, targetTypeClass.getName()
        );
    }

    public static void printSelectedWriter(final Class<?> type, final MediaType mediaType, final MessageBodyWriter<Object> writer) {
        System.out.printf("Selected MessageBodyWriter %s, mediaType=%s, targetTypeClass=%s%n",
                writer.getClass().getName(),
                mediaType, type.getName()
        );
    }
}
