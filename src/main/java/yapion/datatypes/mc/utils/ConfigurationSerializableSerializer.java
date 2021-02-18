/*
 * Copyright 2019,2020,2021 yoyosource
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yapion.datatypes.mc.utils;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import yapion.hierarchy.types.YAPIONObject;
import yapion.serializing.api.SerializerObjectInterface;
import yapion.serializing.data.DeserializeData;
import yapion.serializing.data.SerializeData;

import java.util.HashMap;
import java.util.Map;

import static yapion.utils.IdentifierUtils.TYPE_IDENTIFIER;

public class ConfigurationSerializableSerializer implements SerializerObjectInterface<ConfigurationSerializable> {

    @Override
    public Class<ConfigurationSerializable> type() {
        return ConfigurationSerializable.class;
    }

    @Override
    public boolean isInterface() {
        return true;
    }

    @Override
    public YAPIONObject serialize(SerializeData<ConfigurationSerializable> serializeData) {
        YAPIONObject yapionObject = new YAPIONObject();
        yapionObject.add(TYPE_IDENTIFIER, type().getTypeName());
        Map<String, Object> serializeDataMap = serializeData.object.serialize();
        serializeDataMap.forEach((s, o) -> {
            yapionObject.add(s, serializeData.serialize(o));
        });
        return yapionObject;
    }

    @Override
    public ConfigurationSerializable deserialize(DeserializeData<YAPIONObject> deserializeData) {
        Map<String, Object> deserializeDataMap = new HashMap<>();
        deserializeData.object.forEach((s, yapionAnyType) -> {
            if (s.equals(TYPE_IDENTIFIER)) return;
            deserializeDataMap.put(s, deserializeData.deserialize(yapionAnyType));
        });
        return ConfigurationSerialization.deserializeObject(deserializeDataMap);
    }
}
