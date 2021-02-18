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

import org.bukkit.util.Vector;
import yapion.hierarchy.types.YAPIONObject;
import yapion.serializing.api.SerializerObjectInterface;
import yapion.serializing.data.DeserializeData;
import yapion.serializing.data.SerializeData;

import static yapion.utils.IdentifierUtils.TYPE_IDENTIFIER;

public class VectorSerializer implements SerializerObjectInterface<Vector> {

    @Override
    public Class<Vector> type() {
        return Vector.class;
    }

    @Override
    public YAPIONObject serialize(SerializeData<Vector> serializeData) {
        YAPIONObject yapionObject = new YAPIONObject();
        yapionObject.add(TYPE_IDENTIFIER, type().getTypeName());
        yapionObject.add("x", serializeData.object.getX());
        yapionObject.add("y", serializeData.object.getY());
        yapionObject.add("z", serializeData.object.getZ());
        return yapionObject;
    }

    @Override
    public Vector deserialize(DeserializeData<YAPIONObject> deserializeData) {
        Vector vector = new Vector();
        vector.setX(deserializeData.object.getPlainValue("x"));
        vector.setY(deserializeData.object.getPlainValue("y"));
        vector.setZ(deserializeData.object.getPlainValue("z"));
        return vector;
    }
}
