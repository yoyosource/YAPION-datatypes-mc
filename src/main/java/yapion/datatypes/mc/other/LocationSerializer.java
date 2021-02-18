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

import org.bukkit.Location;
import org.bukkit.World;
import yapion.hierarchy.types.YAPIONObject;
import yapion.serializing.api.SerializerObjectInterface;
import yapion.serializing.data.DeserializeData;
import yapion.serializing.data.SerializeData;

import static yapion.utils.IdentifierUtils.TYPE_IDENTIFIER;

public class LocationSerializer implements SerializerObjectInterface<Location> {

    @Override
    public Class<Location> type() {
        return Location.class;
    }

    @Override
    public YAPIONObject serialize(SerializeData<Location> serializeData) {
        YAPIONObject yapionObject = new YAPIONObject();
        yapionObject.add(TYPE_IDENTIFIER, type().getTypeName());
        yapionObject.add("world", serializeData.serialize(serializeData.object.getWorld()));
        yapionObject.add("x", serializeData.object.getX());
        yapionObject.add("y", serializeData.object.getY());
        yapionObject.add("z", serializeData.object.getZ());
        yapionObject.add("pitch", serializeData.object.getPitch());
        yapionObject.add("yaw", serializeData.object.getYaw());
        return yapionObject;
    }

    @Override
    public Location deserialize(DeserializeData<YAPIONObject> deserializeData) {
        World world = (World) deserializeData.deserialize(deserializeData.object.getObject("world"));
        double x = deserializeData.object.getPlainValue("x");
        double y = deserializeData.object.getPlainValue("y");
        double z = deserializeData.object.getPlainValue("z");
        float pitch = deserializeData.object.getPlainValue("pitch");
        float yaw = deserializeData.object.getPlainValue("yaw");
        return new Location(world, x, y, z, yaw, pitch);
    }
}
