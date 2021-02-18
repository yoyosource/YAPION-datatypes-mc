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

package yapion.datatypes.mc.other;

import org.bukkit.Bukkit;
import org.bukkit.World;
import yapion.hierarchy.types.YAPIONObject;
import yapion.hierarchy.types.YAPIONValue;
import yapion.serializing.api.SerializerObjectInterface;
import yapion.serializing.data.DeserializeData;
import yapion.serializing.data.SerializeData;

import java.util.UUID;

import static yapion.utils.IdentifierUtils.TYPE_IDENTIFIER;

public class WorldSerializer implements SerializerObjectInterface<World> {

    @Override
    public Class<World> type() {
        return World.class;
    }

    @Override
    public boolean isInterface() {
        return true;
    }

    @Override
    public YAPIONObject serialize(SerializeData<World> serializeData) {
        YAPIONObject yapionObject = new YAPIONObject();
        yapionObject.add(TYPE_IDENTIFIER, type().getTypeName());
        yapionObject.add("name", new YAPIONValue<>(serializeData.object.getName()));
        yapionObject.add("uid", serializeData.serialize(serializeData.object.getUID()));
        return yapionObject;
    }

    @Override
    public World deserialize(DeserializeData<YAPIONObject> deserializeData) {
        return Bukkit.getWorld((UUID) deserializeData.deserialize(deserializeData.object.getObject("uid")));
    }
}
